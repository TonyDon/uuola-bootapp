/*
 * @(#)MapperInterceptor.java 2018年9月9日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月9日
 * </pre>
 */
@Intercepts(@Signature(
            method = "prepare", 
            type = StatementHandler.class, 
            args = { Connection.class , Integer.class }
        ))
public class MapperInterceptor implements Interceptor {
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    /* (non-Javadoc)
     * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.Invocation)
     */
    @Override
    public Object intercept(Invocation invoc) throws Throwable {
        RoutingStatementHandler handler = (RoutingStatementHandler) invoc.getTarget();
        BoundSql boundSql = handler.getBoundSql();
        Object obj = boundSql.getParameterObject();
        String id = getStatementId(handler);
        logger.info("mapper intercept method : {}", invoc.getMethod().getName());
        logger.info("mapper sql: {}", boundSql.getSql());
        logger.info("parameter object : {}", obj.getClass().getName());
        logger.info("mapper statement id: {}", id);
        return invoc.proceed();
    }

    private String getStatementId(RoutingStatementHandler handler) {
        Field delegate = ReflectionUtils.findField(handler.getClass(), "delegate");
        if(null != delegate) {
            delegate.setAccessible(true);
            Object stBean = ReflectionUtils.getField(delegate, handler);
            if(stBean instanceof StatementHandler) {
                StatementHandler stHandler = (StatementHandler)stBean;
                Field mappedStatement = ReflectionUtils.findField(stHandler.getClass(), "mappedStatement");
                if(null != mappedStatement) {
                    mappedStatement.setAccessible(true);
                    Object msBean = ReflectionUtils.getField(mappedStatement, stHandler);
                    if(msBean instanceof MappedStatement) {
                        MappedStatement mappedStatment = (MappedStatement)msBean;
                        return mappedStatment.getId();
                    }
                }
            }
        }
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)
     */
    @Override
    public Object plugin(Object target) {
        logger.info("plugin target:{}", target.getClass().getName());
        if(target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        }else {
            return target;
        }
    }

    /* (non-Javadoc)
     * @see org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
     */
    @Override
    public void setProperties(Properties props) {
        // TODO Auto-generated method stub

    }

}

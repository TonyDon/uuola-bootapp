/*
 * @(#)ControllerMethodAop.java 2018年10月2日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.uuola.webapp.support.view.BaseQuery;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年10月2日
 * </pre>
 */
@Aspect
public class ControllerMethodAop {

    @Pointcut("execution(public * com.uuola.webapp.*.controller.*Controller.*(..))")
    public void doPointcut() {
    }
    
    @Before(value="doPointcut()")
    public void methodParamenter(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if(null == args || args.length==0) {
            return ;
        }
        if(args.length==1) {
            detectQueryAndDofilter(args[0]);
        }else {
            for(Object o : args) {
                detectQueryAndDofilter(o);
            }
        }
    }
    
    private void detectQueryAndDofilter(Object o) {
        if(o instanceof BaseQuery) {
            ((BaseQuery)o).filter();
        }
    }
}

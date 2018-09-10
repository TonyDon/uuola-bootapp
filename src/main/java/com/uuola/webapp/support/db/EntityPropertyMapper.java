/*
 * @(#)EntityPropertyMapper.java 2018年1月14日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support.db;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

/**
 * <pre>
 * jdbc 结果集转换实体映射器<br/>
 * 要求表SQL 列名只能全大写字符或小写字符，不能大小写字符混用，否则记录无法正确映射
 * @author tangxiaodong
 * 创建日期: 2018年1月13日
 * </pre>
 */
public class EntityPropertyMapper<T> implements RowMapper<T> {
    
    protected Logger log = LoggerFactory.getLogger(getClass());
    
    /**
     * 列名 与属性类关系
     */
    private Map<String, Field> mapperFields;
    
    /** 实体类 **/
    private Class<T> entityClass;
    
    public EntityPropertyMapper() {
        
    }
    
    @SuppressWarnings("unchecked")
    public EntityPropertyMapper(EntityDefine def) {
        this.entityClass = (Class<T>)def.getEntityClass();
        this.mapperFields = def.makeMapperFields();
    }

    /* (non-Javadoc)
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public T mapRow(ResultSet rs, int rowNum) throws SQLException {
        T mappedObject = BeanUtils.instantiateClass(this.entityClass);
        ResultSetMetaData rsmd = rs.getMetaData();
        int colsCount = rsmd.getColumnCount();
        for (int idx = 1; idx <= colsCount; idx++) {
            String column = JdbcUtils.lookupColumnName(rsmd, idx);
            Field targetField = mapperFields.get(column);
            if (null != targetField) {
                if (log.isDebugEnabled() && rowNum == 0) {
                    log.debug("Mapping column '" + column + "' to property '" + targetField.getName() +
                            "' of type '" + ClassUtils.getQualifiedName(targetField.getType()) + "'");
                }
                Object value = JdbcUtils.getResultSetValue(rs, idx, targetField.getType());
                if (null != value) {
                    ReflectionUtils.setField(targetField, mappedObject, value);
                }
            }
        }
        return mappedObject;
    }
    
    
    public static <T> EntityPropertyMapper<T> newInstance(EntityDefine def) {
        return new EntityPropertyMapper<T>(def);
    }

}
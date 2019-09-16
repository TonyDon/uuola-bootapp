/*
 * @(#)EntityPropColumnBean.java 2014-11-12
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support.db;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;

import com.google.common.collect.Maps;


/**
 * <pre>
 * 表实体定义对象
 * @author tangxiaodong
 * 创建日期: 2014-11-12
 * </pre>
 */
public class EntityDefine {
    
    /**
     * 实体类class
     */
    private Class<?> entityClass;

    /**
     * 对应表名称
     */
    private String tableName;
    
    /**
     * 实体属性名与表字段名关系
     */
    private Map<String, String> propColumnMap;
    
    /**
     * 实体属性名与属性类关系
     */
    private Map<String, Field> propFieldMap;
    
    /**
     * 主键属性名
     */
    private String uniqueKeyPropName;
    
    /**
     * 乐观锁版本属性名
     */
    private String versionPropName;

    
    public Class<?> getEntityClass() {
        return entityClass;
    }

    
    public void setEntityClass(Class<?> entityClass) {
        this.entityClass = entityClass;
    }

    
    public String getTableName() {
        return tableName;
    }

    
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    
    public Map<String, String> getPropColumnMap() {
        return propColumnMap;
    }

    
    public void setPropColumnMap(Map<String, String> propColumnMap) {
        this.propColumnMap = propColumnMap;
    }

    
    public Map<String, Field> getPropFieldMap() {
        return propFieldMap;
    }

    
    public void setPropFieldMap(Map<String, Field> propFieldMap) {
        this.propFieldMap = propFieldMap;
    }


    
    public String getUniqueKeyPropName() {
        return uniqueKeyPropName;
    }


    
    public void setUniqueKeyPropName(String uniqueKeyPropName) {
        this.uniqueKeyPropName = uniqueKeyPropName;
    }

    
    public String getVersionPropName() {
        return versionPropName;
    }


    
    public void setVersionPropName(String versionPropName) {
        this.versionPropName = versionPropName;
    }


    /**
     * 将column名称( 转为大写、小写名称）、属性名称 对应到字段对象
     * @return map
     */
    public Map<String, Field> makeMapperFields(){
        Map<String, Field> mapperFields = Maps.newHashMap();
        if(null != propFieldMap) {
            for(Map.Entry<String, String> pf : propColumnMap.entrySet()) {
                String prop = pf.getKey();
                Field field = propFieldMap.get(prop);
                String col = propColumnMap.get(prop);
                mapperFields.put(col.toLowerCase(Locale.US), field);
                mapperFields.put(col.toUpperCase(Locale.US), field);
                mapperFields.put(prop, field);
            }
        }
        return mapperFields;
    }
}

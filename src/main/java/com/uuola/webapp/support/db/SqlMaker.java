/*
 * @(#)SqlBuilder.java 2013-8-4
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support.db;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

import com.uuola.webapp.constants.CHAR;
import com.uuola.webapp.util.FieldUtil;
import com.uuola.webapp.util.StringUtil;




/**
 * <pre>
 * SQL 构建器
 * 可以手动输入表名，字段名列表，字段值列表构建语句，也可以通过实体对象构建
 * 用于插入和更新记录
 * @author tangxiaodong
 * 创建日期: 2013-8-4
 * </pre>
 */
public class SqlMaker{
    
    private String tableName;
    
    private List<String> sqlColumns;
            
    private List<Object> sqlParams;
    
    private Object entity;
    
    /**
     * 唯一字段名
     */
    private String uniqueColName;
    
    /**
     * 唯一字段值
     */
    private Object uniqueColValue;
    
    private Class<?> entityClass;
    
    public SqlMaker(){
        
    }
    
    public SqlMaker(Object entity){
        this.entity = entity;
    }
    
    /**
     * 通过实体定义构建SQL所需参数<br/>
     * 主键与非主键字段分别存储
     */
    public SqlMaker build(EntityDefine entityDef) {
        Assert.notNull(this.entity, "Entity must not be null!");
        this.entityClass = (Class<?>)entity.getClass();
        this.tableName = entityDef.getTableName();
        Map<String, Field> propNameFieldMap = entityDef.getPropFieldMap();
        Map<String, String> propNameColumnMap = entityDef.getPropColumnMap();
        sqlColumns = new ArrayList<String>();
        sqlParams = new ArrayList<Object>();
        Object uniquePropVal = null;
        String uniquePropName = entityDef.getUniqueKeyPropName();
        for (Map.Entry<String, Field> pf : propNameFieldMap.entrySet()) {
            String propName = pf.getKey();
            Field propField = pf.getValue();
            Object val = FieldUtil.getValue(propField, entity);
            String col = propNameColumnMap.get(propName);
            if (propName.equals(uniquePropName)) {
                uniquePropVal = val;
            } else if (null != val && null != col) {
                sqlColumns.add(col);
                sqlParams.add(val);
            }
        }
        if (null == uniqueColName && null != uniquePropVal) {
            uniqueColName = propNameColumnMap.get(uniquePropName);
            uniqueColValue = uniquePropVal;
        }
        return this;
    }
    
    /**
     * 构建SQL插入预处理语句，可以结合build方法使用，也可单独调用
     * @return
     */
    public String getInsertSql() {
        Assert.notNull(this.sqlColumns, "sqlColumns must not be null!");
        if (null != this.uniqueColName && null != this.uniqueColValue) {
            sqlColumns.add(this.uniqueColName);
            sqlParams.add(this.uniqueColValue);
        }
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(this.getTableName()).append("(");
        sql.append(StringUtil.join(this.sqlColumns, CHAR.CHAR_COMMA));
        sql.append(") VALUES (").append(StringUtil.getPlaceholder(this.sqlColumns.size())).append(")");
        return sql.toString();
    }
    
    /**
     * 构建SQL更新预处理语句，结合build方法使用<br/>
     * 如果不通过build方式，需要手动设置唯一列和值
     * @return
     */
    public String getUpdateSql() {
        Assert.notNull(this.uniqueColName, "uniqueColName must not be null!");
        Assert.notNull(this.uniqueColValue, "uniqueColValue must not be null!");
        StringBuilder sql = new StringBuilder("UPDATE ");
        sql.append(this.getTableName()).append(" SET ");
        int colCount = sqlColumns.size();
        int lastColIndex = colCount - 1;
        for (int k = 0; k < lastColIndex; k++) {
            sql.append(sqlColumns.get(k)).append("=?").append(",");
        }
        sql.append(sqlColumns.get(lastColIndex)).append("=?");
        sql.append(" WHERE ").append(this.uniqueColName).append("=?");
        sqlParams.add(this.uniqueColValue);// append where condition to last
        return sql.toString();
    }
    
    /**
     * 构建SQL删除预处理语句，结合build方法使用
     * @return
     */
    public String getDeleteSql() {
        StringBuilder sql = new StringBuilder("DELETE FROM ");
        sql.append(this.getTableName()).append(" WHERE ");
        if (StringUtil.isNotEmpty(uniqueColName) && null != uniqueColValue) {
            // 添加主键列名 和值
            sqlColumns.clear();
            sqlParams.clear();
            sqlColumns.add(uniqueColName);
            sqlParams.add(uniqueColValue);
        }
        Assert.notEmpty(this.sqlColumns, "");
        int count = this.sqlColumns.size();
        int lastColIndex = count - 1;
        for (int k = 0; k < lastColIndex; k++) {
            sql.append(this.sqlColumns.get(k)).append("=? and ");
        }
        sql.append(this.sqlColumns.get(lastColIndex)).append("=? ");
        return sql.toString();
    }

    /**
     * 根据object类型得到参数占位符个数
     * @param value
     * @return
     */
    public static int getSqlPlaceholderCount(Object value) {
        int placeNum = 1;
        if (value instanceof Collection) {
            placeNum = ((Collection<?>) value).size();
        } else if (value.getClass().isArray()) {
            placeNum = ((Object[]) value).length;
        }
        return placeNum;
    }
    
    public String getTableName() {
        return tableName;
    }

    
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    
    public List<Object> getSqlParams() {
        return sqlParams;
    }

    
    public void setSqlParams(List<Object> sqlParams) {
        this.sqlParams = sqlParams;
    }

    
    public Object getEntity() {
        return entity;
    }

    
    public void setEntity(Object entity) {
        this.entity = entity;
    }

    
    public String getUniqueColName() {
        return uniqueColName;
    }

    
    public void setUniqueColName(String uniqueColName) {
        this.uniqueColName = uniqueColName;
    }

    
    public Object getUniqueColValue() {
        return uniqueColValue;
    }

    
    public void setUniqueColValue(Object uniqueColValue) {
        this.uniqueColValue = uniqueColValue;
    }

    
    public List<String> getSqlColumns() {
        return sqlColumns;
    }

    
    public void setSqlColumns(List<String> sqlColumns) {
        this.sqlColumns = sqlColumns;
    }

    
    public Class<?> getEntityClass() {
        return entityClass;
    }

    
    public void setEntityClass(Class<?> entityClass) {
        this.entityClass = entityClass;
    }
    
    
}

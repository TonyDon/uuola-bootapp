/**
 * 
 */
package com.uuola.webapp.support.db;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月9日
 * </pre>
 */
public abstract class BaseDAO<T> {

    protected NamedParameterJdbcTemplate jdbcTemplate;
    
    protected SqlSessionTemplate sqlSessionTemplate;
    
    private EntityDefine entityDef;
    
    // 实体类
    private Class<T> entityClass;
    
    // entity 表名称
    private String tableName;
    
    // id列名称
    private String idColumnName;
    
    // 所属Mapper Namespace
    private String  mapperNamespace;
    
    // jdbcTemplate 数据行与实体属性映射mapper
    private RowMapper<T> entityPropertyRowMapper;
    
    @SuppressWarnings("unchecked")
    public BaseDAO() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) pt.getActualTypeArguments()[0];
        this.entityDef = EntityDefManager.getDef(entityClass);
        this.tableName = entityDef.getTableName();
        this.idColumnName = getIdColumn();
        this.mapperNamespace = this.getClass().getName();
        this.entityPropertyRowMapper = EntityPropertyMapper.newInstance(this.entityDef);
    }

    /**
     * 通过 ID查询一个实体对象<br/>
     * 约定 数据表中字段名称一定是id
     * @param id 可以是Number,String,
     * @return
     */
    public T findById(Serializable id) {
        String sql = "select * from " + this.tableName + " where " + idColumnName + "=? ";
        List<T> list = jdbcTemplate.getJdbcOperations().query(sql, new Object[] { id }, new RowMapperResultSetExtractor<T>(entityPropertyRowMapper, 1));
        return extractSingleObject(list);
    }
    
    /**
     * 通过 ID集合查询多个实体对象<br/>
     * 约定 数据表中字段名称一定是id
     * @param Collection<E> ids
     * @param id 可以是Number,String,
     * @return List<T>
     */
    public <E> List<T> findByIds(Collection<E> ids) {
        String sql = "select * from " + this.tableName + " where " + idColumnName +  " in (:ids)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ids", ids);
        List<T> list =  jdbcTemplate.query(sql, params,  new RowMapperResultSetExtractor<T>(entityPropertyRowMapper, ids.size()));
        return list;
    }
    
   
    /**
     * 删除一个实体
     * 约定 数据表中字段名称一定是id
     * @param id 可以是Number,String,
     * @return
     */
    public int delete(T entity) {
        SqlMaker sqlBuilder = new SqlMaker(entity).build(entityDef);
        List<Object> params = sqlBuilder.getSqlParams();
        return jdbcTemplate.getJdbcOperations().update(getPreparedStatementCreatorFactory(sqlBuilder.getDeleteSql(), params)
                .newPreparedStatementCreator(params));
    }

    /**
     * 通过ID删除记录
     * @param id
     * @return
     */
    public int deleteById(Serializable id) {
        String sql = "delete from " + this.tableName + " where " + idColumnName + "=? ";
        return jdbcTemplate.getJdbcOperations().update(sql, id);
    }
    
    /**
     * 通过ID集合删除记录
     * @param <E>
     * @param id
     * @return
     */
    public <E> int deleteByIds(Collection<E> ids) {
        String sql = "delete from " + this.tableName + " where " + idColumnName + " in (:ids)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ids", ids);
        return jdbcTemplate.update(sql, params);
    }

    /**
     * 插入一条记录
     * @return
     */
    public void insert(T entity) {
        SqlMaker sqlBuilder = new SqlMaker(entity).build(entityDef);
        List<Object> params = sqlBuilder.getSqlParams();
        PreparedStatementCreatorFactory pscFactory = getPreparedStatementCreatorFactory(sqlBuilder.getInsertSql(), params);
        //pscFactory.setGeneratedKeysColumnNames(new String[]{"id"});
        pscFactory.setReturnGeneratedKeys(true);// return auto-GenerateKey
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.getJdbcOperations().update(pscFactory.newPreparedStatementCreator(params), keyHolder);
        Number id = keyHolder.getKey();
        if (null != id) {
            Map<String, Field> propField = entityDef.getPropFieldMap();
            Field idField = propField.get("id");
            Assert.notNull(idField, "The id Field, Not found in [" + entity.getClass().getCanonicalName() + "]");
            Object idValue = getIdValueByNumber(id, idField.getType());
            ReflectionUtils.setField(idField, entity, idValue);
        }
    }

    /**
     * 更新一条记录
     * @return
     */
    public int update(T entity) {
        SqlMaker sqlBuilder = new SqlMaker(entity).build(entityDef);
        List<Object> params = sqlBuilder.getSqlParams();
        return jdbcTemplate.getJdbcOperations().update(getPreparedStatementCreatorFactory(sqlBuilder.getUpdateSql(), params)
                .newPreparedStatementCreator(params));
    }

    
    /**
     * 将Number值转为具体字段类型值(Integer or Long)
     * @param id
     * @param fieldType
     * @return
     */
    private Object getIdValueByNumber(Number id, Class<?> fieldType) {
        if (fieldType == Integer.class) {
            return id.intValue();
        } else {
            return id.longValue();
        }
    }
    
    
    /**
     * 得到 jdbcTemplate 预处理创建者工厂
     * @param sql
     * @param params
     * @return
     */
    private PreparedStatementCreatorFactory getPreparedStatementCreatorFactory(String sql, List<?> params){
        int[] types = getSqlParamsTypes(params);
        PreparedStatementCreatorFactory pscFactory = 
                new PreparedStatementCreatorFactory(sql, types);
        return pscFactory;
    }
    
    /**
     * 得到主键列名
     * @param entityClass
     * @return
     */
    public String getIdColumn(){
        String keyPropName = entityDef.getUniqueKeyPropName();
        Assert.hasLength(keyPropName, "not found uniqueKeyPropName at entity : " + entityClass.getCanonicalName());
        return entityDef.getPropColumnMap().get(keyPropName);
    }
    
    
    /**
     * 从集合中取出一个对象
     * @param results
     * @return
     */
    private  <E> E extractSingleObject(Collection<E> results) {
        int size = (results != null ? results.size() : 0);
        if(size == 0){
            return null;
        }
        return results.iterator().next();
    }

    /**
     * 获取SQL查询对象数组对应的SQL TYPE
     * @param params
     * @return
     */
    public int[] getSqlParamsTypes(List<?> params) {
        if(null == params || params.isEmpty()){
            return null;
        }
        int[] types = new int[params.size()];
        for(int i=0; i<params.size(); i++){
            types[i] = getObjectSqlType(params.get(i));
        }
       return types;
    }
    
    /**
     * 得到对象对应的常用SQL TYPE
     * @param o
     * @return
     */
    public int getObjectSqlType(Object o) {
        if (o == null) {
            return JdbcUtils.TYPE_UNKNOWN;
        }
        if (o instanceof String) {
            return Types.VARCHAR;
        }
        if( o instanceof java.util.Date){
            return Types.TIMESTAMP;
        }
        if (o instanceof Number) {
            if (o instanceof Long) {
                return Types.BIGINT;
            }
            if (o instanceof Integer) {
                return Types.INTEGER;
            }
            if (o instanceof Short) {
                return Types.SMALLINT;
            }
            if (o instanceof Byte) {
                return Types.TINYINT;
            }
            if (o instanceof BigDecimal) {
                return Types.DECIMAL;
            }
            if (o instanceof Double) {
                return Types.DOUBLE;
            }
        }
        return JdbcUtils.TYPE_UNKNOWN;
    }

    
    // *********************************************以下是对MYBATIS的方法封装 *****************

    /**
     * @param mapperId
     * @return
     */
    protected String convertMapperId(String mapperId) {
        return this.mapperNamespace + "." + mapperId;
    }
    
    
    /**
     *  Mybatis Update
     * @param mapperId
     * @param parameter
     * @return
     */
    public int updateByMapper(String mapperId, Object parameter){
        return this.sqlSessionTemplate.update(convertMapperId(mapperId), parameter);
    }
    
    /**
     * Mybatis Insert
     * @param mapperId
     * @param parameter
     * @return
     */
    public int insertByMapper(String mapperId, Object parameter){
        return this.sqlSessionTemplate.insert(convertMapperId(mapperId), parameter);
    }
    
    /**
     * Mybatis Select One Query
     * @param mapperId
     * @param parameter
     * @return
     */
    public <E> E selectOne(String mapperId, Object parameter){
        return this.sqlSessionTemplate.selectOne(convertMapperId(mapperId), parameter);
    }
    
    /**
     * Mybatis Select Collections Query
     * @param mapperId
     * @param parameter
     * @return
     */
    public <E> List<E> selectList(String mapperId, Object parameter){
        return this.sqlSessionTemplate.selectList(convertMapperId(mapperId), parameter);
    }
    
    /**
     * Mybatis Select Map Query, 指定map key ，结果将按key
     * @param mapperId
     * @param mapKey
     * @param parameter
     * @return
     */
    public <K, V> Map<K, V> selectMap(String mapperId, Object parameter, String mapKey){
        return this.sqlSessionTemplate.selectMap(convertMapperId(mapperId), parameter, mapKey);
    }
}

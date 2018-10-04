/*
 * @(#)CrudService.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support.db;

import java.io.Serializable;
import java.util.List;

import com.uuola.webapp.model.dto.Page;
import com.uuola.webapp.model.query.BaseQuery;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月23日
 * </pre>
 */
public interface CrudService<T> {

    /**
     * 通过主键ID获取记录
     * @param id
     * @return
     */
    T get(Serializable id);
    
    /**
     * 无分页条件查询所有记录
     * @param query
     * @return
     */
    List<T> list(BaseQuery query);
    
    /**
     * 通过实体对象（有值字段值全匹配）更新记录
     * @param entity
     * @return
     */
    int update(T entity);
    
    /**
     * 插入一条记录
     * @param entity
     */
    void insert(T entity);
    
    /**
     * 根据主键ID集合批量删除
     * @param ids
     * @return
     */
    int bulkDelete(List<?> ids);
    
    /**
     * 根据主键ID删除记录
     * @param id
     * @return
     */
    int deleteById(Serializable id);
    
    /**
     * 通过实体对象有值字段全匹配删除记录
     * @param entity
     * @return
     */
    int delete(T entity);
    
    /**
     * 返回条件查询记录数
     * @param query
     * @return
     */
    int count(BaseQuery query);
    
    /**
     * 带条件分页查询，并返回查询总数
     * @param query
     * @return Page
     */
    Page<T> rangePage(BaseQuery query);
    
    /**
     * 带条件范围查询
     * @param query
     * @return
     */
    List<T> range(BaseQuery query);
}

/*
 * @(#)BaseMapper.java 2018年9月8日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.dao;

import java.io.Serializable;
import java.util.List;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月8日
 * </pre>
 */
public interface BaseMapper<T, Q> {
    
    /**
     * 通过主键ID查询实体记录
     * @param <T>
     * @param id
     * @return
     */
    T get(Serializable id);
    
    /**
     * 无分页条件查询
     * @param query
     * @return
     */
    List<T> list(Q query);
    
    /**
     * 根据条件查询记录数量
     * @param query
     * @return
     */
    Integer count(Q query);
    
    /**
     * 根据条件分页获取记录
     * @param query
     * @return
     */
    List<T> fetchRange(Q query);
    
    /**
     * 更新记录
     * @param entity
     */
    void update(T entity);
    
    /**
     * 根据ID批量删除记录
     * @param id
     */
    void deleteByIds(List<Serializable> id);
    
    /**
     *  插入实体记录
     * @param entity
     */
    void insert(T entity);

}

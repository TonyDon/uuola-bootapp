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

    T get(Serializable id);
    
    List<T> list(BaseQuery query);
    
    int update(T entity);
    
    void insert(T entity);
    
    int bulkDelete(List<Serializable> ids);
    
    int deleteById(Serializable id);
    
    int delete(T entity);
    
    int count(BaseQuery query);
    
    Page<T> range(BaseQuery query);
}

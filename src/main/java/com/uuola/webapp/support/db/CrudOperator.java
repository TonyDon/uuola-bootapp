/*
 * @(#)CrudOperator.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support.db;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.uuola.webapp.support.view.BaseQuery;
import com.uuola.webapp.support.view.Page;

/**
 * <pre>
 * crud 操作封装
 * @author tonydon
 * 创建日期: 2018年9月23日
 * </pre>
 */
public abstract class CrudOperator<T>{
    
    @Autowired
    protected ApplicationContext ac;
    
    protected Logger log = LoggerFactory.getLogger(getClass());
    
    protected BaseDAO<T> crudDAO;
    
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void initCrudDAO(){
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<T> entityClass = (Class<T>) pt.getActualTypeArguments()[0];
        String daoName = StringUtils.uncapitalize(entityClass.getSimpleName()+"DAO");
        crudDAO =  ac.getBean(daoName, BaseDAO.class);
        if(log.isDebugEnabled()) {
            log.debug("CrudOperator() fetch CrudDAO success - {}", crudDAO.getClass().getName());
        }
    }

    public T get(Serializable id) {
        return crudDAO.findById(id);
    }

    public List<T> list(BaseQuery query) {
        return crudDAO.selectList("list", query);
    }

    public int update(T entity) {
        return crudDAO.update(entity);
    }

    public void insert(T entity) {
        crudDAO.insert(entity);
    }

    public int bulkDelete(List<?> ids) {
        return crudDAO.deleteByIds(ids);
    }
    
    public int delete(T entity) {
        return crudDAO.delete(entity);
    }
    
    public int deleteById(Serializable id) {
        return crudDAO.deleteById(id);
    }
    
    public int count(BaseQuery query) {
        return crudDAO.selectOne("count", query);
    }

    public Page<T> rangePage(BaseQuery query) {
        // 执行分页查询记录行计算
        query.calcCurrRowIndex();
        Integer total = crudDAO.selectOne("count", query);
        List<T> list = crudDAO.selectList("range", query);
        return Page.build(list, total).setPageNo(query.getPageNo()).setListSize(query.getListSize());
    }

    public List<T> range(BaseQuery query) {
        // 执行分页查询记录行计算
        query.calcCurrRowIndex();
        return crudDAO.selectList("range", query);
    }

}

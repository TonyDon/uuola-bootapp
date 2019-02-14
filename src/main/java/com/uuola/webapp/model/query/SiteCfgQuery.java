/*
 * @(#)SiteCfgQuery.java 2018年8月21日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.query;

import com.uuola.webapp.support.view.BaseQuery;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年8月21日
 * </pre>
 */
public class SiteCfgQuery extends BaseQuery{

    private Integer id;
    
    private String name;

    
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void filter() {
        // TODO Auto-generated method stub
        super.filter();
    }
}

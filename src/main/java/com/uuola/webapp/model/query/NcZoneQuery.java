/*
 * @(#)NcZoneQuery.java 2018年9月8日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.query;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月8日
 * </pre>
 */
public class NcZoneQuery extends BaseQuery{

    private Long id;
    
    private Integer zoneId;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Integer getZoneId() {
        return zoneId;
    }

    
    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }


    @Override
    public void filter() {
        // TODO Auto-generated method stub
        super.filter();
    }
}

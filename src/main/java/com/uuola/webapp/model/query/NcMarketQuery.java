/*
 * @(#)NcMarketQuery.java 2018年9月9日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.query;

import com.uuola.webapp.support.view.BaseQuery;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月9日
 * </pre>
 */
public class NcMarketQuery extends BaseQuery {
    
    private Long id;
    
    private Integer zoneId;
    
    private Integer marketId;
    

    @Override
    public void filter() {
        super.filter();
    }


    
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


    
    public Integer getMarketId() {
        return marketId;
    }


    
    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

}

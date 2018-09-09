/*
 * @(#)NcMarket.java 2018年9月9日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.entity;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月9日
 * </pre>
 */
public class NcMarket {

    private Long id;
    
    private String marketName;
    
    private Integer marketId;
    
    private Integer zoneId;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getMarketName() {
        return marketName;
    }

    
    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    
    public Integer getMarketId() {
        return marketId;
    }

    
    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    
    public Integer getZoneId() {
        return zoneId;
    }

    
    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }
}

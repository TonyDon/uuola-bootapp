/*
 * @(#)NcMarket.java 2018年9月9日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月9日
 * </pre>
 */
@Table
@Entity
public class NcMarket {

    @Id
    private Long id;
    
    @Column
    private String marketName;
    
    @Column
    private Integer marketId;
    
    @Column
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

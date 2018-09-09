/*
 * @(#)NcPriceStat.java 2018年9月9日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.entity;

import java.util.Date;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月9日
 * </pre>
 */
public class NcPriceStat {

    private Long id;
    
    private Integer catId;
    
    private Integer itemId;
    
    private Integer marketId;
    
    private Date statDate;
    
    private Integer unit;
    
    private Date createTime;
    
    private Double price;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Integer getCatId() {
        return catId;
    }

    
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    
    public Integer getItemId() {
        return itemId;
    }

    
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    
    public Integer getMarketId() {
        return marketId;
    }

    
    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    
    public Date getStatDate() {
        return statDate;
    }

    
    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    
    public Integer getUnit() {
        return unit;
    }

    
    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    
    public Date getCreateTime() {
        return createTime;
    }

    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    
    public Double getPrice() {
        return price;
    }


    
    public void setPrice(Double price) {
        this.price = price;
    }
}

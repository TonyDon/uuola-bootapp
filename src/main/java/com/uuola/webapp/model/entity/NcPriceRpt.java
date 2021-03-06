/*
 * @(#)NcPriceRpt.java 2018年9月9日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.entity;

import java.util.Date;

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
public class NcPriceRpt {
    
    @Id
    private Long id;
    
    @Column
    private Integer itemId;
    
    @Column
    private Integer zoneId;
    
    @Column
    private Integer year;
    
    @Column
    private Integer month;
    
    @Column
    private Integer statType;
    
    @Column
    private Double avgPrice;
    
    @Column
    private Double maxPrice;
    
    @Column
    private Double minPrice;
    
    @Column
    private Date createTime;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Integer getItemId() {
        return itemId;
    }

    
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    
    public Integer getZoneId() {
        return zoneId;
    }

    
    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    
    public Integer getYear() {
        return year;
    }

    
    public void setYear(Integer year) {
        this.year = year;
    }

    
    public Integer getMonth() {
        return month;
    }

    
    public void setMonth(Integer month) {
        this.month = month;
    }

    
    public Integer getStatType() {
        return statType;
    }

    
    public void setStatType(Integer statType) {
        this.statType = statType;
    }

    
    public Double getAvgPrice() {
        return avgPrice;
    }

    
    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    
    public Double getMaxPrice() {
        return maxPrice;
    }

    
    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    
    public Double getMinPrice() {
        return minPrice;
    }

    
    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    
    public Date getCreateTime() {
        return createTime;
    }

    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

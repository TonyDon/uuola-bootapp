/*
 * @(#)NcPriceRptQuery.java 2018年9月9日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.query;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月9日
 * </pre>
 */
public class NcPriceRptQuery extends BaseQuery {
    
    private Long id;
    
    private Integer itemId;
    
    private Integer zoneId;
    
    private Integer year;
    
    private Integer month;
    
    private Integer statType;

    @Override
    public void filter() {
        // TODO Auto-generated method stub
        super.filter();
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


    
    public Long getId() {
        return id;
    }


    
    public void setId(Long id) {
        this.id = id;
    }

}

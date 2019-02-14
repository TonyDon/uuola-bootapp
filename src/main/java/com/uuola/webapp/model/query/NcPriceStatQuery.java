/*
 * @(#)NcPriceStatQuery.java 2018年9月9日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.query;

import java.util.Date;

import com.uuola.webapp.support.view.BaseQuery;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月9日
 * </pre>
 */
public class NcPriceStatQuery extends BaseQuery {
    
    private Long id;
    
    private Integer catId;
    
    private Integer itemId;
    
    private Integer zoneId;
    
    private Integer marketId;
    
    private Date beginStatDate;
    
    private Date endStatDate;
    
    

    /* (non-Javadoc)
     * @see com.uuola.webapp.model.query.BaseQuery#filter()
     */
    @Override
    public void filter() {
        // TODO Auto-generated method stub
        super.filter();
    }



    
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



    
    public Date getBeginStatDate() {
        return beginStatDate;
    }



    
    public void setBeginStatDate(Date beginStatDate) {
        this.beginStatDate = beginStatDate;
    }



    
    public Date getEndStatDate() {
        return endStatDate;
    }



    
    public void setEndStatDate(Date endStatDate) {
        this.endStatDate = endStatDate;
    }

}

/*
 * @(#)NcInfoQuery.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.query;

import com.uuola.webapp.support.view.BaseQuery;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月23日
 * </pre>
 */
public class NcInfoQuery extends BaseQuery {

    /* (non-Javadoc)
     * @see com.uuola.webapp.model.query.BaseQuery#filter()
     */
    @Override
    public void filter() {
        // TODO Auto-generated method stub
        super.filter();
    }

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
    
}

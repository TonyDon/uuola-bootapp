/*
 * @(#)NcZone.java 2018年9月8日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.entity;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月8日
 * </pre>
 */
public class NcZone {

    private Long id;
    
    private String zoneName;
    
    private Integer zoneId;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getZoneName() {
        return zoneName;
    }

    
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    
    public Integer getZoneId() {
        return zoneId;
    }

    
    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }
}

/*
 * @(#)NcInfo.java 2018年9月23日
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
 * 创建日期: 2018年9月23日
 * </pre>
 */
@Table
@Entity
public class NcInfo {

    @Id
    private Long id;
    
    @Column
    private String title;
    
    @Column
    private String pubName;
    
    @Column
    private Date pubTime;
    
    @Column
    private Date endTime;
    
    @Column
    private Integer rtype;
    
    @Column
    private Integer pubState;
    
    @Column
    private String phone;
    
    @Column 
    private String email;
    
    @Column
    private String qq;
    
    @Column
    private String site;
    
    @Column
    private String address;
    
    @Column
    private String content;
    
    @Column
    private String picUrls;
    
    @Column
    private String clientIp;
    
    @Column
    private Long clickNum;
    
    @Column
    private Integer zoneId;
    
    @Column
    private Double geoLat;
    
    @Column
    private Double geoLon;
    
    @Column
    private Integer relateItemid;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

    
    public String getPubName() {
        return pubName;
    }

    
    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    
    public Date getPubTime() {
        return pubTime;
    }

    
    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    
    public Date getEndTime() {
        return endTime;
    }

    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    
    public Integer getRtype() {
        return rtype;
    }

    
    public void setRtype(Integer rtype) {
        this.rtype = rtype;
    }

    
    public Integer getPubState() {
        return pubState;
    }

    
    public void setPubState(Integer pubState) {
        this.pubState = pubState;
    }

    
    public String getPhone() {
        return phone;
    }

    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getQq() {
        return qq;
    }

    
    public void setQq(String qq) {
        this.qq = qq;
    }

    
    public String getSite() {
        return site;
    }

    
    public void setSite(String site) {
        this.site = site;
    }

    
    public String getAddress() {
        return address;
    }

    
    public void setAddress(String address) {
        this.address = address;
    }

    
    public String getContent() {
        return content;
    }

    
    public void setContent(String content) {
        this.content = content;
    }

    
    public String getPicUrls() {
        return picUrls;
    }

    
    public void setPicUrls(String picUrls) {
        this.picUrls = picUrls;
    }

    
    public String getClientIp() {
        return clientIp;
    }

    
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    
    public Long getClickNum() {
        return clickNum;
    }

    
    public void setClickNum(Long clickNum) {
        this.clickNum = clickNum;
    }

    
    public Integer getZoneId() {
        return zoneId;
    }

    
    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    
    public Double getGeoLat() {
        return geoLat;
    }

    
    public void setGeoLat(Double geoLat) {
        this.geoLat = geoLat;
    }

    
    public Double getGeoLon() {
        return geoLon;
    }

    
    public void setGeoLon(Double geoLon) {
        this.geoLon = geoLon;
    }

    
    public Integer getRelateItemid() {
        return relateItemid;
    }

    
    public void setRelateItemid(Integer relateItemid) {
        this.relateItemid = relateItemid;
    }
}

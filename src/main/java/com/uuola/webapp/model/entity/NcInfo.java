/*
 * @(#)NcInfo.java 2019-09-08 11:31:46
 * 
 * Copy Right@ uuola.com
 */ 

package com.uuola.webapp.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* <pre>
* 农产品供销信息
* @author tonydon
* by bootapp_skt_maker.py v1.0 generated
* at 2019-09-08 11:31:46 , table_name:nc_info
* </pre>
*/
@Table(name = "nc_info")
@Entity
public class NcInfo implements Serializable{

	private static final long serialVersionUID = -1567913506421517L;


            /**
            
        length:20 
            */   
            @Id
            private Long id;
            
            /**
            供求标题
        char length:50  
            */   
            @Column
            private String title;
            
            /**
            发布者姓名
        char length:10  
            */   
            @Column
            private String pubName;
            
            /**
            发布时间
         
            */   
            @Column
            private Date pubTime;
            
            /**
            中止时间，为空则为长期
         
            */   
            @Column
            private Date endTime;
            
            /**
            需求类型 1-供应，2-采购需求
        default:1 length:3 
            */   
            @Column
            private Integer rtype;
            
            /**
            有效1，无效0
        default:1 length:3 
            */   
            @Column
            private Integer pubState;
            
            /**
            联系电话
        char length:20  
            */   
            @Column
            private String phone;
            
            /**
            联系邮箱
        char length:50  
            */   
            @Column
            private String email;
            
            /**
            qq
        char length:20  
            */   
            @Column
            private String qq;
            
            /**
            网址
        char length:100  
            */   
            @Column
            private String site;
            
            /**
            省份ID
        length:10 
            */   
            @Column
            private Integer provinceId;
            
            /**
            城市ID
        length:10 
            */   
            @Column
            private Integer cityId;
            
            /**
            详细地址，市，县
        char length:100  
            */   
            @Column
            private String address;
            
            /**
            发布内容，不能超过1000字
        char length:1000  
            */   
            @Column
            private String content;
            
            /**
            附带图片,最多3张，url1|url2|url3
        char length:200  
            */   
            @Column
            private String picUrls;
            
            /**
            客户端IP
        char length:50  
            */   
            @Column
            private String clientIp;
            
            /**
            点击次数
        default:1 length:20 
            */   
            @Column
            private Long clickNum;
            
            /**
            区域ID
        length:10 
            */   
            @Column
            private Integer zoneId;
            
            /**
            位置纬度
        default:0.00000000 length:15 scale:8
            */   
            @Column
            private Double geoLat;
            
            /**
            位置经度
        default:0.00000000 length:15 scale:8
            */   
            @Column
            private Double geoLng;
            
            /**
            关联农作物ID
        length:10 
            */   
            @Column
            private Integer refItemId;
            
            /**
            创建时间
         
            */   
            @Column
            private Date createTime;
            
            /**
            更新时间
         
            */   
            @Column
            private Date updateTime;
            


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
            
            public Integer getProvinceId() {
                return provinceId;
            }
            
            public void setProvinceId(Integer provinceId) {
                this.provinceId = provinceId;
            }
            
            public Integer getCityId() {
                return cityId;
            }
            
            public void setCityId(Integer cityId) {
                this.cityId = cityId;
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
            
            public Double getGeoLng() {
                return geoLng;
            }
            
            public void setGeoLng(Double geoLng) {
                this.geoLng = geoLng;
            }
            
            public Integer getRefItemId() {
                return refItemId;
            }
            
            public void setRefItemId(Integer refItemId) {
                this.refItemId = refItemId;
            }
            
            public Date getCreateTime() {
                return createTime;
            }
            
            public void setCreateTime(Date createTime) {
                this.createTime = createTime;
            }
            
            public Date getUpdateTime() {
                return updateTime;
            }
            
            public void setUpdateTime(Date updateTime) {
                this.updateTime = updateTime;
            }
            
    
}

/*
 * @(#)BlogInfo.java 2018-10-04 14:40:07
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
* @author tonydon
* by make_bootapp_skt.py script generated
* at 2018-10-04 14:40:07 , table_name:blog_info
* </pre>
*/
@Table
@Entity
public class BlogInfo {

        
        @Id
        private Long id;
                
        @Column
        private String title;
                
        @Column
        private String summary;
                
        @Column
        private String keywords;
                
        @Column
        private Date pubTime;
                
        @Column
        private String mainPicUrl;
                
        @Column
        private String extPicUrls;
                
        @Column
        private String vodUrl;
                
        @Column
        private String downUrl;
                
        @Column
        private String redirectUrl;
                
        @Column
        private Integer cid;
                
        @Column
        private Integer funcType;
                
        @Column
        private Integer conType;
                
        @Column
        private Integer conState;
                
        @Column
        private Long clickNum;
                
        @Column
        private Date createTime;
                
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
        
        public String getSummary() {
            return summary;
        }
        
        public void setSummary(String summary) {
            this.summary = summary;
        }
        
        public String getKeywords() {
            return keywords;
        }
        
        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }
        
        public Date getPubTime() {
            return pubTime;
        }
        
        public void setPubTime(Date pubTime) {
            this.pubTime = pubTime;
        }
        
        public String getMainPicUrl() {
            return mainPicUrl;
        }
        
        public void setMainPicUrl(String mainPicUrl) {
            this.mainPicUrl = mainPicUrl;
        }
        
        public String getExtPicUrls() {
            return extPicUrls;
        }
        
        public void setExtPicUrls(String extPicUrls) {
            this.extPicUrls = extPicUrls;
        }
        
        public String getVodUrl() {
            return vodUrl;
        }
        
        public void setVodUrl(String vodUrl) {
            this.vodUrl = vodUrl;
        }
        
        public String getDownUrl() {
            return downUrl;
        }
        
        public void setDownUrl(String downUrl) {
            this.downUrl = downUrl;
        }
        
        public String getRedirectUrl() {
            return redirectUrl;
        }
        
        public void setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
        }
        
        public Integer getCid() {
            return cid;
        }
        
        public void setCid(Integer cid) {
            this.cid = cid;
        }
        
        public Integer getFuncType() {
            return funcType;
        }
        
        public void setFuncType(Integer funcType) {
            this.funcType = funcType;
        }
        
        public Integer getConType() {
            return conType;
        }
        
        public void setConType(Integer conType) {
            this.conType = conType;
        }
        
        public Integer getConState() {
            return conState;
        }
        
        public void setConState(Integer conState) {
            this.conState = conState;
        }
        
        public Long getClickNum() {
            return clickNum;
        }
        
        public void setClickNum(Long clickNum) {
            this.clickNum = clickNum;
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

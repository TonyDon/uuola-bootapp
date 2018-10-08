/*
 * @(#)BlogInfoQuery.java 2018-10-08 18:38:01
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.query;

import java.util.Date;

/**
 * <pre>
 *
 * @author tonydon
 * by make_bootapp_skt.py script generated
 * at 2018-10-08 18:38:01
 * </pre>
 */
public class BlogInfoQuery extends BaseQuery {

    @Override
    public void filter() {
        super.filter();
    }


        private Long id;
        
        private String title;
        
        private String summary;
        
        private String keywords;
        
        private Date pubTime;
        
        private String mainPicUrl;
        
        private String extPicUrls;
        
        private String vodUrl;
        
        private String downUrl;
        
        private String redirectUrl;
        
        private Integer cid;
        
        private Integer funcType;
        
        private Integer conType;
        
        private Integer conState;
        
        private Long clickNum;
        
        private Date createTime;
        
        private Date beginCreateTime;
        
        private Date endCreateTime;
        
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
        
        public Date getBeginCreateTime() {
            return beginCreateTime;
        }
    
        public void setBeginCreateTime(Date beginCreateTime) {
            this.beginCreateTime = beginCreateTime;
        }
    
        public Date getEndCreateTime() {
            return endCreateTime;
        }
    
        public void setEndCreateTime(Date endCreateTime) {
            this.endCreateTime = endCreateTime;
        }
        
        public Date getUpdateTime() {
            return updateTime;
        }
        
        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }
        
    
}

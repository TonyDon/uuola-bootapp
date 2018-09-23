/*
 * @(#)BlogInfo.java 2018年9月23日
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
public class BlogInfo {

    @Id
    private Long id;
    
    @Column
    private String title;
    
    @Column
    private String titlePinyin;
    
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
    private Integer cid;
    
    @Column
    private String cidPath;
    
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

    
    public String getTitlePinyin() {
        return titlePinyin;
    }

    
    public void setTitlePinyin(String titlePinyin) {
        this.titlePinyin = titlePinyin;
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

    
    public Integer getCid() {
        return cid;
    }

    
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    
    public String getCidPath() {
        return cidPath;
    }

    
    public void setCidPath(String cidPath) {
        this.cidPath = cidPath;
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

/*
 * @(#)CatalogCfg.java 2018年9月9日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.entity;

import java.util.Date;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月9日
 * </pre>
 */
public class CatalogCfg {

    private Integer id;
    
    private Integer siteId;
    
    private String zhName;
    
    private String code;
    
    private String pyName;
    
    private String cidPath;
    
    private Integer pid;
    
    private Integer state;
    
    private Long listNo;
    
    private String extCode;
    
    private String extImgUrl;
    
    private Date createTime;
    
    private Date updateTime;
    
    private String createUser;
    
    private String updateUser;

    
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    
    public Integer getSiteId() {
        return siteId;
    }

    
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    
    public String getZhName() {
        return zhName;
    }

    
    public void setZhName(String zhName) {
        this.zhName = zhName;
    }

    
    public String getCode() {
        return code;
    }

    
    public void setCode(String code) {
        this.code = code;
    }

    
    public String getPyName() {
        return pyName;
    }

    
    public void setPyName(String pyName) {
        this.pyName = pyName;
    }

    
    public String getCidPath() {
        return cidPath;
    }

    
    public void setCidPath(String cidPath) {
        this.cidPath = cidPath;
    }

    
    public Integer getPid() {
        return pid;
    }

    
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    
    public Integer getState() {
        return state;
    }

    
    public void setState(Integer state) {
        this.state = state;
    }

    
    public Long getListNo() {
        return listNo;
    }

    
    public void setListNo(Long listNo) {
        this.listNo = listNo;
    }

    
    public String getExtCode() {
        return extCode;
    }

    
    public void setExtCode(String extCode) {
        this.extCode = extCode;
    }

    
    public String getExtImgUrl() {
        return extImgUrl;
    }

    
    public void setExtImgUrl(String extImgUrl) {
        this.extImgUrl = extImgUrl;
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

    
    public String getCreateUser() {
        return createUser;
    }

    
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    
    public String getUpdateUser() {
        return updateUser;
    }

    
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    
}

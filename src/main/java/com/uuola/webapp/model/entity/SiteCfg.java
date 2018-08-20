/*
 * @(#)SiteCfg.java 2018年8月21日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.entity;

import java.util.Date;

import javax.persistence.Table;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年8月21日
 * </pre>
 */
@Table(name="site_cfg")
public class SiteCfg {

    private Integer id;
    
    private String name;
    
    private Integer state;
    
    private String pyName;
    
    private String usName;
    
    private String extImgUrl;
    
    private Date createTime;
    
    private Date updateTime;
    
    private String createUser;
    
    private String updateUser;
    
    private Long listNo;
    
    private Integer isDel;

    
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public Integer getState() {
        return state;
    }

    
    public void setState(Integer state) {
        this.state = state;
    }

    
    public String getPyName() {
        return pyName;
    }

    
    public void setPyName(String pyName) {
        this.pyName = pyName;
    }

    
    public String getUsName() {
        return usName;
    }

    
    public void setUsName(String usName) {
        this.usName = usName;
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

    
    public Long getListNo() {
        return listNo;
    }

    
    public void setListNo(Long listNo) {
        this.listNo = listNo;
    }

    
    public Integer getIsDel() {
        return isDel;
    }

    
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}

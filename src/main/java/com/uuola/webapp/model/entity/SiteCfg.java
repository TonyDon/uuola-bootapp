/*
 * @(#)SiteCfg.java 2018年8月21日
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
 * 创建日期: 2018年8月21日
 * </pre>
 */
@Table
@Entity
public class SiteCfg {

    @Id
    private Integer id;
    
    @Column
    private String name;
    
    @Column
    private Integer state;
    
    @Column
    private String pyName;
    
    @Column
    private String usName;
    
    @Column
    private String extImgUrl;
    
    @Column
    private Date createTime;
    
    @Column
    private Date updateTime;
    
    @Column
    private String createUser;
    
    @Column
    private String updateUser;
    
    @Column
    private Long listNo;

    
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


}

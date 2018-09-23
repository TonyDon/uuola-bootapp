/*
 * @(#)SysCfg.java 2018年9月23日
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
public class SysCfg {

    @Id
    private Integer id;
    
    @Column
    private String name;
    
    @Column
    private String cfgVal;
    
    @Column
    private Integer cfgState;
    
    @Column
    private String cfgType;
    
    @Column
    private Date createTime;
    
    @Column
    private Date updateTime;
    
    @Column
    private String remark;

    
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

    
    public String getCfgVal() {
        return cfgVal;
    }

    
    public void setCfgVal(String cfgVal) {
        this.cfgVal = cfgVal;
    }

    
    public Integer getCfgState() {
        return cfgState;
    }

    
    public void setCfgState(Integer cfgState) {
        this.cfgState = cfgState;
    }

    
    public String getCfgType() {
        return cfgType;
    }

    
    public void setCfgType(String cfgType) {
        this.cfgType = cfgType;
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

    
    public String getRemark() {
        return remark;
    }

    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    
}

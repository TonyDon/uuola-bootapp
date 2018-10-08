/*
 * @(#)BlogPost.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月23日
 * </pre>
 */
@Table
@Entity
public class BlogPost {

    @Id
    private Long id;
    
    @Column
    private String content;
    
    @Column
    private String script;
    
    @Column
    private Date createTime;
    
    @Column
    private Date updateTime;
    
    @Transient
    private String sid;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getContent() {
        return content;
    }

    
    public void setContent(String content) {
        this.content = content;
    }

    
    public String getScript() {
        return script;
    }

    
    public void setScript(String script) {
        this.script = script;
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

    
    public String getSid() {
        return sid;
    }

    
    public void setSid(String sid) {
        this.sid = sid;
    }
    
    /**
     * 将ID转为字符串SID
     */
    public void configSid() {
        if(null != id) {
            this.sid = String.valueOf(id);
        }
    }
}

/*
 * @(#)AdminDTO.java 2018年10月6日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.dto;

import java.util.Date;

import com.uuola.webapp.util.JsonUtil;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年10月6日
 * </pre>
 */
public class AdminDTO {

    private String name;
    
    private Date loginTime;

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public Date getLoginTime() {
        return loginTime;
    }

    
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }


    @Override
    public String toString() {
        return JsonUtil.parseJSON(this);
    }
    
    
}

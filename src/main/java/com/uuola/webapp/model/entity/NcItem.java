/*
 * @(#)NcItem.java 2018年9月9日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月9日
 * </pre>
 */
@Table
@Entity
public class NcItem {

    @Id
    private Long id;
    
    @Column
    private String itemName;
    
    @Column
    private Integer itemId;
    
    @Column
    private Integer catId;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getItemName() {
        return itemName;
    }

    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    
    public Integer getItemId() {
        return itemId;
    }

    
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    
    public Integer getCatId() {
        return catId;
    }

    
    public void setCatId(Integer catId) {
        this.catId = catId;
    }
    
    
}

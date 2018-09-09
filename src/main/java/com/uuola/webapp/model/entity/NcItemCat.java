/*
 * @(#)NcItemCat.java 2018年9月9日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.entity;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月9日
 * </pre>
 */
public class NcItemCat {
    
    private Long id;
    
    private String catName;
    
    private Integer catId;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getCatName() {
        return catName;
    }

    
    public void setCatName(String catName) {
        this.catName = catName;
    }

    
    public Integer getCatId() {
        return catId;
    }

    
    public void setCatId(Integer catId) {
        this.catId = catId;
    }
    
    

}

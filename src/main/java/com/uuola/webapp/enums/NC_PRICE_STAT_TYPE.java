/*
 * @(#)NC_PRICE_STAT_TYPE.java 2018年9月12日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.enums;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年9月12日
 * </pre>
 */
public enum NC_PRICE_STAT_TYPE {

    year(2),
    
    month(1);
    
    private Integer value;
    
    NC_PRICE_STAT_TYPE(Integer value){
        this.value = value;
    }
    
    public Integer intVal() {
        return this.value;
    }
}

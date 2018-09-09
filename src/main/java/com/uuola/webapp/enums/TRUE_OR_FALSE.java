/*
 * @(#)TRUE_OR_FALSE.java 2018年9月9日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.enums;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月9日
 * </pre>
 */
public enum TRUE_OR_FALSE {

    T(1),
    
    F(0);
    
    Integer value;
    
    TRUE_OR_FALSE(Integer value){
        this.value = value;
    }
    
    public Integer intVal() {
        return this.value;
    }
}

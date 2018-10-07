/*
 * @(#)SysCfgService.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.uuola.webapp.model.entity.SysCfg;
import com.uuola.webapp.support.db.CrudService;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月23日
 * </pre>
 */
public interface SysCfgService extends CrudService<SysCfg> {

    SysCfg getByName(String name);
    
    Number getNumber(String name);
    
    String getText(String name);
    
    Boolean getBool(String name);
    
    <T> List<T> getList(String name);
    
    <K, V> Map<K, V> getDict(String name);
    
    <E> Set<E> getSet(String name);
}

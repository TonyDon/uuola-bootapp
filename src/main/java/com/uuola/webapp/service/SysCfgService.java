/*
 * @(#)SysCfgService.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service;

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
}

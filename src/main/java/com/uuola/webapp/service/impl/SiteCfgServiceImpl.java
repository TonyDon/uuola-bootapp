/*
 * @(#)SiteCfgServiceImpl.java 2018年8月21日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import org.springframework.stereotype.Service;

import com.uuola.webapp.model.entity.SiteCfg;
import com.uuola.webapp.service.SiteCfgService;
import com.uuola.webapp.support.db.CrudOperator;
import com.uuola.webapp.support.db.PrimaryTx;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年8月21日
 * </pre>
 */
@Service
@PrimaryTx
public class SiteCfgServiceImpl extends CrudOperator<SiteCfg> implements SiteCfgService {

}

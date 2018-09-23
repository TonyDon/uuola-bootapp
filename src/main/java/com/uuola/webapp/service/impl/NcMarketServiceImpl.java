/*
 * @(#)NcMarketServiceImpl.java 2018年9月10日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import org.springframework.stereotype.Service;

import com.uuola.webapp.model.entity.NcMarket;
import com.uuola.webapp.service.NcMarketService;
import com.uuola.webapp.support.db.CrudOperator;
import com.uuola.webapp.support.db.PrimaryTx;


/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年9月10日
 * </pre>
 */
@Service
@PrimaryTx
public class NcMarketServiceImpl extends CrudOperator<NcMarket> implements NcMarketService {

    
}

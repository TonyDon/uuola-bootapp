/*
 * @(#)NcInfoServiceImpl.java 2019-09-08 11:31:46
 * 
 * Copy Right@ uuola.com
 */ 
package com.uuola.webapp.service.impl;

import org.springframework.stereotype.Service;

import com.uuola.webapp.model.entity.NcInfo;
import com.uuola.webapp.service.NcInfoService;
import com.uuola.webapp.support.db.CrudOperator;
import com.uuola.webapp.support.db.PrimaryTx;


/**
 * <pre>
 * 农产品供销信息
 * @author tonydon
 * by bootapp_skt_maker.py v1.0 generated
 * at 2019-09-08 11:31:46
 * </pre>
 */
@Service
@PrimaryTx
public class NcInfoServiceImpl extends CrudOperator<NcInfo> implements NcInfoService {

}

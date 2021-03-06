/*
 * @(#)BlogInfoServiceImpl.java 2018-10-04 14:40:07
 * 
 * Copy Right@ uuola
 */ 
package com.uuola.webapp.service.impl;

import org.springframework.stereotype.Service;

import com.uuola.webapp.model.entity.BlogInfo;
import com.uuola.webapp.service.BlogInfoService;
import com.uuola.webapp.support.db.CrudOperator;
import com.uuola.webapp.support.db.PrimaryTx;


/**
 * <pre>
 *
 * @author tonydon
 * by make_bootapp_skt.py script generated
 * at 2018-10-04 14:40:07
 * </pre>
 */
@Service
@PrimaryTx
public class BlogInfoServiceImpl extends CrudOperator<BlogInfo> implements BlogInfoService {

}

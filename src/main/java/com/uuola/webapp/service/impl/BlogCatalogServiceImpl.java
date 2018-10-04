/*
 * @(#)BlogCatalogServiceImpl.java 2018-10-04 14:33:34
 * 
 * Copy Right@ uuola
 */ 
package com.uuola.webapp.service.impl;

import org.springframework.stereotype.Service;

import com.uuola.webapp.model.entity.BlogCatalog;
import com.uuola.webapp.service.BlogCatalogService;
import com.uuola.webapp.support.db.CrudOperator;
import com.uuola.webapp.support.db.PrimaryTx;


/**
 * <pre>
 *
 * @author tonydon
 * by make_bootapp_skt.py script generated
 * at 2018-10-04 14:33:34
 * </pre>
 */
@Service
@PrimaryTx
public class BlogCatalogServiceImpl extends CrudOperator<BlogCatalog> implements BlogCatalogService {

}

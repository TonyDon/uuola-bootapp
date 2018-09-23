/*
 * @(#)BlogPostServiceImpl.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import org.springframework.stereotype.Service;

import com.uuola.webapp.model.entity.BlogPost;
import com.uuola.webapp.service.BlogPostService;
import com.uuola.webapp.support.db.CrudOperator;
import com.uuola.webapp.support.db.PrimaryTx;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月23日
 * </pre>
 */
@Service
@PrimaryTx
public class BlogPostServiceImpl extends CrudOperator<BlogPost> implements BlogPostService {

}

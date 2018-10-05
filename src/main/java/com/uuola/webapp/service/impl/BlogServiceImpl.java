/*
 * @(#)BlogServiceImpl.java 2018年10月5日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.webapp.model.dto.BlogDTO;
import com.uuola.webapp.service.BlogInfoService;
import com.uuola.webapp.service.BlogPostService;
import com.uuola.webapp.service.BlogService;
import com.uuola.webapp.support.db.PrimaryTx;
import com.uuola.webapp.util.DateUtil;
import com.uuola.webapp.util.IdGenerator;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年10月5日
 * </pre>
 */
@Service
@PrimaryTx
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogInfoService blogInfoService;
    
    @Autowired
    private BlogPostService blogPostService;
    
    @Override
    public Long create(BlogDTO blog) {
        Long id = IdGenerator.INSTANCE.nextId();
        blog.setBlogId(id);
        blog.getInfo().setCreateTime(DateUtil.getNowTime());
        blog.getPost().setCreateTime(blog.getInfo().getCreateTime());
        blogInfoService.insert(blog.getInfo());
        blogPostService.insert(blog.getPost());
        return id;
    }

}

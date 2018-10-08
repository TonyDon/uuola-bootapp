/*
 * @(#)BlogServiceImpl.java 2018年10月5日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.webapp.model.dto.BlogDTO;
import com.uuola.webapp.model.entity.BlogInfo;
import com.uuola.webapp.model.entity.BlogPost;
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

    @Override
    public BlogDTO get(Long id) {
        BlogDTO blog = new BlogDTO();
        BlogInfo info =blogInfoService.get(id);
        if(null != info) {
            blog.setInfo(info);
            BlogPost post = blogPostService.get(id);
            if(null != post) {
                blog.setPost(post);
            }
        }
        return blog;
    }

    @Override
    public int update(BlogDTO blog) {
        int num = 0;
        if (null != blog.getInfo()) {
            blog.getInfo().setUpdateTime(DateUtil.getNowTime());
            num += blogInfoService.update(blog.getInfo());
        }
        if (null != blog.getPost()) {
            blog.getPost().setUpdateTime(DateUtil.getNowTime());
            num += blogPostService.update(blog.getPost());
        }
        return num;
    }

    @Override
    public int bulkDelete(List<Long> ids) {
        int num = 0;
        num += blogInfoService.bulkDelete(ids);
        num += blogPostService.bulkDelete(ids);
        return num;
    }

}

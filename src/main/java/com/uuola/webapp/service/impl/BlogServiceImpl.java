/*
 * @(#)BlogServiceImpl.java 2018年10月5日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uuola.webapp.model.dto.BlogDTO;
import com.uuola.webapp.model.entity.BlogCatalog;
import com.uuola.webapp.model.entity.BlogInfo;
import com.uuola.webapp.model.entity.BlogPost;
import com.uuola.webapp.model.query.BlogInfoQuery;
import com.uuola.webapp.service.BlogCatalogService;
import com.uuola.webapp.service.BlogInfoService;
import com.uuola.webapp.service.BlogPostService;
import com.uuola.webapp.service.BlogService;
import com.uuola.webapp.support.db.PrimaryTx;
import com.uuola.webapp.support.view.Page;
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
    
    @Autowired
    private BlogCatalogService blogCatalogService;
    
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
            BlogCatalog blogCatalog = blogCatalogService.get(info.getCid());
            if(null != blogCatalog) {
                blog.setBlogCatalog(blogCatalog);
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

    @Override
    public Page<BlogInfo> findBlogInfoBy(BlogInfoQuery query) {
        Page<BlogInfo> pageData = blogInfoService.rangePage(query);
        if(Objects.nonNull(query.getCid())) {
            BlogCatalog blogCatalog = blogCatalogService.get(query.getCid());
            if(Objects.nonNull(blogCatalog)) {
                pageData.addExtraAttr("blogCatalog", blogCatalog);
            }
        }
        return pageData;
    }

    @Override
    public List<BlogInfo> findRecommended(BlogInfoQuery query) {
        return blogInfoService.list(query);
    }

}

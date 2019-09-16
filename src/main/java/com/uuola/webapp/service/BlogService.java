/*
 * @(#)BlogService.java 2018年10月5日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.service;

import java.util.List;

import com.uuola.webapp.model.dto.BlogDTO;
import com.uuola.webapp.model.entity.BlogInfo;
import com.uuola.webapp.model.query.BlogInfoQuery;
import com.uuola.webapp.support.view.Page;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年10月5日
 * </pre>
 */
public interface BlogService {

    /**
     * 创建BLOG
     * @param blog
     * @return blog id
     */
    Long create(BlogDTO blog);

    BlogDTO get(Long id);

    int update(BlogDTO blog);

    int bulkDelete(List<Long> ids);

    Page<BlogInfo> findBlogInfoBy(BlogInfoQuery query);
    
    List<BlogInfo> findRecommended(BlogInfoQuery query);
    
}

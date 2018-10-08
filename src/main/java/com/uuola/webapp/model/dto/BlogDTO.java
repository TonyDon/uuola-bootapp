/*
 * @(#)BlogDTO.java 2018年10月5日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.model.dto;

import com.uuola.webapp.model.entity.BlogInfo;
import com.uuola.webapp.model.entity.BlogPost;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年10月5日
 * </pre>
 */
public class BlogDTO {

    private BlogInfo info;
    
    
    private BlogPost post;


    
    public BlogInfo getInfo() {
        return info;
    }


    
    public void setInfo(BlogInfo info) {
        this.info = info;
    }


    
    public BlogPost getPost() {
        return post;
    }


    
    public void setPost(BlogPost post) {
        this.post = post;
    }
    
    public void setBlogId(Long id) {
        if(null != info) {
            info.setId(id);
        }
        if(null != post) {
            post.setId(id);
        }
    }
}

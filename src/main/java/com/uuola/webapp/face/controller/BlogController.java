/*
 * @(#)BlogController.java 2018年11月10日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.face.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.webapp.enums.TRUE_OR_FALSE;
import com.uuola.webapp.model.dto.BlogDTO;
import com.uuola.webapp.model.entity.BlogCatalog;
import com.uuola.webapp.model.entity.BlogInfo;
import com.uuola.webapp.model.query.BlogCatalogQuery;
import com.uuola.webapp.model.query.BlogInfoQuery;
import com.uuola.webapp.service.BlogCatalogService;
import com.uuola.webapp.service.BlogService;
import com.uuola.webapp.support.view.BaseController;
import com.uuola.webapp.support.view.Page;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年11月10日
 * </pre>
 */
@RestController("FaceBlogController")
@RequestMapping("/blog")
public class BlogController extends BaseController {
    
    @Autowired
    BlogService blogService;
    
    @Autowired
    BlogCatalogService blogCatalogService;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mv = makeModelView();
        BlogCatalogQuery query = new BlogCatalogQuery();
        query.setState(TRUE_OR_FALSE.T.intVal());
        List<BlogCatalog> blogCatalogs = blogCatalogService.list(query);
        mv.addObject("blogCatalogs", blogCatalogs);
        return mv;
    }
    
    @GetMapping("/list/{cid}/{listSize}/{pageNo}/{cname}")
    public ModelAndView list(@PathVariable("cid") Integer cid, @PathVariable("listSize") Integer listSize, @PathVariable("pageNo") Integer pageNo) {
        BlogInfoQuery query = new BlogInfoQuery();
        query.setCid(cid);
        query.setListSize(listSize);
        query.setPageNo(pageNo);
        query.filter();
        ModelAndView mv = makeModelView();
        Page<BlogInfo> pageData = blogService.findBlogInfoBy(query);
        mv.addObject("pageData", pageData);
        return mv;
    }
    
    @GetMapping("/{id}/{title}")
    public ModelAndView show(@PathVariable("id") Long id) {
        ModelAndView mv = makeModelView();
        BlogDTO blog = blogService.get(id);
        BlogInfoQuery query = new BlogInfoQuery();
        query.setCid(blog.getBlogCatalog().getId());
        List<BlogInfo> recomm = blogService.findRecommended(query);
        mv.addObject("blog", blog);
        mv.addObject("recomm", recomm);
        return mv;
    }
}

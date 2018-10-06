/*
 * @(#)WebAppMvcConfig.java 2018年9月24日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.uuola.webapp.support.view.AdminAccessInterceptor;
import com.uuola.webapp.support.view.ViewInterceptor;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月24日
 * </pre>
 */
@Configuration
public class WebAppMvcConfig implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ViewInterceptor());
        registry.addInterceptor(new AdminAccessInterceptor()).addPathPatterns("/admin-console/**")
                .excludePathPatterns("/admin-console/login*", "/admin-console/imagecode");
    }
    
}

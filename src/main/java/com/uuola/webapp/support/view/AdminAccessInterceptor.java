/*
 * @(#)AdminAccessInterceptor.java 2018年10月6日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;


/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年10月6日
 * </pre>
 */
public class AdminAccessInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
        return true;
    }

}

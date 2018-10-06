/*
 * @(#)AdminAccessInterceptor.java 2018年10月6日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.uuola.webapp.constants.Constants;


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
        HttpSession sn = request.getSession(false);
        if(null == sn || null == sn.getAttribute(Constants.SESSION_ADMIN)) {
            response.sendRedirect(request.getContextPath()+"/admin-console/login.html");
            return false;
        }
        return true;
    }

}

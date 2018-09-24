package com.uuola.webapp.support.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月24日
 * </pre>
 */
public class ViewInterceptor implements HandlerInterceptor{

    private Logger log = LoggerFactory.getLogger(ViewInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // 如果存在视图模型，但没有设置视图名称，则根据控制器方法名称自动设置视图路径
        if (null != modelAndView && StringUtils.isEmpty(modelAndView.getViewName())) {
            if (handler instanceof HandlerMethod) {
                HandlerMethod hm = (HandlerMethod) handler;
                Object controller = hm.getBean();
                if (controller instanceof BaseController) {
                    BaseController action = (BaseController) controller;
                    String methodName = hm.getMethod().getName();
                    modelAndView.setViewName(action.getViewName(methodName));
                }
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}

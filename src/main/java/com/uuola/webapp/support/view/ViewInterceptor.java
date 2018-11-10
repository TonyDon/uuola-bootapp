package com.uuola.webapp.support.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.webapp.constants.Constants;

/**
 * 
 * <pre>
 * 视图拦截
 * @author tonydon
 * 创建日期: 2018年9月24日
 * </pre>
 */
public class ViewInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView mv) throws Exception {
        // 如果存在视图模型，但没有设置视图名称，则根据控制器方法名称自动设置视图路径
        if (null != mv && handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            Object controller = hm.getBean();
            if (controller instanceof BaseController && null != mv.getViewName()) {
                BaseController action = (BaseController) controller;
                // 模板视图名称不匹配则自动使用方法名构建视图名称
                if(!mv.getViewName().contains(action.getViewPrefixPath())) {
                    mv.setViewName(action.getViewName(hm.getMethod().getName()));
                }
            }
            mv.addObject(Constants.SERVER_CONTEXT_PATH, request.getContextPath());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}

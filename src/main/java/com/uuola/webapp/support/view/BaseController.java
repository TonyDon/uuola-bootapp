/*
 * @(#)BaseController.java 2018年9月24日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.uuola.webapp.constants.CHAR;
import com.uuola.webapp.util.StringUtil;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月24日
 * </pre>
 */
public abstract class BaseController {

    protected Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 根据包路径和Action类构建视图名路径，
     * 如： com.uuola.txcms.portal.user.action.UserInfoAction 
     * 转为 ：com.uuola.txcms.portal.user/userInfo-*.*
     */
    private String viewPrefixPath;

    public BaseController() {
        this.viewPrefixPath = getViewPath().concat(CHAR.STR_SLASH).concat(getActionPrefixName()).concat(CHAR.STR_LINE);
        log.info("viewPath:{}*.*", this.viewPrefixPath);
    }


    /**
     * 得到Controller名称前缀 eg : DemoHelloController -&gt; demoHello
     * 
     * @return
     */
    private String getActionPrefixName() {
        String className = this.getClass().getSimpleName();
        int actionIdx = className.indexOf("Controller");
        if (actionIdx < 1) {
            throw new RuntimeException(this.getClass().getCanonicalName() + "-[The Class Name Must end with 'Controller'!]");
        }
        
        return StringUtils.uncapitalize(className.substring(0, actionIdx));
    }

    /**
     * 转换包名称为视图层目录路径<br/>
     * eg: com.uuola.txweb.user.action → com.uuola.txweb.user
     * 
     * @return
     */
    private String getViewPath() {
        String packageName = this.getClass().getPackage().getName();
        if (StringUtil.endNotWith(packageName, ".controller")) {
            throw new RuntimeException(packageName + "-[Must End-With '.controller', The Path Of Controller Package!]");
        }
        return packageName.substring(0, packageName.lastIndexOf("controller")-1);
    }

    /**
     * 返回视图路径名称.<br/>
     * packageDirPath + '/' + ActionPrefixName + '-' + defineSuffixName
     * 
     * @param defineSuffixName
     * @return
     */
    public String getViewName(String defineSuffixName) {
        return viewPrefixPath.concat(defineSuffixName);
    }
    
    /**
     * 定义包含视图名的ModelAndView
     * @param defineName
     * @return
     */
    protected ModelAndView makeModelView(String defineSuffixName){
        return new ModelAndView(getViewName(defineSuffixName));
    }
    
    /**
     * 定义包含视图名的ModelAndView
     * @param defineName
     * @return
     */
    protected ModelAndView makeModelView(){
        return new ModelAndView();
    }
    
    /**
     * 设置视图名，并返回ModelAndView
     * @param mv
     * @param defineSuffixName
     * @return ModelAndView
     */
    protected ModelAndView assignViewName(ModelAndView mv, String defineSuffixName){
        mv.setViewName(getViewName(defineSuffixName));
        return mv;
    }

}

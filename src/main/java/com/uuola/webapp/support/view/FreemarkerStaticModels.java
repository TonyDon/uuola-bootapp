/*
 * @(#)FreemarkerStaticModels.java 2017年9月10日
 * 
 * Copy Right@ JD.COM
 */

package com.uuola.webapp.support.view;

import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.TemplateHashModel;

/**
 * <pre>
 *
 * &#64;author tangxiaodong
 * 创建日期: 2017年9月10日
 * </pre>
 * 
 * @param <K>
 */
public class FreemarkerStaticModels extends HashMap<String, Object> {

    private static final long serialVersionUID = 8325036667700178034L;

    private Logger log = LoggerFactory.getLogger(FreemarkerStaticModels.class);

    private Properties staticModels;

    public FreemarkerStaticModels() {
    }

    public Properties getStaticModels() {
        return staticModels;
    }

    public void setStaticModels(Properties staticModels) {
        if (staticModels != null) {
            this.staticModels = staticModels;
            BeansWrapperBuilder bwBuilder = new BeansWrapperBuilder(Configuration.getVersion());
            BeansWrapper wrapper = bwBuilder.build();
            Set<String> keys = this.staticModels.stringPropertyNames();
            for (String key : keys) {
                this.put(key, useStaticPackage(wrapper, this.staticModels.getProperty(key)));
            }
            log.info("load static models success! model count:{}", keys.size());
        }else {
            throw new IllegalArgumentException("load static models fail! not found models config.");
        }
    }

    public TemplateHashModel useStaticPackage(BeansWrapper wrapper , String packageName) {
        try {
            TemplateHashModel staticModels = wrapper.getStaticModels();
            TemplateHashModel fileStatics = (TemplateHashModel) staticModels.get(packageName);
            return fileStatics;
        } catch (Exception e) {
            log.error("useStaticPackage()", e);
        }
        return null;
    }

}

/*
 * @(#)FreemarkerConfig.java 2018年9月23日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.uuola.webapp.support.view.FreemarkerStaticModels;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月23日
 * </pre>
 */
@Configuration
public class FreemarkerConfig {
    
    @Autowired
    protected FreeMarkerViewResolver freeMarkerViewResolver;
    
    @Bean
    @ConfigurationProperties(prefix="freemarker.static-models")
    public Properties staticModelsProp() {
        return new Properties();
    }
    
    @Autowired
    public void configViewResolver(@Qualifier("staticModelsProp")Properties staticModelsProp) {
        FreemarkerStaticModels staticModels = new FreemarkerStaticModels();
        staticModels.setStaticModels(staticModelsProp);
        freeMarkerViewResolver.setAttributesMap(staticModels);
    }

}

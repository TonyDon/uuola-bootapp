/*
 * @(#)ComponentConfig.java 2018年9月10日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.config;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import com.uuola.webapp.support.converter.StringToDateConverter;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月10日
 * </pre>
 */
@Configuration
public class ComponentConfig {

    /**
     * 字符串转日期 转换器组件
     * @return
     */
    @Bean
    public Converter<String, Date> stringToDateConverter(){
        return new StringToDateConverter();
    }
}

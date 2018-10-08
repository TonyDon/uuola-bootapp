/*
 * @(#)WebAppMvcConfig.java 2018年9月24日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.config;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.uuola.webapp.constants.DATE_FORMAT;
import com.uuola.webapp.support.view.ConsoleAccessInterceptor;
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
        registry.addInterceptor(new ConsoleAccessInterceptor()
                .setRedirectUri("/admin-console/login.html"))
                .addPathPatterns("/admin-console/**")
                .excludePathPatterns(
                        "/admin-console/login*", 
                        "/admin-console/verify*",
                        "/admin-console/mylog*",
                        "/admin-console/logout*");
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for(HttpMessageConverter<?> converter : converters) {
            if(converter instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter jacksonConverter = (MappingJackson2HttpMessageConverter)converter;
                SimpleModule module = new SimpleModule("com.uuola.bootapp.jackson.module");
                module.addSerializer(Long.class, ToStringSerializer.instance);
                module.addSerializer(Long.TYPE, ToStringSerializer.instance);
                ObjectMapper om = jacksonConverter.getObjectMapper();
                om.registerModule(module);
                om.setDateFormat(new SimpleDateFormat(DATE_FORMAT.YYYY_MM_DD_HH_MM_SS));
                om.setTimeZone(TimeZone.getDefault());
            }
        }
    }
    
    
    
}

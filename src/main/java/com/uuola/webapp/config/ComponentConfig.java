/*
 * @(#)ComponentConfig.java 2018年9月10日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.config;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import com.uuola.webapp.support.aop.ControllerMethodAop;
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
    
    /**
     * 应用APP 默认的线程执行器
     * @return
     */
    @Bean 
    public ExecutorService executorService() {
        int coreNum = (Runtime.getRuntime().availableProcessors()<<1) - 1;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(coreNum, coreNum,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
         executor.allowCoreThreadTimeOut(true);
         return executor;
    }
    
    /**
     * 控制器方法拦截AOP
     * @return
     */
    @Bean 
    public ControllerMethodAop ControllerMethodAop() {
        return new ControllerMethodAop();
    }
}

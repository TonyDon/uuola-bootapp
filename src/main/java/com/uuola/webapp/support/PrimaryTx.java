/*
 * @(#)PrimaryTx.java 2018年9月10日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.support;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.transaction.annotation.Transactional;



/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2018年9月10日
 * </pre>
 */
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
@Transactional
public @interface PrimaryTx {

}

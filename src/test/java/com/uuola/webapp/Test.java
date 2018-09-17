/*
 * @(#)Test.java 2018年9月15日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp;

import com.uuola.webapp.constants.DATE_FORMAT;
import com.uuola.webapp.util.DateUtil;
import com.uuola.webapp.util.IdGenerator;

/**
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年9月15日
 * </pre>
 */
public class Test {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println(DateUtil.parseDate("2018-08-01 00:00:00", DATE_FORMAT.YYYY_MM_DD_HH_MM_SS).getTime());
        for(int k=0; k<100; k++)
        System.out.println(IdGenerator.INSTANCE.nextId());
    }

}

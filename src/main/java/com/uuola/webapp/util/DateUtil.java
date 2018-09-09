/*
 * @(#)DateUtil.java 2013-6-11
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;


/**
 * <pre>
 * @author tangxiaodong
 * 日期工具类
 * 创建日期: 2013-6-11
 * </pre>
 */
public final class DateUtil {
    
    private DateUtil() {}
    
    private static class LazyHolder{
        private static DateUtil instance = new DateUtil();
    }
    
    public static DateUtil getInstance() {
        return LazyHolder.instance;
    }


    /**
     * 转换日期文本格式为 日期类
     * @param dateText 
     * @param dateFormat 日期格式
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String dateText, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(true);
        try {
            return sdf.parse(dateText);
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Could not parse date: " + dateText);
        }
    }
    
    /**
     * 格式化日期为字符串
     * @param date
     * @param dateFormat
     * @return
     * @throws ParseException
     */
    public static String formatDate(Date date, String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }
    
    /**
     * 将毫秒时间戳转换为日期格式文本
     * @param msTime
     * @param dateFormat
     * @return
     */
    public static String formatTimeMillis(Long msTime, String dateFormat){
        return DateUtil.formatDate(new Date(msTime), dateFormat);
    }
    
    /**
     * 根据日期文本获取毫秒时间戳
     * @param dateText
     * @param dateFormat
     * @return
     * @throws IllegalArgumentException
     */
    public static long parseTimeMillis(String dateText, String dateFormat){
        if(StringUtils.isEmpty(dateText)){
            return 0L;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try{
            return sdf.parse(dateText).getTime();
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Could not get TimeMillis by : " + dateText);
        }
    }
    
    /**
     * 得到当前时间戳，毫秒部分为0
     * @return
     */
    public static long getCurrTime(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    /**
     * 得到当前时间 不包括时间,分,秒
     *
     * @return Date
     */
    public static Date getNowDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 得到当前时间 包括时间,分,秒
     *
     * @return Timestamp
     */
    public static Timestamp getNowTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 得到当前时间戳，含毫秒数
     * @return
     */
    public static long getCurrMsTime(){
        return System.currentTimeMillis();
    }
    
    /**
     * 将毫秒时间戳转为Date
     * @param timeMillis
     * @return
     */
    public static Date parseDate(long timeMillis){
        return new Date(timeMillis);
    }
    
    /**
     * 对时间相关字段进行数值增加、减少操作
     * @param date
     * @param calendarField
     * @param amount
     * @return modify date, 原时间对象不变
     */
    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }
    
    /**
     * 对时间天数字段进行数值增加、减少操作
     * @param date
     * @param calendarField
     * @param amount 
     * @return modify date, 原时间对象不变
     */
    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }
    
    /**
     * 得到年份
     * @param cal
     * @return
     */
    public static int getYear(Calendar cal){
        return cal.get(Calendar.YEAR);
    }
    
    /**
     * 得到月份
     * @param cal
     * @return
     */
    public static int getMonth(Calendar cal){
        return cal.get(Calendar.MONTH)+1;
    }
    
    /**
     * 得到月中的天
     * @param cal
     * @return
     */
    public static int getDay(Calendar cal){
        return cal.get(Calendar.DAY_OF_MONTH);
    }
    
    /**
     * 得到日期中的分钟值
     * @param cal
     * @return
     */
    public static int getMinute(Calendar cal) {
        return cal.get(Calendar.MINUTE);
    }
    
    /**
     * 得到当天在年份中的第多少天
     * @param cal
     * @return
     */
    public static int getDayInYear(Calendar cal){
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    public  static void main(String...strings ){
        Calendar c = Calendar.getInstance();
        System.out.println(getYear(c));
        System.out.println(getMonth(c));
        System.out.println(getDay(c));
        System.out.println(getDayInYear(c));
        System.out.println(getMinute(c));
    }
}

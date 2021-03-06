/*
 * @(#)NumberUtil.java 2013-8-31
 * 
 * Copy Right@ uuola
 */

package com.uuola.webapp.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2013-8-31
 * </pre>
 */
public final class NumberUtil {
    
    private NumberUtil() {
        
    }
    
    private static class LazyHolder{
        private static NumberUtil instance = new NumberUtil();
    }
    
    public static NumberUtil getInstance() {
        return LazyHolder.instance;
    }

    /*
     * 随机数生成
     * 
     * @begin 开始于数值
     * 
     * @limit 不可到达数值 范围是 begin<=int f()<limit
     */
    public static int genRndInt(int begin, int limit) {
        return begin + new Random().nextInt(limit - begin);
    }
    
    
    /**
     * 通过给定random生成器，随机生成范围内整数
     * @param r
     * @param begin
     * @param limit  范围是 begin<= f()<limit
     * @return
     */
    public static int genRndInt(Random r, int begin, int limit) {
        return begin + r.nextInt(limit - begin);
    }

    /*
     * BigDecimal类型数值转换
     * 
     * @param len 保留小数位数
     * 
     * @param bigdecimal 需要进行转换的数值对象
     * 
     * @param newScale 需要进行转的数值对象模式 BigDecimal.ROUND_HALF_UP
     * 
     * @return 返回结果
     */
    public static BigDecimal round(BigDecimal bigdecimal, int len, int newScale) {
        return bigdecimal.setScale(len, newScale);
    }

    /*
     * @see 四舍五入保留len长度的小数位.
     * 
     * @param len 保留小数位数
     * 
     * @param bigdecimal 需要进行四舍五入的数值对象
     * 
     * @return 返回结果
     */
    public static BigDecimal roundHalfUp(BigDecimal bigdecimal, int len) {
        return NumberUtil.round(bigdecimal, len, BigDecimal.ROUND_HALF_UP);
    }

    /*
     * @see double值进行四舍五入保留2位小数.
     * 
     * @param f 需要进行四舍五入的double对象
     * 
     * @return 返回结果
     */
    public static double round(double d) {
        return NumberUtil.roundHalfUp(new BigDecimal(d), 2).doubleValue();
    }

    /*
     * @see 格式化显示小数数值 , 该转换为四舍五入模式
     * 
     * @param d 双精度值
     * 
     * @pattern 格式化匹配模式串 如 #,##0.0#
     */
    public static String format(double d, String pattern) {
        DecimalFormat df = (DecimalFormat)DecimalFormat.getInstance();
        df.applyPattern(pattern);
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(d);
    }
}

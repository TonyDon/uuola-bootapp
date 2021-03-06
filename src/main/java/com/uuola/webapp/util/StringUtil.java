/*
 * @(#)StringUtil.java 2013-6-12
 * 
 * Copy Right@ uuola
 */

package com.uuola.webapp.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.uuola.webapp.constants.CHAR;
import com.uuola.webapp.constants.ENCODING;
import com.uuola.webapp.constants.REGEX;


/**
 * <pre>
 * @author tangxiaodong
 * 创建日期: 2013-6-12
 * </pre>
 */
public  abstract class StringUtil {

    /**
     * 检查字符串是否为空
     * 
     * @param value
     * @return boolean
     */
    public static boolean isEmpty(CharSequence value) {
        int strLen;
        if (value == null || (strLen = value.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!(Character.isWhitespace(value.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isNotEmpty(CharSequence value) {
        return !StringUtil.isEmpty(value);
    }

    /**
     * 检查字符串是否为数字含小数
     * 
     * @param value
     * @return boolean
     */
    public static boolean isDecimal(CharSequence value) {
        if (value == null) {
            return false;
        }
        char[] chars = value.toString().toCharArray();
        int length = chars.length;
        if (length < 1) {
            return false;
        }

        int i = 0;
        if (length > 1 && chars[0] == CHAR.CHAR_LINE) {
            i = 1;
        }

        if (chars[length - 1] == CHAR.CHAR_DOT || !Character.isDigit(chars[i])) {
            return false;
        }

        int n = 0;
        for (; i < length; i++) {
            if (chars[i] == CHAR.CHAR_DOT) {
                n++;
            }
            if (((!Character.isDigit(chars[i])) && chars[i] != CHAR.CHAR_DOT) || n > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否为整数型字符串
     * 
     * @param value
     * @return
     */
    public static boolean isInteger(CharSequence value) {
        if (value == null) {
            return false;
        }
        char[] chars = value.toString().toCharArray();
        int length = chars.length;
        if (length < 1) {
            return false;
        }

        int i = 0;
        if (length > 1 && chars[0] == CHAR.CHAR_LINE) {
            i = 1;
        }

        for (; i < length; i++) {
            if (!Character.isDigit(chars[i])) {
                return false;
            }
        }
        return true;
    }
    

    /**
     * 字符验证函数，使用编译后的匹配模式快速判断是否符合模式要求，不符合则返回 retStr.
     * @param val
     * @param pattern
     * @param retStr
     * @return
     */
    public static String getValid(String val, Pattern pattern, String retStr) {
        if (isEmpty(val)) {
            return retStr;
        }
        return pattern.matcher(val).matches() ? val : retStr;
    }
    
    /**
     * 检查,为空则返回一个定义值
     *
     * @param val
     * @param retstr
     * @return
     */
    public static String checkNull(String val, String retStr) {
        if (isEmpty(val)) {
            return retStr;
        } else {
            return val.trim();
        }
    }
    
    /**
     * 将Map<String,Object>转为请求查询串<br/>
     * 如果MAP为空或无元素侧返回null
     *
     * @param params
     * @return
     * @throws IOException 
     */
    public static String parseQueryText(Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, Object> parVal : params.entrySet()) {
                sb.append(parVal.getKey()).append(CHAR.STR_EQUAL)
                        .append(URLEncoder.encode(String.valueOf(parVal.getValue()), ENCODING.UTF8))
                        .append(CHAR.STR_AND);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static String[] split(String ids, char c) {
        return StringUtils.split(ids, c);
    }
    
    public static String[] split(String ids, String c) {
        return StringUtils.split(ids, c);
    }

    public static String join(String[] ida, char c) {
        return StringUtils.join(ida, c);
    }
    
    public static String join(String[] ida, String c){
        return StringUtils.join(ida, c);
    }
    
    public static String join(Collection<?> col, String c){
        return StringUtils.join(col, c);
    }
    
    public static String join(Collection<?> col, char c){
        return StringUtils.join(col, c);
    }
    
    /**
     * <pre>
     * StringUtils.substringAfterLast(null, *)      = null
     * StringUtils.substringAfterLast("", *)        = ""
     * StringUtils.substringAfterLast(*, "")        = ""
     * StringUtils.substringAfterLast(*, null)      = ""
     * StringUtils.substringAfterLast("abc", "a")   = "bc"
     * StringUtils.substringAfterLast("abcba", "b") = "a"
     * StringUtils.substringAfterLast("abc", "c")   = ""
     * StringUtils.substringAfterLast("a", "a")     = ""
     * StringUtils.substringAfterLast("a", "z")     = ""
     * </pre>
     */
    public static String substringAfterLast(String str, String separator){
        return StringUtils.substringAfterLast(str, separator);
    }
    
    /**
     * <p>Replaces all occurrences of a String within another String.</p>
     *
     * <p>A <code>null</code> reference passed to this method is a no-op.</p>
     *
     * <pre>
     * StringUtils.replace(null, *, *)        = null
     * StringUtils.replace("", *, *)          = ""
     * StringUtils.replace("any", null, *)    = "any"
     * StringUtils.replace("any", *, null)    = "any"
     * StringUtils.replace("any", "", *)      = "any"
     * StringUtils.replace("aba", "a", null)  = "aba"
     * StringUtils.replace("aba", "a", "")    = "b"
     * StringUtils.replace("aba", "a", "z")   = "zbz"
     * </pre>
     *
     * @see #replace(String text, String searchString, String replacement, int max)
     * @param text  text to search and replace in, may be null
     * @param searchString  the String to search for, may be null
     * @param replacement  the String to replace it with, may be null
     * @return the text with any replacements processed,
     *  <code>null</code> if null String input
     */
    public static String replace(String text, String searchString, String replacement){
        return StringUtils.replace(text, searchString, replacement, -1);
    }
    
    /**
     * 转换为驼峰式名称
     * Convert a column name with underscores to the corresponding property name using "camel case".  A name
     * like "customer_number" would match a "customerNumber" property name.
     * @param name the column name to be converted
     * @return the name using "camel case"
     */
    public static String getCamelcaseName(String name) {
        if (name == null || name.isEmpty()) {
            return CHAR.STR_EMPTY;
        }
        if (name.indexOf(CHAR.CHAR_UNDER_LINE) < 0) {
            return name.toLowerCase();
        }
        StringBuilder result = new StringBuilder();
        boolean nextIsUpper = false;
        int len = name.length();
        for (int i = 0; i < len; i++) {
            char s = name.charAt(i);
            if (s == CHAR.CHAR_UNDER_LINE) {
                nextIsUpper = true;
            } else {
                if (nextIsUpper) {
                    result.append(Character.toUpperCase(s));
                    nextIsUpper = false;
                } else {
                    result.append(Character.toLowerCase(s));
                }
            }
        }
        return result.toString();
    }
    
    /**
     * “customerNumber” -&gt; “customer_number”
     * Convert a name in camelCase to an underscored name in lower case.
     * Any upper case letters are converted to lower case with a preceding underscore.
     * @param name
     * @return
     */
    public static String getUnderscoreName(String name) {
        if (name == null || name.isEmpty()) {
            return CHAR.STR_EMPTY;
        }
        StringBuilder result = new StringBuilder();
        result.append(Character.toLowerCase(name.charAt(0)));
        int len = name.length();
        for (int i = 1; i < len; i++) {
            char c = name.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append(CHAR.CHAR_UNDER_LINE).append(Character.toLowerCase(c));
            }
            else {
                result.append(c);
            }
        }
        return result.toString();
    }
    
    /**
     * 过滤掉文件中的注释部分
     * @param str
     * @return
     */
    public static String clearNote(String str) {
        return REGEX.RE_CLR_NOTE.matcher(str).replaceAll(CHAR.STR_EMPTY);
    }
    
    /**
     * str  不以prefix 字符串为开始 返回true ,prefix大小写敏感<br/>
     * 使用此方法减少‘!’非的使用
     * @param str
     * @param prefix
     * @return
     */
    public static boolean startsNotWith(String str, String prefix){
        return !StringUtils.startsWith(str, prefix);
    }
    
    /**
     * str  不以suffix 字符串结束, 返回true , suffix大小写敏感<br/>
     * 使用此方法减少‘!’非的使用
     * @param str
     * @param suffix
     * @return
     */
    public static boolean endNotWith(String str, String suffix){
        return !StringUtils.endsWith(str, suffix);
    }
    
    
    /**
     * 构建参数占位符如 3个参数为 ?,?,?
     * eg: Long[] inIds = {111L,222L,333L}; length = 3
     * return ?,?,?
     * @param argNum
     * @return
     */
    public static String getPlaceholder(int argNum) {
        if (1 == argNum) {
            return CHAR.STR_QUESTION;
        }
        StringBuilder sb = new StringBuilder();
        int lastNum = argNum - 1;
        for (int k = 0; k < lastNum; k++) {
            sb.append(CHAR.CHAR_QUESTION);
            sb.append(CHAR.CHAR_COMMA);
        }
        return sb.append(CHAR.CHAR_QUESTION).toString();
    }
}

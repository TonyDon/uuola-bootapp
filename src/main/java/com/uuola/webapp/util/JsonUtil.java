/*
 * @(#)JsonUtil.java 2017年9月10日
 * 
 * Copy Right@ JD.COM
 */ 

package com.uuola.webapp.util;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <pre>
 *
 * @author tangxiaodong
 * 创建日期: 2017年9月10日
 * </pre>
 */
public final class JsonUtil {
    
    private static Logger log = LoggerFactory.getLogger(JsonUtil.class);

    private final static ObjectMapper jsonMapper = new ObjectMapper(); 
    
    private JsonUtil() {}
    
    private static class LazyHolder{
        private static final JsonUtil singleInstance = new JsonUtil();
    }
    
    public static JsonUtil getInstance() {
        return LazyHolder.singleInstance ;
    }
    
    /**
     * 转换对象为JSON字符串
     * @param obj
     * @return
     */
    public static String parseJSON(Object obj){
        if(null ==  obj) {
            return null;
        }
        try {
            return jsonMapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.error("parseJSON(Object obj)", e);
        }
        return null;
    }
    
    /**
     * 转换对象为输出流串
     * @param obj
     * @return
     */
    public static void parseJSON(Object obj, OutputStream os){
        try {
            jsonMapper.writeValue(os, obj);
        } catch (Exception e) {
            log.error("parseJSON(Object obj, OutputStream os)", e);
        }
    }
    
    /**
     * 转换JSON串为一个Class<T>的目标对象
     * @param json
     * @param type
     * @return
     */
    public static <T> T parseObject(String json, Class<T> valueType) {
        try {
            return jsonMapper.readValue(json, valueType);
        } catch (Exception e) {
            log.error("parseObject(String json, Class<T> valueType) ", e);
        }
        return null;
    }
 
    /**
     * 通过类型反射，返回目标对象
     * @param json
     * @param typeRef
     * @return
     */
    public static <T> T parseObject(String json, TypeReference<T> typeRef) {
        try {
            return jsonMapper.readValue(json, typeRef);
        } catch (Exception e) {
            log.error("parseObject(String json, TypeReference<T> typeRef)", e);
        }
        return null;
    }
    
    /**
     * 将JSON字符串转位泛型对象
     * @param value
     * @return
     */
    public static <E> E convert(String value) {
        return parseObject(value, new TypeReference<E>() {});
    }

    public static void main(String[] args) {
        String dict = "{\"1\":\"通过\",\"2\":\"在路上\"}";
        Map<Integer, String> dictMap = JsonUtil.parseObject(dict, new TypeReference<Map<Integer, String>>() {});
        System.out.println(dictMap);

        String json = "[{\"1\":\"通过\",\"2\":\"在路上\"},{\"1\":\"通过\",\"2\":\"在路上\"}]";
        List<Map<Integer, String>> list = JsonUtil.parseObject(json, new TypeReference<List<Map<Integer, String>>>() {});
        System.out.println(list);
    }
}

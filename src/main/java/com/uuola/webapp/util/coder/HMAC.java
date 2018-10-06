package com.uuola.webapp.util.coder;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.uuola.webapp.constants.ENCODING;
import com.uuola.webapp.util.ByteHexUtil;

/**
 * 
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年10月6日
 * </pre>
 */
public final class HMAC {
    
    private HMAC() {}

    public static String encryptMD5(String data, String salt){
        return encrypt(data, salt, "HmacMD5");
    }
    
    public static String encryptSHA1(String data, String salt){
        return encrypt(data, salt, "HmacSHA1");
    }
    
    public static String encrypt(String data, String salt, String algorithm)  throws RuntimeException {
        byte[] bytes = null;
        try {
            SecretKey secretKey = new SecretKeySpec(salt.getBytes(ENCODING.UTF8), algorithm);
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            bytes = mac.doFinal(data.getBytes(ENCODING.UTF8));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ByteHexUtil.byte2hex(bytes);
    }
}

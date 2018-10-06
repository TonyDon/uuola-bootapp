package com.uuola.webapp.util.coder;

import javax.crypto.Cipher;
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
public final class DESede {

    private DESede() {
    }
    
    private static String DES = "DESede";

    /**
     * @see 加密
     * @param src 数据源
     * @param key 密钥，长度必须是24位ascii
     * @return	返回加密后的数据
     * @throws Exception
     */
    private static byte[] encrypt(byte[] src, byte[] key) throws RuntimeException {
        try {
            SecretKey skey = new SecretKeySpec(key, DES);
            Cipher cipher = Cipher.getInstance(DES);
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            return cipher.doFinal(src);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密
     *
     * @param src	数据源
     * @param key	密钥，长度必须是24位ascii
     * @return	返回解密后的原始数据 异常返回字节原始数据
     * @throws Exception
     */
    private static byte[] decrypt(byte[] src, byte[] key) throws RuntimeException {
        try {
            SecretKey skey = new SecretKeySpec(key, DES);
            Cipher cipher = Cipher.getInstance(DES);
            cipher.init(Cipher.DECRYPT_MODE, skey);
            return cipher.doFinal(src);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 数据解密
     *
     * @param data
     * @param key 密钥
     * @return
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws RuntimeException {
        if (data == null || key==null) {
            return null;
        }
        try {
            byte[] b = decrypt(ByteHexUtil.hex2byte(data.getBytes(ENCODING.UTF8)), key.getBytes());
            if (b == null) {
                return null;
            }
            return new String(b, ENCODING.UTF8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 数据加密
     *
     * @param data
     * @param key 密钥
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws RuntimeException {
        if (data == null || key==null) {
            return null;
        }
        try {
            return ByteHexUtil.byte2hex(encrypt(data.getBytes(ENCODING.UTF8), key.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
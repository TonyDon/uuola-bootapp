package com.uuola.webapp.util.coder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.uuola.webapp.constants.ENCODING;

/**
 * 
 * <pre>
 *
 * @author tonydon
 * 创建日期: 2018年10月6日
 * </pre>
 */
public class DigestHash {

    private DigestHash() {
    }
    
    public enum TYPE{
        SHA1("SHA-1"),
        
        SHA256("SHA-256"),
        
        SHA384("SHA-384"),
        
        SHA512("SHA-512"),
        
        MD5("MD5");
        
        String type;
        
        TYPE(String type){
            this.type = type;
        }
        
        public String value() {
            return this.type;
        }
    }

    /**
     * Encodes a string
     *
     * @param str String to encode <SHA-1, SHA-384, and SHA-512>
     * @return Encoded String
     * @throws NoSuchAlgorithmException
     */
    public static String md5(String s) {
        return DigestHash.encode(s, TYPE.MD5);
    }

    public static String encode(String str, TYPE type) throws RuntimeException {
        if (str == null || str.length() == 0) {
            return null;
        }
        StringBuilder hexString = new StringBuilder(40);
        try {
            MessageDigest md = MessageDigest.getInstance(type.value());
            md.update(str.getBytes(ENCODING.UTF8));
            byte[] hash = md.digest();
            for (int i = 0; i < hash.length; i++) {
                int halfbyte = (hash[i] >>> 4) & 0x0F;
                int two_halfs = 0;
                do {
                    if ((0 <= halfbyte) && (halfbyte <= 9)) {
                        hexString.append((char) ('0' + halfbyte));
                    } else {
                        hexString.append((char) ('a' + (halfbyte - 10)));
                    }
                    halfbyte = hash[i] & 0x0F;
                } while (two_halfs++ < 1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return hexString.toString();
    }

}
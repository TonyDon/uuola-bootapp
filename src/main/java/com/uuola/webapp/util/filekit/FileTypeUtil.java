/*
 * @(#)TypeUtil.java 2018年5月9日
 * 
 * Copy Right@ uuola
 */ 

package com.uuola.webapp.util.filekit;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uuola.webapp.util.ByteHexUtil;

/**
 * <pre>
 * 常用文件类型工具
 * @author tangxiaodong
 * 创建日期: 2018年5月9日
 * </pre>
 */
public class FileTypeUtil {
    
    private static Logger logger = LoggerFactory.getLogger(FileTypeUtil.class);
    
    public static final String TEXT_FILE_EXT_NAME = "|txt|ini|json|sql|xml|html|js|properties|log|rtf|";
    
    public static final String ZIP_RAR_EXT_NAME = "|rar|zip|gz|tar|7z|";
    
    public static final int HEADER_LEN = 16;

    public enum IMAGE_TYPE_DEF {
        
        jpg("ffd8ff"),
        
        png("89504e47"),
        
        gif("47494638"),
        
        bmp("424d"),
        
        tiff("49492a00"),
        
        pdf("255044462d312e");
        
        private String code;
        
        IMAGE_TYPE_DEF(String code){
            this.code = code;
        }
        
        public String getCode() {
            return this.code;
        }
    }
    
    public static String getImageType(byte[] src) {
        String code = ByteHexUtil.byte2hex(src);
        if(null == code) {
            return null;
        }
        code = code.toLowerCase();
        for(IMAGE_TYPE_DEF t : IMAGE_TYPE_DEF.values()) {
            if(code.startsWith(t.code)) {
                return t.name();
            }
        }
        return null;
    }
    
    public static boolean isImage(String type) {
        if(null == type) {
            return false;
        }
        boolean isImage = false;
        switch(IMAGE_TYPE_DEF.valueOf(type)) {
            case jpg :
            case png :
            case gif :
            case bmp :
            case tiff :
                isImage = true;
                break;
            default :
                break;
        }
        return isImage;
    }
    
    public static boolean isText(String type) {
        return null != type && TEXT_FILE_EXT_NAME.contains(type);
    }
    
    public static boolean isCompressed(String type) {
        return null != type && ZIP_RAR_EXT_NAME.contains(type);
    }
    
    
    /**
     * 探测文件信息，如类型，长宽，大小
     * @param file
     * @return FileInfo
     */
    public static FileInfo detect(File file){
        FileInfo info = new FileInfo();
        if(null == file || !file.exists() || !file.isFile() || !file.canRead()){
            return info;
        }
        info.setFile(file);
        info.setFormat(FilenameUtils.getExtension(file.getName()));
        if(isText(info.getFormat()) || isCompressed(info.getFormat())) {
            // 文本文件\压缩文件，不再做后续判断
            return info;
        }
        if (FileTypeUtil.isImage(info.getFormat())) {
            try (ImageInputStream iis = ImageIO.createImageInputStream(file)) {
                Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
                if (!iter.hasNext()) {
                    logger.error(".detect() error. No readers found! file:" + file.getName());
                } else {
                    ImageReader ird = iter.next();
                    ird.setInput(iis, true);
                    info.setWidth(ird.getWidth(0));
                    info.setHeight(ird.getHeight(0));
                    byte[] headerBytes = new byte[(int) (info.getSize() > HEADER_LEN ? HEADER_LEN : info.getSize())];
                    // 归为0位读取头信息
                    iis.seek(0);
                    iis.read(headerBytes, 0, headerBytes.length);
                    String type = FileTypeUtil.getImageType(headerBytes);
                    if(null == type) {
                        // 非法图片格式，此处制空
                        info.setFormat(null);
                    }else if (!type.equals(info.getFormat())) {
                        info.setFormat(type);
                    }
                }
            } catch (IOException e) {
                info.setFormat(null);
                logger.error(".detect() error. ", e);
            }
        }
        return info;
    }
}

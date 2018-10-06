package com.uuola.webapp.util.filekit;

import java.io.File;

public class FileInfo {

    /**
     * jpeg , png, gif, bmp<br/>
     * 根据该字段判断文件信息是否读取成功
     */
    private String format;
    
    private int width;
    
    private int height;
    
    private File file;
    

    
    public String getFormat() {
        return format;
    }

    
    public void setFormat(String format) {
        this.format = format;
    }


    public int getWidth() {
        return width;
    }

    
    public void setWidth(int width) {
        this.width = width;
    }

    
    public int getHeight() {
        return height;
    }

    
    public void setHeight(int height) {
        this.height = height;
    }

    
    public long getSize() {
        return null != file ? file.length() : 0L;
    }

    public File getFile() {
        return file;
    }


    public void setFile(File file) {
        this.file = file;
    }
    
    /**
     * 判断当前文件信息是否有效
     * @return
     */
    public boolean isValid() {
        return (null != format && format.length() > 0 && null != file && file.length() > 0);
    }


    @Override
    public String toString() {
        return "FileInfo [format=" + format + ", width=" + width + ", height=" + height + ", file=" + file
                + "]";
    }

    
}

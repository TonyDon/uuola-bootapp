/*
 * @(#)Test.java 2018年9月15日
 * 
 * Copy Right@ uuola
 */

package com.uuola.webapp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import com.uuola.webapp.constants.DATE_FORMAT;
import com.uuola.webapp.util.DateUtil;
import com.uuola.webapp.util.IdGenerator;
import com.uuola.webapp.util.coder.DESede;
import com.uuola.webapp.util.coder.DigestHash;

/**
 * <pre>
 *
 * &#64;author tonydon
 * 创建日期: 2018年9月15日
 * </pre>
 */
public class Test {

    /**
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println(DateUtil.parseDate("2018-12-01 00:00:00", DATE_FORMAT.YYYY_MM_DD_HH_MM_SS).getTime());
        for (int k = 0; k < 10; k++)
            System.out.println(IdGenerator.INSTANCE.nextId());
        //        File file = new File("C:\\tmp_dir\\详细设计.rar");
        //        FileInfo info = FileTypeUtil.detect(file);
        //        System.out.println(info);
        //        int len = (int)(info.getSize()>FileTypeUtil.HEADER_LEN ? FileTypeUtil.HEADER_LEN : info.getSize());
        //        byte[] segment = new byte[len];
        //        IOUtils.read(Files.newInputStream(file.toPath()), segment);
        //        System.out.println(ByteHexUtil.byte2hex(segment));
        System.out.println(DigestHash.encode("123abc_123", DigestHash.TYPE.SHA1));
        String key = "123456abcedf123456abcedf";
        System.out.println(DESede.encrypt("7cd571daa921998adc409e5bf144fd3c3a40a05d", key));
        System.out.println(DESede.decrypt(
                "76cc9a0959379ba3b0e9520c47537842a1be4215af81c9d3bf35f2ad8ce347945cf1f9f3018ed9d9dcb3d61912eeacfe",
                key));

        long id = 1000236L;
        long rnd = 12;
        long code = id << 8 | rnd;
        System.out.println(String.format("HP%014d", code));

        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        NetworkInterface neti = null;
        while (nets.hasMoreElements()) {
            neti = nets.nextElement();
            Enumeration<InetAddress> addrs = neti.getInetAddresses();
            while (addrs.hasMoreElements()) {

                InetAddress inetAddr = addrs.nextElement();
                if (!(inetAddr.isLoopbackAddress() || inetAddr.isLinkLocalAddress()) && inetAddr.isSiteLocalAddress()
                        && inetAddr.getHostAddress().indexOf(":") == -1) {
                    System.out.println(inetAddr.getAddress());
                }
            }

        }
    }

}

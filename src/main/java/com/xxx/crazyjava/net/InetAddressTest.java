package com.xxx.crazyjava.net;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @author zhwanwan
 * @create 2019-06-06 9:35 PM
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("www.baidu.com");
            System.out.println("百度是否可达: " + ip.isReachable(2000));
            System.out.println("百度IP: " + ip.getHostAddress());
            System.out.println("百度全限域名: "+ip.getCanonicalHostName());
            InetAddress local = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
            System.out.println("本机是否可达:" + local.isReachable(1000));
            //全限域名
            System.out.println(local.getCanonicalHostName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

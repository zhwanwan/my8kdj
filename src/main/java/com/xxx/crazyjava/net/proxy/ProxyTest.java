package com.xxx.crazyjava.net.proxy;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * @author zhwanwan
 * @create 2019-06-10 3:23 PM
 */
public class ProxyTest {
    // 下面是代理服务器的地址和端口，
    // 换成实际有效的代理服务器的地址和端口
    final String PROXY_ADDR = "129.82.12.188";
    final int PROXY_PORT = 3124;
    // 定义需要访问的网站地址
    String urlStr = "http://www.crazyit.org";

    public void init() throws IOException {
        URL url = new URL(urlStr);
        // 创建一个代理服务器对象
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT));
        // 使用指定的代理服务器打开连接
        URLConnection conn = url.openConnection(proxy);
        // 设置超时时长
        conn.setConnectTimeout(5000);


        try (Scanner scanner = new Scanner(conn.getInputStream(), "UTF-8");
             PrintStream ps = new PrintStream("index.html")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                ps.println(line);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new ProxyTest().init();
    }
}

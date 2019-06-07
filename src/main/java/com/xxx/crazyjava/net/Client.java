package com.xxx.crazyjava.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author zhwanwan
 * @create 2019-06-07 6:57 PM
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 3000);   //①
            //设置10s之后即超时
            socket.setSoTimeout(10_000);
            // 将Socket对应的输入流包装成BufferedReader

            Socket s = new Socket();
            s.connect(new InetSocketAddress(InetAddress.getByName("localhost"), 3000), 10_000);

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
            // 进行普通IO操作
            String line = br.readLine();
            String line1 = br1.readLine();
            System.out.println("来自服务器的数据: " + line);
            System.out.println("来自服务器的数据: " + line1);
            // 关闭输入流、socket
            br.close();
            br1.close();
            socket.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

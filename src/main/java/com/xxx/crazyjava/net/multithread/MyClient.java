package com.xxx.crazyjava.net.multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author zhwanwan
 * @create 2019-06-07 10:45 PM
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 30000);
        new Thread(new ClientThread(s)).start();
        //获取socket对应的输出流
        PrintStream ps = new PrintStream(s.getOutputStream());
        String line = null;
        //读取键盘输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = br.readLine()) != null) {
            ps.println(line);
        }
    }
}

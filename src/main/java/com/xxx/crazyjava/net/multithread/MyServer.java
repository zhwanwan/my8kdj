package com.xxx.crazyjava.net.multithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhwanwan
 * @create 2019-06-07 8:59 PM
 */
public class MyServer {

    private static List<Socket> socketList = new ArrayList<>();

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(30000);
            while (true) {
                // 此行代码会阻塞，将一直等待别人的连接
                Socket s = ss.accept();
                socketList.add(s);
                // 每当客户端连接后启动一条ServerThread线程为该客户端服务
                new Thread(new ServerThread(s)).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Socket> getSocketList() {
        return socketList;
    }
}

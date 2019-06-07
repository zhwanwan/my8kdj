package com.xxx.crazyjava.net.multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author zhwanwan
 * @create 2019-06-07 9:01 PM
 */
public class ServerThread implements Runnable {
    // 定义当前线程所处理的Socket
    Socket s = null;
    // 该线程所处理的Socket所对应的输入流
    BufferedReader br = null;

    public ServerThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        String content = null;
        // 采用循环不断从Socket中读取客户端发送过来的数据
        while ((content = readFromClient()) != null) {
            // 遍历socketList中的每个Socket，
            // 将读到的内容向每个Socket发送一次
            try {
                for (Socket socket : MyServer.getSocketList()) {
                    PrintStream ps = new PrintStream(socket.getOutputStream());
                    ps.println(content);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    // 定义读取客户端数据的方法
    private String readFromClient() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            // 删除该Socket。
            MyServer.getSocketList().remove(s);      // ①
        }
        return null;
    }


}

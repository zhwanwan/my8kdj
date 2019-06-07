package com.xxx.crazyjava.net.multithread.senior;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhwanwan
 * @create 2019-06-08 12:11 AM
 */
public class Server {
    private static final int SERVER_PORT = 30000;
    // 使用CrazyitMap对象来保存每个客户名字和对应输出流之间的对应关系。
    public static CrazyitMap<String, PrintStream> clients = new CrazyitMap<>();

    public void init() {

        try (ServerSocket ss = new ServerSocket(SERVER_PORT)) {
            while (true) {
                Socket socket = ss.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败,是否端口" + SERVER_PORT + "已被占用?");
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.init();
    }
}

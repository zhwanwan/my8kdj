package com.xxx.crazyjava.net.multithread.halfclose;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhwanwan
 * @create 2019-06-08 1:42 AM
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(30000);
            Socket socket = ss.accept();
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("服务器的第一行数据");
            ps.println("服务器的第二行数据");
            //关闭socket的输出流，表明输出数据已经结束
            socket.shutdownOutput();
            //下面语句将输出false，表明socket还未关闭。
            System.out.println(socket.isClosed());
            Scanner scanner = new Scanner(socket.getInputStream());
            while (scanner.hasNextLine())
                System.out.println(scanner.nextLine());

            scanner.close();
            socket.close();
            ss.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.xxx.crazyjava.net.multithread.halfclose;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhwanwan
 * @create 2019-06-08 1:46 AM
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 30000);
            Scanner scanner = new Scanner(socket.getInputStream());
            while (scanner.hasNextLine())
                System.out.println(scanner.nextLine());
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("客户端的第一行数据");
            ps.println("客户端的第二行数据");
            ps.close();
            scanner.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

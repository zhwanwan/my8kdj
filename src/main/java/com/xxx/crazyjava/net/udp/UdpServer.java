package com.xxx.crazyjava.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author zhwanwan
 * @create 2019-06-10 1:46 PM
 */
public class UdpServer {
    public static final int PORT = 30_000;

    private static final int DATA_LEN = 4096;

    byte[] inBuff = new byte[DATA_LEN];

    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);

    private DatagramPacket outPacket;

    String[] books = new String[]{"疯狂Java讲义", "轻量级Java EE企业应用实战", "疯狂Android讲义", "疯狂Ajax讲义"};

    public void init() {

        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            for (int i = 0; i < 100; i++) {
                // 读取Socket中的数据，读到的数据放入inPacket封装的数组里。
                socket.receive(inPacket);
                // 判断inPacket.getData()和inBuff是否是同一个数组
                System.out.println(inBuff == inPacket.getData());
                // 将接收到的内容转换成字符串
                System.out.println(new String(inBuff, 0, inPacket.getLength()));
                // 从字符串数组中取出一个元素作为发送的数据
                byte[] sendData = books[i % 4].getBytes();
                // 以指定字节数组作为发送数据,以刚接收到的DatagramPacket的源SocketAddress作为目标SocketAddress创建DatagramPacket
                outPacket = new DatagramPacket(sendData, sendData.length, inPacket.getSocketAddress());
                // 发送数据
                socket.send(outPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new UdpServer().init();
    }

}

package com.xxx.crazyjava.net.aio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhwanwan
 * @create 2019-06-09 2:34 PM
 */
public class AIOClient {
    final static String UTF_8 = "UTF-8";
    final static int PORT = 30000;
    // 与服务器端通信的异步Channel
    AsynchronousSocketChannel clientChannel;

    JFrame mainWin = new JFrame("多人聊天");
    JTextArea jta = new JTextArea(16, 48);
    JTextField jtf = new JTextField(40);
    JButton sendBtn = new JButton("发送");

    public void init() {
        mainWin.setLayout(new BorderLayout());
        jta.setEditable(false);
        mainWin.add(new JScrollPane(jta), BorderLayout.CENTER);
        JPanel jp = new JPanel();
        jp.add(jtf);
        jp.add(sendBtn);
        //发送消息的Action,Action是ActionListener的子接口
        Action sendAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = jtf.getText();
                if (content.trim().length() > 0) {
                    try {
                        clientChannel.write(
                                ByteBuffer.wrap(content.trim().getBytes(UTF_8))).get();
                    } catch (InterruptedException | ExecutionException | UnsupportedEncodingException ex) {
                        ex.printStackTrace();
                    }
                }
                // 清空输入kuang
                jtf.setText("");
            }
        };
        sendBtn.addActionListener(sendAction);
        // 将Ctrl+Enter键和"send"关联
        jtf.getInputMap().put(KeyStroke.getKeyStroke(
                '\n', InputEvent.CTRL_MASK), "send");
        // 将"send"和sendAction关联
        jtf.getActionMap().put("send", sendAction);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.add(jp, BorderLayout.SOUTH);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public void connect() throws IOException, ExecutionException, InterruptedException {
        // 定义一个ByteBuffer准备读取数据
        final ByteBuffer buff = ByteBuffer.allocate(1024);
        //创建一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(80);
        // 以指定线程池来创建一个AsynchronousChannelGroup
        AsynchronousChannelGroup channelGroup =
                AsynchronousChannelGroup.withThreadPool(executor);
        // 以channelGroup作为组管理器来创建AsynchronousSocketChannel
        clientChannel = AsynchronousSocketChannel.open();
        // 让AsynchronousSocketChannel连接到指定IP、指定端口
        clientChannel.connect(new InetSocketAddress("127.0.0.1", PORT)).get();
        jta.append("---与服务器连接成功---");
        buff.clear();
        clientChannel.read(buff, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                buff.flip();
                // 将buff中内容转换为字符串
                String content = StandardCharsets.UTF_8.decode(buff).toString();
                // 显示从服务端读取的数据
                jta.append("某人说：" + content + "\n");
                buff.clear();
                clientChannel.read(buff, null, this);
            }

            @Override
            public void failed(Throwable ex, Object attachment) {
                System.out.println("读取数据失败: " + ex);
            }
        });
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        AIOClient client = new AIOClient();
        client.init();
        client.connect();
    }

}

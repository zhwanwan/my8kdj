package com.xxx.crazyjava.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author zhwanwan
 * @create 2019-06-03 4:47 PM
 */
public class FileChannelTest {

    public static void main(String[] args) {
        File f = new File("FileChannelTest.java");
        try (FileChannel inChannel = new FileInputStream(f).getChannel();
             FileChannel outChannel = new FileOutputStream("a.txt").getChannel()
        ) {
            //将FileChannel全部数据映射成ByteBuffer
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
            Charset charset = Charset.forName("GBK");
            //直接将buffer数据全部输出
            outChannel.write(buffer);
            //clear->恢复limit,position位置
            buffer.clear();

            //创建解码器
            CharsetDecoder decoder = charset.newDecoder();
            //使用解码器将ByteBuffer转化成CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

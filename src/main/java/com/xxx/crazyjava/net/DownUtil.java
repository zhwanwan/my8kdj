package com.xxx.crazyjava.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author zhwanwan
 * @create 2019-06-06 10:38 PM
 */
public class DownUtil {

    private String path;
    private String targetFile;
    private int threadNum;
    private DownThread[] threads;

    private int fileSize;

    public DownUtil(String path, String targetFile, int threadNum) {
        this.path = path;
        this.targetFile = targetFile;
        this.threadNum = threadNum;
        this.threads = new DownThread[threadNum];
    }

    public void download() {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5 * 1000);
            conn.setRequestMethod("GET");
            conn.setRequestProperty(
                    "Accept",
                    "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
                            + "application/x-shockwave-flash, application/xaml+xml, "
                            + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                            + "application/x-ms-application, application/vnd.ms-excel, "
                            + "application/vnd.ms-powerpoint, application/msword, */*");
            conn.setRequestProperty("Accept-Language", "zh-CN");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Connection", "Keep-Alive");
            // 得到文件大小
            fileSize = conn.getContentLength();
            conn.disconnect();

            /**
             * 假设总大小为100个单位,分4个线程下载
             * 0: startPos = 0;
             * 1: startPos = 25
             * 2: startPos = 50
             * 3: startPos = 75
             */
            int currentPartSize = fileSize / threadNum + 1;
            RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
            // 设置本地文件的大小
            file.setLength(fileSize);
            file.close();

            for (int i = 0; i < threadNum; i++) {
                // 计算每条线程的下载的开始位置
                int startPos = i * currentPartSize;
                RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
                // 定位该线程的下载位置
                currentPart.seek(startPos);
                // 创建下载线程
                threads[i] = new DownThread(startPos, currentPartSize, currentPart);
                // 启动下载线程
                threads[i].start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getCompleteRate() {
        int sumSize = 0;
        for (int i = 0; i < threadNum; i++) {
            sumSize += threads[i].length;
        }
        return sumSize * 1.0 / fileSize;
    }


    private class DownThread extends Thread {
        private int startPos;
        private int currentPartSize;
        private RandomAccessFile currentPart;
        public int length;

        public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart) {
            this.startPos = startPos;
            this.currentPart = currentPart;
            this.currentPartSize = currentPartSize;
        }

        @Override
        public void run() {
            try {
                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5 * 1000);
                conn.setRequestMethod("GET");
                conn.setRequestProperty(
                        "Accept",
                        "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
                                + "application/x-shockwave-flash, application/xaml+xml, "
                                + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                                + "application/x-ms-application, application/vnd.ms-excel, "
                                + "application/vnd.ms-powerpoint, application/msword, */*"
                );

                conn.setRequestProperty("Accept-Language", "zh-CN");
                conn.setRequestProperty("Charset", "UTF-8");
                InputStream inStream = conn.getInputStream();

                inStream.skip(this.startPos);
                byte[] buffer = new byte[1024];
                int hasRead = 0;

                while (length <= currentPartSize
                        && (hasRead = inStream.read(buffer)) != -1) {
                    currentPart.write(buffer, 0, hasRead);
                    length += hasRead;
//                    System.out.println(getName() + "已下载" + length);
                }

                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}

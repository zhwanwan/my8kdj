package com.xxx.crazyjava.net;

/**
 * @author zhwanwan
 * @create 2019-06-06 11:42 PM
 */
public class MultiThreadDown {
    public static void main(String[] args) {
        final DownUtil downUtil = new DownUtil("http://js1cdn.clubstatic.lenovo.com.cn/thinkpc/images/wallpaper/kol1.zip"
                , "E://kol1.zip", 4);

        downUtil.download();

        new Thread(() -> {
            while (downUtil.getCompleteRate() <= 1) {
                System.out.println("已完成" + downUtil.getCompleteRate());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

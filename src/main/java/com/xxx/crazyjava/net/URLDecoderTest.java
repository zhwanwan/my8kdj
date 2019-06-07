package com.xxx.crazyjava.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author zhwanwan
 * @create 2019-06-06 9:48 PM
 */
public class URLDecoderTest {
    public static void main(String[] args) {

        try {
            String keyWord = URLDecoder.decode("%B7%E8%BF%F1java","GBK");
            System.out.println(keyWord);
            String urlString = URLEncoder.encode("深入学习Spring","GBK");
            System.out.println(urlString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

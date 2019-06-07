package com.xxx.crazyjava.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author zhwanwan
 * @create 2019-06-03 12:31 PM
 */
public class RedirectIn {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("RedirectIn.java")) {
            System.setIn(fis);
            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                System.out.println("Key in " + sc.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

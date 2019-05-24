package com.xxx.jdk8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author wangzhen
 * @create 2019-05-21 3:39 PM
 */
public class SwingTest {
    //psvm
    //sout
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My JFrame");
        JButton jButton = new JButton("My Button");
        /*jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Pressed");
            }
        });*/
        jButton.addActionListener(event -> {
            System.out.println("Button Pressed");
            System.out.println("Hello World");
            System.out.println("executed");
        });
        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

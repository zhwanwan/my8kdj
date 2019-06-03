package com.xxx.crazyjavja.annotation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zhwanwan
 * @create 2019-06-02 9:12 PM
 */
public class AnnotationTest {

    private JFrame mainWin = new JFrame("使用注解绑定事件监听器");

    @ActionListenerFor(listener = OkListener.class)
    private JButton ok = new JButton("确定");
    @ActionListenerFor(listener = CancelListener.class)
    private JButton cancel = new JButton("取消");

    public void init() {
        JPanel jp = new JPanel();
        jp.setAlignmentX(100);
        jp.setAlignmentY(100);
        jp.add(ok);
        jp.add(cancel);
        mainWin.add(jp);

        ActionListenerInstaller.processAnnotations(this);

        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.setLocation(100,100);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new AnnotationTest().init();
    }

}

class OkListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "点击了确认按钮");
    }
}

class CancelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "点击了取消按钮");
    }
}
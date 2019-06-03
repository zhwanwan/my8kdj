package com.xxx.crazyjavja.annotation;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * @author zhwanwan
 * @create 2019-06-02 9:19 PM
 */
public class ActionListenerInstaller {

    public static void processAnnotations(Object obj) {

        try {
            Class cl = obj.getClass();
            Field[] fields = cl.getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
                ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
                Object fObj = f.get(obj);
                if (a != null && fObj != null && fObj instanceof AbstractButton) {
                    Class<? extends ActionListener> listenerClazz = a.listener();
                    ActionListener al = listenerClazz.newInstance();
                    AbstractButton btn = (AbstractButton) fObj;
                    btn.addActionListener(al);
                }
            }
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

    }
}

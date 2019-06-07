package com.xxx.crazyjava.annotation;

import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhwanwan
 * @create 2019-06-02 4:25 PM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionListenerFor {

    /**
     * 定义一个成员变量,用于设置元数据
     * 该listener成员变量用于保存监听器实现类
     * @return
     */
    Class<? extends ActionListener> listener();
}

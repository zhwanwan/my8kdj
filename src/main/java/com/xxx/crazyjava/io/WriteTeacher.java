package com.xxx.crazyjava.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author zhwanwan
 * @create 2019-06-03 2:45 PM
 */
public class WriteTeacher {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt"))) {
            Person per = new Person("孙悟空", 500);
            Teacher t1 = new Teacher("唐僧", per);
            Teacher t2 = new Teacher("菩提祖师", per);


            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(per);
            oos.writeObject(t2);//t2已经序列化,次数直接输出一个序列化编号,而不是重新序列化该对象


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.xxx.crazyjava.io;

import java.io.Serializable;

/**
 * @author zhwanwan
 * @create 2019-06-03 2:45 PM
 */
public class Teacher implements Serializable {
    private String name;
    private Person student;

    public Teacher(String name, Person student) {
        this.name = name;
        this.student = student;
    }
    //此处省略了name和student的setter和getter方法

    // name的setter和getter方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // student的setter和getter方法
    public void setStudent(Person student) {
        this.student = student;
    }

    public Person getStudent() {
        return this.student;
    }
}

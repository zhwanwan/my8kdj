package com.xxx.jdk8;

/**
 * @author wangzhen
 * @create 2019-05-22 5:40 PM
 */
public class Person {
    private String userName;
    private int age;

    public Person(String userName, int age) {
        this.age = age;
        this.userName = userName;
    }

    public Person() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }
}

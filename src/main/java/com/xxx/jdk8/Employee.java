package com.xxx.jdk8;

/**
 * @author wangzhen
 * @create 2019-05-24 4:23 AM
 */
public class Employee {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}

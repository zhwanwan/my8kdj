package com.xxx.jdk8;

import java.util.List;

/**
 * @author wangzhen
 * @create 2019-05-24 4:24 AM
 */
public class Company {
    private String name;
    private List<Employee> employees;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

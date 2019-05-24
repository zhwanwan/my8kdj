package com.xxx.jdk8;

import java.util.*;

/**
 * @author wangzhen
 * @create 2019-05-24 4:25 AM
 */
public class OptionalTest2 {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setName("zhangsan");
        Employee e2 = new Employee();
        e2.setName("lisi");
        Company company = new Company();
        List<Employee> employees = Arrays.asList(e1,e2);
        company.setEmployees(employees);
        Optional<Company> optional = Optional.ofNullable(company);
        List<Employee> employeeList = optional.map(c -> c.getEmployees()).orElse(Collections.emptyList());
        System.out.println(employeeList);
    }
}

package com.xxx.jdk8.datetime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author zhwanwan
 * @create 2019-06-01 12:22 AM
 */
public class DateTimeTest2 {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate localDatePlus2M = localDate.plus(2, ChronoUnit.WEEKS);
        System.out.println(localDatePlus2M);
        System.out.println("------------");

    }

}

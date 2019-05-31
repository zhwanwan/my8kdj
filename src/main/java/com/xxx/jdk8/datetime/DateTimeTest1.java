package com.xxx.jdk8.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;

/**
 * @author zhwanwan
 * @create 2019-06-01 12:11 AM
 */
public class DateTimeTest1 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        System.out.println(localDate.getYear() + ", " + localDate.getMonthValue() + ", " + localDate.getDayOfMonth());

        System.out.println("-----------");

        LocalDate localDate2 = LocalDate.of(2019,6,1);
        System.out.println(localDate2);

        System.out.println("-------------");

        LocalDate localDate3 = LocalDate.of(2019,10,1);
        MonthDay monthDay = MonthDay.of(localDate3.getMonth(),localDate3.getDayOfMonth());
        MonthDay monthDay2 = MonthDay.from(LocalDate.of(2019,10,1));
        System.out.println(monthDay.equals(monthDay2));

        System.out.println("------------");

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime time2 = time.plusHours(3).plusMinutes(20);
        System.out.println(time2);
        System.out.println("-----------------");
    }
}

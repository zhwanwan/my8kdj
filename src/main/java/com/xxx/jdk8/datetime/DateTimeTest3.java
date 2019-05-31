package com.xxx.jdk8.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhwanwan
 * @create 2019-06-01 12:24 AM
 */
public class DateTimeTest3 {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());
        System.out.println("--------");
        LocalDate l1 = LocalDate.now();
        LocalDate l2 = l1.plus(1, ChronoUnit.DAYS);
        System.out.println(l1.isAfter(l2));
        System.out.println("---------");

        Set<String> set = ZoneId.getAvailableZoneIds();
        Set<String> treeSet = new TreeSet<String>() {
            {
                addAll(set);
            }
        };
        //treeSet.forEach(System.out::println);

        System.out.println("----------------");

        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime,zoneId);
        System.out.println(zonedDateTime);
        System.out.println("---------------");

        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
        System.out.println(yearMonth.isLeapYear());
        System.out.println(yearMonth.lengthOfMonth());

        Period period = Period.between(l1,l2);
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }
}

package com.xxx.joda;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * @author zhwanwan
 * @create 2019-05-31 10:19 PM
 */
public class JodaTest1 {
    public static void main(String[] args) {
        DateTime today = new DateTime();
        DateTime tomorrow = today.plusDays(1);
        System.out.println(today.toString("yyyy-MM-dd"));
        System.out.println(tomorrow.toString("yyyy-MM-dd"));
        System.out.println("------------");
        DateTime d1 = today.withDayOfMonth(1);
        System.out.println(d1);
        LocalDate localDate = new LocalDate();
        System.out.println(localDate);
        System.out.println("------------");
        localDate = localDate.plusMonths(3).dayOfMonth().withMinimumValue();
        System.out.println(localDate);
        System.out.println("--------------");
        //获取两年前第三个月的最后一天
        DateTime dateTime = new DateTime();
        DateTime p = dateTime.minusYears(2).dayOfMonth().setCopy(3).dayOfMonth().withMaximumValue();
        System.out.println(p);
    }
}

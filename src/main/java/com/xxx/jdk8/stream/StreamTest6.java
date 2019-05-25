package com.xxx.jdk8.stream;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author zhwanwan
 * @create 2019-05-25 12:29 PM
 */
public class StreamTest6 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        stream.findFirst().ifPresent(System.out::println);
        System.out.println("---------------");

        /**
         * iterate 会生成一个无限流,一般需要配合limit使用
         */
        Stream.iterate(1, i -> i + 2).limit(6).forEach(System.out::println);
        System.out.println("--------------");
        int sum = Stream.iterate(1, i -> i + 2)
                .limit(6)
                .filter(i -> i > 5)
                .mapToInt(i -> i * 2)
                .skip(2)
                .limit(2)
                .sum();
        System.out.println(sum);
        System.out.println("--------------");
        //min() max()--返回 OptionalInt
        IntSummaryStatistics summaryStatistics = Stream.iterate(1, i -> i + 2)
                .limit(6)
                .filter(i -> i > 4)
                .mapToInt(i -> i * 2)
                .skip(2)
                .limit(2)
                .summaryStatistics();
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println("---------------");

    }
}

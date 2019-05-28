package com.xxx.jdk8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.UNORDERED;

/**
 * @author zhwanwan
 * @create 2019-05-28 2:21 PM
 */
public class MySetCollector2<T> implements Collector<T, Set<T>, Map<T, T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier() invoked!");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator() invoked!");
        return (set, item) -> {
            /**
             * 顺序执行的情况,线程会打印N次;
             * 并行执行情况下,要避免迭代集合
             */
            System.out.println("accumulator thread :" + set + ", " + Thread.currentThread());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner() invoked!");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher() invoked!");
        return (set) -> {
            Map<T, T> map = new TreeMap<>();
            set.forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics() invoked!");
        return Collections.unmodifiableSet(
                EnumSet.of(UNORDERED));
        //IDENTITY_FINISH 运行异常
        //CONCURRENT--may throw java.util.ConcurrentModificationException
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            List<String> list = Arrays.asList("hello", "world", "welcome", "a", "b", "c");
            Set<String> set = new HashSet<>();
            set.addAll(list);
            System.out.println("set: " + set);
            Map<String, String> map = set.stream().parallel().collect(new MySetCollector2<>());
            System.out.println(map);
        }
    }
}

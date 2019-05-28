package com.xxx.jdk8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

/**
 * 自定义收集器实现..
 *
 * @author zhwanwan
 * @create 2019-05-28 1:35 PM
 */
public class MySetCollector<T> implements Collector<T, Set<T>, Set<T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier() invoked!");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator() invoked!");
        return Set<T>::add; //HashSet<T>::add -- compile failed:Set<T> 不一定就是HashSet
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner() invoked!");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set2;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher() invoked!");
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics() invoked!");
        return Collections.unmodifiableSet(
                EnumSet.of(IDENTITY_FINISH, UNORDERED)
        );
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");
        Set<String> set = list.stream().collect(new MySetCollector<>());
        System.out.println(set);
    }
}

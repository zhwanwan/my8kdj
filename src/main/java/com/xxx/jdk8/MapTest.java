package com.xxx.jdk8;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author zhwanwan
 * @create 2019-05-31 3:15 PM
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        IntStream.range(1, 11).forEach(i -> map.put(i, "NO_" + i));

        map.put(null,null);
        map.put(null,null);
        map.put(1,null);

        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}

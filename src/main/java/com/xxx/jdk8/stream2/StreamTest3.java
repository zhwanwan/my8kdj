package com.xxx.jdk8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author zhwanwan
 * @create 2019-05-29 12:06 PM
 *
 *
 * hello
 * world
 * hello world
 * aaa
 * bbb
 * Exception in thread "main" java.lang.NullPointerException: 1 NPE
 * 	at com.xxx.jdk8.stream2.StreamTest3.lambda$main$0(StreamTest3.java:18)
 * 	at java.util.stream.Streams$1.run(Streams.java:850)
 * 	at java.util.stream.AbstractPipeline.close(AbstractPipeline.java:323)
 * 	at com.xxx.jdk8.stream2.StreamTest3.main(StreamTest3.java:23)
 * 	Suppressed: java.lang.NullPointerException: 2 NPE
 * 		at com.xxx.jdk8.stream2.StreamTest3.lambda$main$1(StreamTest3.java:21)
 * 		at java.util.stream.Streams$1.run(Streams.java:854)
 * 		... 2 more
 *
 * 	-----------------------------------------------------------
 * hello
 * world
 * hello world
 * aaa
 * bbb
 * Exception in thread "main" java.lang.NullPointerException: NPE
 * 	at com.xxx.jdk8.stream2.StreamTest3.main(StreamTest3.java:44)
 *
 */
public class StreamTest3 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "hello world");

        /*try (Stream<String> stream = list.stream()) {
            stream.onClose(() -> {
                System.out.println("aaa");
                throw new NullPointerException("1 NPE");
            }).onClose(() -> {
                System.out.println("bbb");
                throw new NullPointerException("2 NPE");
            }).forEach(System.out::println);
        }*/

        NullPointerException npe = new NullPointerException("NPE");
        try (Stream<String> stream = list.stream()) {
            stream.onClose(() -> {
                System.out.println("aaa");
                throw npe;
            }).onClose(() -> {
                System.out.println("bbb");
                throw npe;
            }).forEach(System.out::println);
        }
    }
}

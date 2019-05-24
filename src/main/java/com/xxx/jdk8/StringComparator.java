package com.xxx.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangzhen
 * @create 2019-05-22 1:58 PM
 */
public class StringComparator {


    public static void main(String[] args) {
        List<String> names = Arrays.asList("zhangsan","lisi","wangwu","zhaoliu");
        /*Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });*/
        /**
         * expression : o1.compareTo(o2)
         * statement : {return o1.compareTo(o2);}
         */
        Collections.sort(names,(s1,s2) -> s1.compareTo(s2));
        //Collections.sort(names, Comparator.naturalOrder());
        System.out.println(names);
        names.forEach(System.out::println);
    }
}

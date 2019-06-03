package com.xxx.crazyjava.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zhwanwan
 * @create 2019-06-01 5:32 PM
 */
public class GenericMethodTest {

    //声明一个泛型方法,带一个T类型形参
    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for(T o : a) {
            c.add(o);
        }
    }

    public static void main(String[] args) {
        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<>(100);
        fromArrayToCollection(oa,co);

        String[] sa = new String[100];
        Collection<String> cs = new ArrayList<>(100);
        fromArrayToCollection(sa,cs);

        fromArrayToCollection(sa,co);

        Integer[] ia = new Integer[100];
        Float[] fa = new Float[100];
        Number[] na = new Number[100];

        Collection<Number> cn = new ArrayList<>();
        fromArrayToCollection(ia,cn);
        fromArrayToCollection(fa,cn);
        fromArrayToCollection(na,cn);
        fromArrayToCollection(na,co);

        /**
         * Number不是
         */
//        fromArrayToCollection(na,cs);


    }

}

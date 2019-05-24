package com.xxx.jdk8;

/**
 * @author wangzhen
 * @create 2019-05-21 5:13 PM
 */
public class Test2 {

    public void myTest(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        /*test2.myTest(new MyInterface() {
            @Override
            public void test() {
                System.out.println("TEST2");
            }
        });*/
        test2.myTest(()-> {
            System.out.println("TEST2");
        });
        System.out.println("--------------");
        MyInterface myInterface = () -> {
            System.out.println("TEST2");
        }; //Java中,Lambda表达式是对象,他们必须依附一类特别的对象类型--函数式接口(Functional Interface)
        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);
    }
}

@FunctionalInterface
interface MyInterface {
    void test();
    String toString();
}


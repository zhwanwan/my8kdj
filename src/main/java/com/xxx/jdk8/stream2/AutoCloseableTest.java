package com.xxx.jdk8.stream2;

/**
 * AutoCloseable --JDK1.7
 *
 * one doSomething invoked
 * two doSomething invoked
 * two close invoked
 * one close invoked
 *
 * @author zhwanwan
 * @create 2019-05-29 8:02 AM
 */
public class AutoCloseableTest implements AutoCloseable {

    private String name;

    public AutoCloseableTest(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void doSomething() {
        System.out.println(name + " doSomething invoked");
    }

    @Override
    public void close() throws Exception {
        System.out.println(name + " close invoked");
    }

    public static void main(String[] args) throws Exception {
        /*try {

        } catch (Exception e) {

        } finally {

        }*/
        try (AutoCloseableTest act1 = new AutoCloseableTest("one");
             AutoCloseableTest act2 = new AutoCloseableTest("two");) {
            act1.doSomething();
            act2.doSomething();
        }
    }
}

package com.xxx.jdk8.methodreference;

/**
 * @author wangzhen
 * @create 2019-05-24 5:14 AM
 */
public class StudentComparator {

    public int compareStuByScore(Student s1, Student s2) {
        return s1.getScore() - s2.getScore();
    }

    public int compareStuByName(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

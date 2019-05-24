package com.xxx.jdk8.methodreference;

import java.util.Objects;

/**
 * @author wangzhen
 * @create 2019-05-24 4:50 AM
 */
public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (score != student.score) return false;
//        return name != null ? name.equals(student.name) : student.name == null;
        return Objects.equals(name, student.name);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + score;
        return result;
    }

    public static int compareStudentByScore(Student s1, Student s2) {
        return s1.getScore() - s2.getScore();
    }

    public static int compareStudentByName(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }

    public int compareByScore(Student s) {
        return this.getScore() - s.getScore();
    }

    public int compareByName(Student s) {
        return this.getName().compareToIgnoreCase(s.getName());
    }
}

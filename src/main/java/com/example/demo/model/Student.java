package com.example.demo.model;

import java.util.List;

public class Student {

    public int rollno;
    public String name;
    public List<String> randomText;

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }
}

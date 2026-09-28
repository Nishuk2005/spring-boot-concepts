package com.example.AopDemo.repository;

import com.example.AopDemo.dto.Student;

public class StudentRepository {

    public void save(Student student){
        System.out.println("Student saved successfully");
    }
}

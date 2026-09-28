package com.example.aopDemo2.service;

import com.example.aopDemo2.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student createStudent(Student student){
        System.out.println("Student saved");
        //throw new RuntimeException("Some error happened");
        return student;
    }
}

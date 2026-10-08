package com.example.CustomAnnotation.service;

import com.example.CustomAnnotation.annotation.TrackExecutionTime;
import com.example.CustomAnnotation.dto.Student;
import jdk.jfr.Timestamp;

public class StudentService {

    @TrackExecutionTime(warnAfter = 2000,
        operation = "Creating student")
    public Student createStudent(Student student){
        System.out.println("Student saved");
        return student;
    }

    @TrackExecutionTime(warnAfter = 1500,
        operation = "Get Student data")
    public String getStudent(String s){
        System.out.println(s);
        return s;
    }


}

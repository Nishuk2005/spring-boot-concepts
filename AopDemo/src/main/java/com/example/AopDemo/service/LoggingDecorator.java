package com.example.AopDemo.service;

import com.example.AopDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class LoggingDecorator implements StudentService{

    private StudentServiceImpl studentServiceImpl;
    public LoggingDecorator(StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl=studentServiceImpl;
    }

    @Override
    public void createStudent(Student student) {

        LoggingServiceUtil.logStart("StudentServiceImpl","createStudent");

        studentServiceImpl.createStudent(student);

        LoggingServiceUtil.logEnd("StudentServiceImpl","createStudent");
    }
}

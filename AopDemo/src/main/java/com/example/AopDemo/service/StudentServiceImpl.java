package com.example.AopDemo.service;

import com.example.AopDemo.controller.StudentController;
import com.example.AopDemo.dto.Student;
import com.example.AopDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }
}

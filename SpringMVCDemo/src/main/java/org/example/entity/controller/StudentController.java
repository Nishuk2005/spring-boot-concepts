package org.example.entity.controller;

import org.example.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
}

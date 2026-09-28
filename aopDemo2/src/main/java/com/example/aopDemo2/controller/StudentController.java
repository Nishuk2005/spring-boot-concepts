package com.example.aopDemo2.controller;


import com.example.aopDemo2.dto.Student;
import com.example.aopDemo2.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping("/api/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student s= studentService.createStudent(student);
        return ResponseEntity.ok(s);
    }
}

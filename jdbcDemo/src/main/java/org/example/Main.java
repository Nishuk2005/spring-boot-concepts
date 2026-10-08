package org.example;

import org.example.model.Student;
import org.example.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();

        //studentRepository.createStudent(new Student("Rohan", "rohan@gmail.com", 21));

//        studentRepository.updateStudent(
//                new Student("Nishu", "nishu@gmail.com", 21), 8L);

        //studentRepository.deleteStudent(9L);

        studentRepository.getStudent();
    }
}
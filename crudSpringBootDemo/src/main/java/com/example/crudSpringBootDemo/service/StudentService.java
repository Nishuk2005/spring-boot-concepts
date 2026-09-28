package com.example.crudSpringBootDemo.service;

import com.example.crudSpringBootDemo.dto.StudentRequestDTO;
import com.example.crudSpringBootDemo.dto.StudentResponseDto;
import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public StudentResponseDto createStudent(StudentRequestDTO studentReqDto){
        Student student=mapToEntity(studentReqDto);

        Student studentResp=studentRepository.save(student);
        return mapToDto(studentResp);
    }

    public Student getStudent(Long id){

        Optional<Student> studentResp=studentRepository.findById(id);

        if(studentResp.isPresent()){
            return studentResp.get();
        }
        return null;

    }

    public List<Student> getAllStudent(){

        List<Student> studentList=studentRepository.findByDeletedIsFalse();
        return studentList;

    }

    public Student updateStudent(Long id,Student studentReq){
        Optional<Student> existingStudent=studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()){
            return null;
        }

        Student studentToSave=existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setSubject(studentReq.getEmail());
        studentToSave.setAge(studentReq.getAge());

        return studentRepository.save(studentToSave);
    }


    public boolean deleteStudent(Long id){
        Boolean isStudent=studentRepository.existsById(id);
        if(!isStudent) return false;

        studentRepository.deleteById(id);

        return true;
    }

    public boolean deleteStudentSoftly(Long id){
        Optional<Student> existingStudent =
                studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()) {
            return false;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);

        return true;
    }

    private Student mapToEntity(StudentRequestDTO studentRequestDTO){
        Student student=new Student();

        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());
        student.setEmail(studentRequestDTO.getEmail());
        student.setRollNo(studentRequestDTO.getRollNo());
        student.setSubject(studentRequestDTO.getSubject());

        student.setDeleted(false);
        return  student;
    }
    private StudentResponseDto mapToDto(Student student){
        StudentResponseDto responseDto=new StudentResponseDto();

        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student saved successfully");

        return responseDto;
    }
}


package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

// This annotation is related to dependency injection TODO: learn more about this
//@Component
@Service // NOTE service is like component but more specific
public class StudentService
{
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(com.example.demo.student.StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
    }
}

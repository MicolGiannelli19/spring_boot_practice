package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


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

        Optional<Student> studentOptional= studentRepository
                .findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email Taken");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

//    public void editStudent(Long studentId, String  newName){
//        boolean exists = studentRepository.existsById(studentId);
//        if (!exists){
//            throw new IllegalStateException("Student with id " + studentId + " does not exist");
//        }
//        // Find element
//        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exist"));;
//
//        // Set new value and save
//        student.setName(newName);
//        studentRepository.save(student);
//    }

    // review the transactional annotation
    @Transactional
    public void updateStudent(Long studentId, String email, String name){

        Student student = studentRepository.findById(studentId).orElseThrow( () -> new IllegalStateException("Student with id " + studentId + " does not exist"));

        // Set new name if passed in
        if (name != null && !name.isEmpty() && !name.equals(student.getName())){
            student.setName(name);
        }

        // Set new name if passed in
        if (email != null && !email.isEmpty() && !email.equals(student.getEmail())){
            student.setEmail(email);
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }
    }
//    }

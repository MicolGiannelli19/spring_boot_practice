package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.student.Student;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {


    // Using depenendcy injection to access the studenService class
    private final StudentService StudentService;

    @Autowired
    public StudentController(com.example.demo.student.StudentService studentService) {
        this.StudentService = studentService;
    }

    @GetMapping
	public List<Student> getStudents() {
		return StudentService.getStudents();
	}

    // Implementing a post method for adding new students
    // Note we are taking this student class from the request body
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        StudentService.addNewStudent(student);
    }
}

package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
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

    @PutMapping(path={"studentId"})
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam( required = false) String email, @RequestParam(required = false) String name){
        StudentService.updateStudent(studentId, email, name);
    }
    // NOTE: keeping this old version here because it is an example of using request body
//    @PutMapping(path = "{studentId}")
//    public void editStudent(@PathVariable("studentId") Long studentId, @RequestBody Map<String, String> updates){
//        // How to better design this to have an optional amount of inputs
//        String newName = updates.get("newName");
//
//        StudentService.editStudent(studentId, newName);
//    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        StudentService.deleteStudent(studentId);
    }

    //TODO: add put functionality to be able to update name and email
}

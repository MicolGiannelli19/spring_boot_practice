package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    // Unsure of what this is
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    // The transient annotation indicates that this field will not be a coloumn in our database
    @Transient
    private Integer age;

    public Student() { // methods named as class are constructors

    }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    // Have diffrent options for this to remove the boiler plate code
    // look up Lombok or use java Records

    // getter and setter methods are used to access and modify private fields
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

//    public void setAge(Integer age) {
//        this.age = age;
//    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}


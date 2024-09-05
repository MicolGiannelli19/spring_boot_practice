package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Note we must specify the type of object we want this repository to work with, Long is the type of the id here
@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {
}

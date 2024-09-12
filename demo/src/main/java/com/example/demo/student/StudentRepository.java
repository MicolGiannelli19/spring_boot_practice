package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// The annotation Repository indicates provides the mechanism for storage, retrieval, search, update, and delete
// Note we must specify the type of object we want this repository to work with, Long is the type of the id here
@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
    //SELECT * FROM student WHERE email = ?
    // TODO: fully understand this
}

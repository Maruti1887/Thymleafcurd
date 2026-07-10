package com.example.thymleaf_crud2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.thymleaf_crud2.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

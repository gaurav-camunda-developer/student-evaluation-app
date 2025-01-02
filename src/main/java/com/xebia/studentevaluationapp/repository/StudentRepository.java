package com.xebia.studentevaluationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xebia.studentevaluationapp.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}

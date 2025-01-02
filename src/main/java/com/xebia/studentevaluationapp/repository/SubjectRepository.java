package com.xebia.studentevaluationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xebia.studentevaluationapp.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	
}


package com.xebia.studentevaluationapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xebia.studentevaluationapp.entities.Mark;

public interface MarkRepository extends JpaRepository<Mark, Integer> {

    List<Mark> findByStudent_StudentId(Integer studentId);

    @Query("SELECT m.mark FROM Mark m WHERE m.student.studentId = :studentId")
    List<Integer> findMarksByStudentId(@Param("studentId") Integer studentId);
}


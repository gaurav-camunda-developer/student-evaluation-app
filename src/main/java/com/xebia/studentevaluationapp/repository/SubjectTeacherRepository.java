package com.xebia.studentevaluationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xebia.studentevaluationapp.entities.SubjectTeacher;

public interface SubjectTeacherRepository extends JpaRepository<SubjectTeacher, Integer> {

    @Query("SELECT COUNT(*) FROM Student s INNER JOIN SubjectTeacher st ON s.group.groupId = st.group.groupId where st.teacherId= :teacherId" )
    long countStudentsByTeacherId(@Param("teacherId") Integer teacherId);
}


package com.xebia.studentevaluationapp.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.xebia.studentevaluationapp.entities.Mark;
import com.xebia.studentevaluationapp.entities.Student;
import com.xebia.studentevaluationapp.repository.MarkRepository;
import com.xebia.studentevaluationapp.repository.StudentRepository;
import com.xebia.studentevaluationapp.repository.SubjectTeacherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	
    private final StudentRepository studentRepository;

    private final MarkRepository markRepository;
    
    private final SubjectTeacherRepository subjectTeacherRepository;
    
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
   
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
    
   public List<Mark> getMarksByStudentId(Integer id){
	   return markRepository.findByStudent_StudentId(id);
   }
   
   
   public List<Integer> getMarksInSubjectByStudentId(Integer id){
	 return markRepository.findMarksByStudentId(id);
	  
   }
   
   public long countStudentsByTeacherId(Integer teacherId) {
	   return subjectTeacherRepository.countStudentsByTeacherId(teacherId);
   }
}






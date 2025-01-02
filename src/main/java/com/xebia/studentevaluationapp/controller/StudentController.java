package com.xebia.studentevaluationapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.studentevaluationapp.entities.Group;
import com.xebia.studentevaluationapp.entities.Mark;
import com.xebia.studentevaluationapp.entities.Student;
import com.xebia.studentevaluationapp.repository.GroupRepository;
import com.xebia.studentevaluationapp.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
	
    private final StudentService studentService;
    
    private final GroupRepository groupRepository;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student studentDto) { 
        Group group = groupRepository.findByName(studentDto.getGroup().getName())
                    .orElseGet(() -> {
                        Group newGroup = new Group();
                        newGroup.setName(studentDto.getGroup().getName());
                        return groupRepository.save(newGroup);
                    });
    	
    	
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setGroup(group);

        studentService.createStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    	
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @GetMapping("/marks/{id}")
    public ResponseEntity<List<Mark>> getMarksById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getMarksByStudentId(id));
    }
    
    @GetMapping("/marks/subject/{id}")
    public ResponseEntity<List<Integer>> getSubjectMarksById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getMarksInSubjectByStudentId(id));
    }
    
    @GetMapping("/count/student/{teacherId}")
    public ResponseEntity<Long> countStudentByTeacherId(@PathVariable Integer teacherId) {
        return ResponseEntity.ok(studentService.countStudentsByTeacherId(teacherId));
    }
}


package com.xebia.studentevaluationapp;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.xebia.studentevaluationapp.entities.Mark;
import com.xebia.studentevaluationapp.repository.MarkRepository;
import com.xebia.studentevaluationapp.repository.SubjectTeacherRepository;
import com.xebia.studentevaluationapp.service.StudentService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentServiceTest {

	@Mock
	private StudentService studentService;

	@Mock
	private SubjectTeacherRepository subjectTeacherRepository;

	@Mock
	private MarkRepository markRepository;

	@Test
	void testCountStudentsByTeacherId() {
		Integer teacherId = 1;
		Mockito.when(subjectTeacherRepository.countStudentsByTeacherId(teacherId)).thenReturn(10L);
		Mockito.when(studentService.countStudentsByTeacherId(teacherId)).thenReturn(10L);

		assertThat(studentService.countStudentsByTeacherId(teacherId)).isGreaterThanOrEqualTo(10L);

	}

	@Test
	void findMarksByStudentId() {
		Integer studentId = 1;
		List<Mark> list = new ArrayList<>();
		Mark mark = new Mark();
		mark.setMark(60);
		list.add(mark);

		Mockito.when(markRepository.findByStudent_StudentId(studentId)).thenReturn(list);
		Mockito.when(studentService.getMarksByStudentId(studentId)).thenReturn(list);

		assertThat(studentService.getMarksByStudentId(studentId)).containsAll(list);

	}

}

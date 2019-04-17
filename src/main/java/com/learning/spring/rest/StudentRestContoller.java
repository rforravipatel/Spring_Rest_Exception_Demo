package com.learning.spring.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestContoller {

	private List<Student> theStudents;

	@PostConstruct
	public void loadData() {

		theStudents = new ArrayList<>();

		theStudents.add(new Student("Ravi", "Patel"));
		theStudents.add(new Student("Darshan", "Desai"));
		theStudents.add(new Student("Niyanta", "shah"));

	}

	// endPoint to get list of students
	@GetMapping("/students")
	public List<Student> getStudents() {

		return theStudents;
	}

	// endPoint to get student
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if (((studentId >= theStudents.size()) || (studentId < 0))) {

			throw new StudentNotFoundException("Student id not found - " + studentId);
		}

		return theStudents.get(studentId);
	}

//	// Add an exception Handler
//
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe) {
//
//		StudentErrorResponse errorResponse = new StudentErrorResponse();
//
//		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//		errorResponse.setMessage(exe.getMessage());
//		errorResponse.setTimrStamp(System.currentTimeMillis());
//
//		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//	}
//
//	// Exception handler to catch any execption
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
//
//		StudentErrorResponse errorResponse = new StudentErrorResponse();
//
//		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//		errorResponse.setMessage(e.getMessage());
//		errorResponse.setTimrStamp(System.currentTimeMillis());
//
//		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//	}
}

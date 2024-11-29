package com.AngularSpringBootMysql.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AngularSpringBootMysql.demo.entity.Student;
import com.AngularSpringBootMysql.demo.repository.StudentRepository;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("/insert")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}

}

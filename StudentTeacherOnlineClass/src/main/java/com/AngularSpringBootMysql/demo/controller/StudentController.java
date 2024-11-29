package com.AngularSpringBootMysql.demo.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/showlist")
	  public List<Student> getAllPatients(){
		  return studentRepository.findAll();
	  }
	

}

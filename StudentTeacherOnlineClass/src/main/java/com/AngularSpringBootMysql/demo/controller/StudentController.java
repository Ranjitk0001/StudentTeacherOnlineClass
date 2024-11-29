package com.AngularSpringBootMysql.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id}")
    public ResponseEntity<Student>getPatientById(@PathVariable long id) throws AttributeNotFoundException {
		Student student=studentRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Student not found with id"+id));
   	
   	return ResponseEntity.ok(student);
    }
	
	@PutMapping("/{id}")
	 public ResponseEntity<Student>updatePatient(@PathVariable long id,@RequestBody Student studentDetails) throws AttributeNotFoundException{
		Student student=studentRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Student not found with id " + id));
		
		student.setAge(studentDetails.getAge());
		student.setSname(studentDetails.getSname());
		student.setEmail(studentDetails.getEmail());
		student.setPassword(studentDetails.getPassword());
		student.setSclass(studentDetails.getSclass());
		 
		Student savedStudent= studentRepository.save(student);
		 return ResponseEntity.ok(savedStudent);
	 }
	
	  
    @DeleteMapping("/{id}")
	 public ResponseEntity<Map<String,Boolean>>deleteAdmin(@PathVariable long id) throws AttributeNotFoundException{
    	Student student=studentRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("student not found with id " + id));
		 studentRepository.delete(student);
		 
		 Map<String ,Boolean> responnse= new HashMap<String,Boolean>();
		 responnse.put("Deleted", Boolean.TRUE);
		 
		 return  ResponseEntity.ok(responnse);
	 }

}

package com.AngularSpringBootMysql.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AngularSpringBootMysql.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}

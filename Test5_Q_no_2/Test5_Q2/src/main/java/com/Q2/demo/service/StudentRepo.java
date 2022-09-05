package com.Q2.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Q2.demo.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}

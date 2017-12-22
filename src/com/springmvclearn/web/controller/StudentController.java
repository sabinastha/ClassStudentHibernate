package com.springmvclearn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


import com.springmvclearn.web.dao.Student;
import com.springmvclearn.web.dao.StudentClass;
import com.springmvclearn.web.service.StudentService;

public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	@RequestMapping("/createstudent")
	public String saveStudent(Student student) {
			studentService.saveStudent(student);
			
		
			return "studentCreated";
			
			
			}
			
	 }
	
	
	
	

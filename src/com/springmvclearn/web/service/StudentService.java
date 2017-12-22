package com.springmvclearn.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvclearn.web.dao.ClassDAO;
import com.springmvclearn.web.dao.Student;
import com.springmvclearn.web.dao.StudentClass;
import com.springmvclearn.web.dao.StudentDAO;

@Service("studentService")
public class StudentService {
	
	private StudentDAO studentDao;

	@Autowired
	public void setStudentDAO(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}
	
	
	public void saveStudent(Student student){
	studentDao.create( student);
	}
	
		
}

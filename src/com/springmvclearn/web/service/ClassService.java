package com.springmvclearn.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvclearn.web.dao.ClassDAO;
import com.springmvclearn.web.dao.Offer;
import com.springmvclearn.web.dao.OffersDAO;
import com.springmvclearn.web.dao.StudentClass;

@Service("classService")
public class ClassService {
	

	private ClassDAO classDao;

	@Autowired
	public void setClassDAO(ClassDAO classDao) {
		this.classDao = classDao;
	}
	
	
	
	public void saveClass(StudentClass classStudent){
	classDao.create( classStudent);
	}
	
	public List<StudentClass> getAllClass(){
		
		return classDao.getAllClass();
	}
	
	

}

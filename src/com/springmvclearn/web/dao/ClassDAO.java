package com.springmvclearn.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("classDao")
public class ClassDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}
		
	public void create(StudentClass classStudent) {
			
		Transaction trans = session().beginTransaction();
		session().save(classStudent);
		trans.commit();
	}
	
	public List<StudentClass> getAllClass(){
		
		Transaction trans = session().beginTransaction();
		List<StudentClass> classes = session().createQuery("from StudentClass").list();
		trans.commit();
		return classes;
	}

	
}

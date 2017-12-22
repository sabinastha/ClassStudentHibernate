package com.springmvclearn.web.test.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springmvclearn.web.dao.ClassDAO;
import com.springmvclearn.web.dao.StudentClass;
import com.springmvclearn.web.dao.Offer;
import com.springmvclearn.web.dao.OffersDAO;
import com.springmvclearn.web.dao.Student;
import com.springmvclearn.web.dao.StudentDAO;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:com/springmvclearn/web/config/dao-context.xml",
		"classpath:com/springmvclearn/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferDaoTests {

	@Autowired
	private OffersDAO offersDao;
	@Autowired
	private ClassDAO classDao;
	@Autowired
	private StudentDAO studentDao;

//	@Test
	public void creates() {
		Offer offer = new Offer("sabina", "email", "This is a test offer.");
		offersDao.createWithSession(offer);
	}

	 //@Test
	 public void getAllOffers(){
	// Offer offer = new Offer("sanjay","email", "This is a test offer.");
	//
	// offersDao.createWithSession(offer);
	//
	 List<Offer> offers = offersDao.getAllOffers();
	assertEquals("Should be one offer in database.", 0, offers.size());
	 }
	 
	 //Display all customers
	 //HQL
	 //@Test
	 public void HibernateChecking() {
		 
		 List<Offer> offers = offersDao.HibernateChecking();
		 assertEquals("Should be one offer in database.", 0, offers.size());
	 }
	 
	 //QBC
	 //@Test
	 public void QbcDisplay() {
		 
		 List<Offer> offers = offersDao.QbcDisplay();
		 assertEquals("Should be one offer in database.", 0, offers.size());
	 }
	 
	 
	 //@Test
	 public void HibernateConditionDisplay() {
		 
		 List<Offer> offers = offersDao.HibernateConditionDisplay();
		 assertEquals("Should be one offer in database.", 0, offers.size());
	 }
	 
	 
	 //@Test
	 public void QbcConditionDisplay() {
		 
		 List<Offer> offers = offersDao.QbcConditionDisplay();
		 assertEquals("Should be one offer in database.", 0, offers.size());
	 }
	 
	// @Test
	 public void HibernateMConditionDisplay() {
		 
		 List<Offer> offers = offersDao.HibernateMConditionDisplay();
		 assertEquals("Should be one offer in database.", 0, offers.size());
	 }
	 
	// @Test
	 public void QbcMConditionDisplay() {
		 
		 List<Offer> offers = offersDao.QbcMConditionDisplay();
		 assertEquals("Should be one offer in database.", 0, offers.size());
	 }
	 
	 
	 @Test
	 public void saveClass() {
		 
		StudentClass classStudent = new StudentClass("sabina");
		List<Student> students = new ArrayList<>();
		 
		Student student = new Student("sabina","banepa");
		student.setclassStudent(classStudent);
		students.add(student);
		classStudent.setStudents(students);
	
		classDao.create(classStudent);
		 
		 
		 
	 }
	 
	// @Test
	 public void saveStudent() {
		 
		 Student student = new Student("sabina","banepa");
		 studentDao.create(student);
	 }
}

package com.springmvclearn.web.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	
	@ManyToOne
	@JoinColumn(name="class_id", nullable=true)
	
	private StudentClass classStudent;
	
	
	public Student(String name, String address) {
		this.name = name;
		this.address = address;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public StudentClass getclassStudent() {
		return classStudent;
	}
	public void setclassStudent(StudentClass class_id) {
		this.classStudent = class_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}

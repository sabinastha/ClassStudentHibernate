package com.springmvclearn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvclearn.web.dao.Offer;
import com.springmvclearn.web.dao.StudentClass;
import com.springmvclearn.web.service.ClassService;

@Controller
public class ClassController {

	@Autowired
	private ClassService classService;
	
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	
	
	@RequestMapping("/createclass")
	public String saveClass(StudentClass classStudent, Model model) {
			classService.saveClass(classStudent);
			List<StudentClass> classes = classService.getAllClass();
			model.addAttribute("classes", classes);
			return "home";
		
	 }
	
	
//	@RequestMapping(value = "createclass", method = RequestMethod.POST)
//	public String saveClass(Model model,StudentClass classStudent) {
//		classService.saveClass(classStudent);
//	List<StudentClass> classes = classService.getAllClass();
//	model.addAttribute("classes", classes);
//	return "classCreated";
//}
	

}

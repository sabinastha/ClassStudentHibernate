package com.springmvclearn.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.springmvclearn.web.dao.ClassDAO;
import com.springmvclearn.web.dao.StudentClass;
import com.springmvclearn.web.dao.Offer;
import com.springmvclearn.web.dao.Student;
import com.springmvclearn.web.service.OffersService;

@Controller
public class OffersController {

	private OffersService OffersService;
	
	@Autowired
	private ClassDAO classDao;
	
	private String saveDirectory = "E:\\Test\\";

	// Sending value from controller to page via HttpSession session
	// @RequestMapping("/")
	// public String showHome(HttpSession httpSession){
	// httpSession.setAttribute("name", "Sanjay");
	// return "home";
	// }

	// Sending value from controller to page via ModelAndView
	// @RequestMapping("/")
	// public ModelAndView showHome() {
	// ModelAndView modelAndView = new ModelAndView("home");
	// Map<String, Object> model = modelAndView.getModel();
	// model.put("name", "I am sanjay");
	// return modelAndView;
	// }

	@Autowired
	public void setOffersService(OffersService offersService) {
		OffersService = offersService;
	}

	@RequestMapping("createOffer")
	public String creatOffer() {
		return "createOffer";
	}

	@RequestMapping(value = "offerCreate", method = RequestMethod.POST)
	public String afterCreate(Model model, Offer offer) {
		System.out.println(offer);
//		OffersService.create(offer);
		OffersService.save(offer);
		
		StudentClass classStudent = new StudentClass("sabina");
		List<Student> students = new ArrayList<>();
		 
		Student student = new Student("sabina","banepa");
		student.setclassStudent(classStudent);
		students.add(student);
		classStudent.setStudents(students);
	
		classDao.create(classStudent);
		
//		List<Offer> offers = OffersService.getAllOffer();
//		model.addAttribute("offers", offers);
		return "offerCreateMessage";
	}
	
	
	
	@RequestMapping(value = "CreateClass", method = RequestMethod.GET)
	public String showClass() {
		
		return "createClass";
	}
	
	@RequestMapping(value = "CreateStudent", method = RequestMethod.GET)
	public String showStudent() {
		
		return "createStudent";
	}
	
	@RequestMapping(value = "fileUpload", method = RequestMethod.GET)
	public String showFileUpload() {
		
		return "fileupload";
	}
	
	
	@RequestMapping(method = RequestMethod.POST,value="uploadFile")
	public String handleFileUpload(HttpServletRequest request, 
			@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
		
		System.out.println("description: " + request.getParameter("description"));
		
		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload){
				
				System.out.println("Saving file: " + aFile.getOriginalFilename());
				
				if (!aFile.getOriginalFilename().equals("")) {
					aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
				}
			}
		}

		// returns to the view "Result"
		return "result";
	}
	


}

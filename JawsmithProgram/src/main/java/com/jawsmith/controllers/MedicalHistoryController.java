package com.jawsmith.controllers;


import java.io.IOException;
import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.model.MedicalHistory;




@Controller
public class MedicalHistoryController {
		ApplicationContext appContext = 
			new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		DataAccesses dataAccesses = (DataAccesses)appContext.getBean("medicalHistoryBean");
	
		@RequestMapping("/medical_history")
		public String view(HttpServletRequest request, HttpServletResponse response, 
									  ModelMap model, Principal principal) throws IOException, ServletException{

			return "main_page";
		}
		
		/**
		 * Method after finishing the add page
		 * 
		 **/
		@RequestMapping("/medical_history/add")
		public String AddMethod(HttpServletRequest request, HttpServletResponse response, 
										 ModelMap model, Principal principal) throws IOException, ServletException{
	
			MedicalHistory medicalHistory = new MedicalHistory();
			String questions = request.getParameter("questions");
			String answer = request.getParameter("answer");
			
			medicalHistory.setQuestion_id(questions);
			medicalHistory.setAnswer(answer);
			
			dataAccesses.save(medicalHistory);
			
	    	return "main_page";
		}
		
		@RequestMapping("/medical_history/edit")
		public String EditMethod(HttpServletRequest request, HttpServletResponse response, 
		ModelMap model, Principal principal) throws IOException, ServletException{
			
			MedicalHistory medicalHistory = new MedicalHistory();
			int editId = Integer.parseInt(request.getParameter("editId"));
			String questions = request.getParameter("questions");
			String answer = request.getParameter("answer");
			
			medicalHistory.setPatient_id(editId);
			medicalHistory.setQuestion_id(questions);
			medicalHistory.setAnswer(answer);
			
			dataAccesses.update(medicalHistory);
			
	    	return "main_page";
		}
		
		  @RequestMapping(value = "/medical_historyGenerateReport") 
		    public void getXLS(HttpServletResponse response,HttpServletRequest request, Model model) throws ClassNotFoundException { 
		    // BusinessUnit_JService downloadService = new BusinessUnit_JService(); 
		     // Delegate to downloadService. Make sure to pass an instance of HttpServletResponse  
		  //   downloadService.downloadXLS(response); 
		 } 
		  
}

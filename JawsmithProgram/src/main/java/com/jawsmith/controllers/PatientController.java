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
import com.jawsmith.model.Patient;



@Controller
public class PatientController {


		ApplicationContext appContext = 
			new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		DataAccesses dataAccesses = (DataAccesses)appContext.getBean("patientsBean");
	
		@RequestMapping("/add_patient")
		public String PatientView(HttpServletRequest request, HttpServletResponse response, 
									  ModelMap model, Principal principal) throws IOException, ServletException{
			
			//Adding the list for the view
			view(model);
			
			return "add_patient";
		}
		
		public void view(ModelMap model){
			ArrayList<Patient> list = new ArrayList<Patient>();
			List<Patient> object = dataAccesses.getAll();
	    	
			Iterator iterate = object.iterator();
	    	while(iterate.hasNext()){
	    		Patient iterlist = (Patient) iterate.next();	//Must change each object in the list as SystemUser
	    		list.add(iterlist);							//Then add to a list that would be passed in the jsp
	    	}
			model.addAttribute("patientList",list);
		}
		

		
		/**
		 * Method after finishing the add page
		 * 
		 **/
		@RequestMapping("/patient/add/done")
		public String AddMethod(HttpServletRequest request, HttpServletResponse response, 
										 ModelMap model, Principal principal) throws IOException, ServletException{
		Patient patient = new Patient();
			String last_name = request.getParameter("last_name");
			String first_name = request.getParameter("first_name");
			String middle_name = request.getParameter("middle_name");
			Date dob = (Date)Date.valueOf(request.getParameter("dob"));
			String sex = request.getParameter("sex");
			String rel_status = request.getParameter("rel_status");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String tel_num = request.getParameter("tel_num");
			String mobile_num = request.getParameter("mobile_num");
			String email = request.getParameter("email");
			String occupation = request.getParameter("occupation");
			String religion = request.getParameter("religion");
			String referred_by = request.getParameter("referred_by");
			String guardian = request.getParameter("guardian");
			
			patient.setLast_name(last_name);
			patient.setFirst_name(first_name);
			patient.setMiddle_name(middle_name);
			patient.setBirthday(dob);
			patient.setSex(sex.charAt(0));
			patient.setRelationship_status(rel_status);
			patient.setAddress(address);
			patient.setCity(city);
			patient.setTelephone_number(tel_num);
			patient.setMobile_number(mobile_num);
			patient.setEmail_address(email);
			patient.setOccupation(occupation);
			patient.setReligion(religion);
			patient.setReferred_by(referred_by);
			patient.setGuardian(guardian);
			
			dataAccesses.save(patient);
			
			//Adding the list for the view
			view(model);
			//Return to module main page
	    	return "home_page";
		}
		
		@RequestMapping("/patient/edit")
		public String EditMethod(HttpServletRequest request, HttpServletResponse response, 
		ModelMap model, Principal principal) throws IOException, ServletException{
			return null;
		}
		
		
		@RequestMapping("/patient/edit/done")
		public String EditMethodDone(HttpServletRequest request, HttpServletResponse response, 
		ModelMap model, Principal principal) throws IOException, ServletException{
			return null;
		}
		
		  @RequestMapping(value = "/patientGenerateReport") 
		    public void getXLS(HttpServletResponse response,HttpServletRequest request, Model model) throws ClassNotFoundException { 
		    // BusinessUnit_JService downloadService = new BusinessUnit_JService(); 
		     // Delegate to downloadService. Make sure to pass an instance of HttpServletResponse  
		  //   downloadService.downloadXLS(response); 
		 } 
		  
}

package com.jawsmith.controllers;


import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.text.SimpleDateFormat;
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

import com.jawsmith.common.GetDateAndTime;
import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.model.Patient;



@Controller
public class PatientController {


		ApplicationContext appContext = 
			new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		DataAccesses dataAccesses = (DataAccesses)appContext.getBean("patientsBean");
		
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
		@RequestMapping("/patient/add")
		public String AddMethod(HttpServletRequest request, HttpServletResponse response, 
										 ModelMap model, Principal principal) throws IOException, ServletException{
		Patient patient = new Patient();
			String last_name = request.getParameter("last_name");
			String first_name = request.getParameter("first_name");
			String middle_name = request.getParameter("middle_name");
			String sex = request.getParameter("sex");
			String rel_status = request.getParameter("rel_status");
			String address = request.getParameter("address");
			String city = "manila";
			String tel_num = request.getParameter("tel_num");
			String mobile_num = request.getParameter("mobile_num");
			String email = request.getParameter("email");
			String occupation = request.getParameter("occupation");
			String religion = request.getParameter("religion");
			String referred_by = request.getParameter("referred_by");
			String guardian = request.getParameter("guardian");
			String patient_num = "1";
			String nationality="Filipino";
			Boolean status=Boolean.valueOf("1");
			Date dob = new Date();
			Date last_visit_date= new Date();
			
			patient.setStatus(status);
			patient.setLast_visit_date(last_visit_date);
			patient.setNationality(nationality);
			patient.setPatient_num(patient_num);
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
			
			Patient patient = new Patient();
			
			int editId = Integer.parseInt(request.getParameter("editId"));
			String last_name = request.getParameter("last_name");
			String first_name = request.getParameter("first_name");
			String middle_name = request.getParameter("middle_name");
			String sex = request.getParameter("sex");
			String rel_status = request.getParameter("rel_status");
			String address = request.getParameter("address");
			String city = "manila";
			String tel_num = request.getParameter("tel_num");
			String mobile_num = request.getParameter("mobile_num");
			String email = request.getParameter("email");
			String occupation = request.getParameter("occupation");
			String religion = request.getParameter("religion");
			String referred_by = request.getParameter("referred_by");
			String guardian = request.getParameter("guardian");
			String patient_num = "1";
			String nationality="Filipino";
			Boolean status=Boolean.valueOf("1");
			Date dob = new Date();
			Date last_visit_date= new Date();
			
			patient.setStatus(status);
			patient.setLast_visit_date(last_visit_date);
			patient.setNationality(nationality);
			patient.setPatient_num(patient_num);
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
			patient.setPatient_id(editId);
			
			dataAccesses.update(patient);
			return "home_page";
		}
		
		@RequestMapping("/patient/delete")
		public String delete(HttpServletRequest request, HttpServletResponse response, 
		ModelMap model, Principal principal) throws IOException, ServletException{
			
			int editId = Integer.parseInt(request.getParameter("editId"));
			Patient patient = (Patient)dataAccesses.findById(editId);
			patient.setStatus(Boolean.valueOf("0"));
			return "home_page";	
		}
		
		  @RequestMapping(value = "/patientGenerateReport") 
		    public void getXLS(HttpServletResponse response,HttpServletRequest request, Model model) throws ClassNotFoundException { 
		    // BusinessUnit_JService downloadService = new BusinessUnit_JService(); 
		     // Delegate to downloadService. Make sure to pass an instance of HttpServletResponse  
		  //   downloadService.downloadXLS(response); 
		 } 
		  
}

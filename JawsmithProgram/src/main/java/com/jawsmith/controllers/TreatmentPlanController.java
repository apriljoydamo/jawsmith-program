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
import com.jawsmith.model.TreatmentPlan;



@Controller
public class TreatmentPlanController {


		ApplicationContext appContext = 
			new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		DataAccesses dataAccesses = (DataAccesses)appContext.getBean("treatmentPlanBean");
	
		@RequestMapping("/treatment_plan")
		public String view(HttpServletRequest request, HttpServletResponse response, 
									  ModelMap model, Principal principal) throws IOException, ServletException{

			return "view_patients_record";
		}
		
		/**
		 * Method after finishing the add page
		 * 
		 **/
		@RequestMapping("/treatment_plan/add/done")
		public String AddMethod(HttpServletRequest request, HttpServletResponse response, 
										 ModelMap model, Principal principal) throws IOException, ServletException{
		TreatmentPlan treatmentPlan = new TreatmentPlan();
			String treatment = request.getParameter("treatment");
			String alternateTreatment = request.getParameter("alternateTreatment");
			
			treatmentPlan.setTreatment(treatment);
			treatmentPlan.setAlternative_treatment(alternateTreatment);
			
			dataAccesses.save(treatment);
			
	    	return "view_patients_record";
		}
		
		@RequestMapping("/treatment_plan/edit")
		public String EditMethod(HttpServletRequest request, HttpServletResponse response, 
		ModelMap model, Principal principal) throws IOException, ServletException{
			return null;
		}
		
		
		@RequestMapping("/treatment_plan/edit/done")
		public String EditMethodDone(HttpServletRequest request, HttpServletResponse response, 
		ModelMap model, Principal principal) throws IOException, ServletException{
			return null;
		}
		
		  @RequestMapping(value = "/treatment_planGenerateReport") 
		    public void getXLS(HttpServletResponse response,HttpServletRequest request, Model model) throws ClassNotFoundException { 
		    // BusinessUnit_JService downloadService = new BusinessUnit_JService(); 
		     // Delegate to downloadService. Make sure to pass an instance of HttpServletResponse  
		  //   downloadService.downloadXLS(response); 
		 } 
		  
}

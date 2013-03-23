package com.jawsmith.controllers;


import java.io.IOException;
import java.security.Principal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.model.TreatmentPlan;



@Controller
@RequestMapping("treatment_plan")
public class TreatmentPlanController {
		static ApplicationContext appContext = 
			new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		static DataAccesses dataAccesses = (DataAccesses)appContext.getBean("treatmentPlanBean");
	
		public String view(HttpServletRequest request, HttpServletResponse response, 
							ModelMap model, Principal principal) throws IOException, ServletException{
			return "view_patients_record";
		}
		
		/**
		 * Method after finishing the add page
		 * 
		 **/
		//@RequestMapping("/add")
		public static void addMethod(HttpServletRequest request, HttpServletResponse response, 
										 ModelMap model, Principal principal) throws IOException, ServletException{
			
			String treatment = request.getParameter("treatment");
			Float treatment_fee = Float.parseFloat(request.getParameter("treatment_fee"));
			String alternateTreatment = request.getParameter("alternative_treatment");
			Float alternative_treatment_fee = Float.parseFloat(request.getParameter("alternative_treatment_fee"));
			Date treatment_date = new Date();
			int patient_id = Integer.parseInt(request.getParameter("patient_id"));
			
			TreatmentPlan treatmentPlan = new TreatmentPlan();
			
			treatmentPlan.setTreatment(treatment);
			treatmentPlan.setTreatment_fee(treatment_fee);
			treatmentPlan.setAlternative_treatment(alternateTreatment);
			treatmentPlan.setAlternative_treatment_fee(alternative_treatment_fee);
			treatmentPlan.setTreatment_date(treatment_date);
			treatmentPlan.setPatient_id(patient_id);
			dataAccesses.save(treatmentPlan);
			System.out.println("TREATMENT PLAN SAVED. CHANGE THE BUTTON IN JSP FROM 'SAVE' INTO 'SAVED' USING JS");
		}
		
		//@RequestMapping("/edit")
		public void editMethod(HttpServletRequest request, HttpServletResponse response, 
									ModelMap model, Principal principal) throws IOException, ServletException{
			
			int treatment_plan_id = Integer.parseInt(request.getParameter("treatment_plan_id"));
			String treatment = request.getParameter("treatment");
			Float treatment_fee = Float.parseFloat(request.getParameter("fee"));
			String alternateTreatment = request.getParameter("alternateTreatment");
			Float alternative_treatment_fee = Float.parseFloat(request.getParameter("alternative_treatment_fee"));
			Date treatment_date = new Date();
			int patient_id = Integer.parseInt(request.getParameter("patient_id"));
			
			TreatmentPlan treatmentPlan = (TreatmentPlan) dataAccesses.findById(treatment_plan_id);
			treatmentPlan.setTreatment(treatment);
			treatmentPlan.setTreatment_fee(treatment_fee);
			treatmentPlan.setAlternative_treatment(alternateTreatment);
			treatmentPlan.setAlternative_treatment_fee(alternative_treatment_fee);
			treatmentPlan.setTreatment_date(treatment_date);
			treatmentPlan.setPatient_id(patient_id);
			dataAccesses.save(treatmentPlan);
			System.out.println("TREATMENT PLAN UPDATED. CHANGE THE BUTTON IN JSP FROM 'UPDATE' INTO 'UPDATED' USING JS");
			
		}
}

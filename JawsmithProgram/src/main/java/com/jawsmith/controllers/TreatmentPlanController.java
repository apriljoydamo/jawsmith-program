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
import com.jawsmith.interfaces.TreatmentPlanMethods;
import com.jawsmith.model.Patient;
import com.jawsmith.model.TableMaintenance;
import com.jawsmith.model.TreatmentPlan;



@Controller
@RequestMapping("treatment_plan")
public class TreatmentPlanController {
		static ApplicationContext appContext = 
			new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		static DataAccesses dataAccesses = (DataAccesses)appContext.getBean("treatmentPlanBean");
		static TreatmentPlanMethods treatmentPlanMethods = (TreatmentPlanMethods)appContext.getBean("treatmentPlanBean");
		static DataAccesses patientDataAccesses = (DataAccesses)appContext.getBean("patientsBean");
		
		@RequestMapping("/record")
		public static String editRecord(HttpServletRequest request, HttpServletResponse response, 
									  ModelMap model, Principal principal) throws IOException, ServletException{
			
			int treatment_plan_id = Integer.parseInt(request.getParameter("treatment_plan_id_hidden"));
			TreatmentPlan selectedTreatmentPlan = (TreatmentPlan) dataAccesses.findById(treatment_plan_id);
			
			request.getSession().setAttribute("selectedTreatmentPlan", selectedTreatmentPlan);
			System.out.println("Selected TreatmentPlan: "+selectedTreatmentPlan.getTreatment_plan_id());
			
			return "redirect:/patient/view_patient/details#edit_treatment_plan_div";
		}
		
		@RequestMapping("/add")
		public static String addMethod(HttpServletRequest request, HttpServletResponse response, 
										 ModelMap model, Principal principal) throws IOException, ServletException{
			
			Patient patient = (Patient) request.getSession().getAttribute("patient");
			Float treatment_fee = Float.valueOf(0);
			Float alternative_treatment_fee = Float.valueOf(0);
			try{
				treatment_fee = Float.parseFloat(request.getParameter("treatment_fee"));
				alternative_treatment_fee = Float.parseFloat(request.getParameter("alternative_treatment_fee"));
			}catch(Exception e){
				System.out.println("ERROR IN GETTING TREATMENT PLAN FEES");
			}
			
			
			String treatment = request.getParameter("treatment");
			String alternateTreatment = request.getParameter("alternative_treatment");
			Date treatment_date = new Date();
			int patient_id = patient.getPatient_id();
			
			TreatmentPlan treatmentPlan = new TreatmentPlan();
			
			treatmentPlan.setTreatment(treatment);
			treatmentPlan.setTreatment_fee(treatment_fee);
			treatmentPlan.setAlternative_treatment(alternateTreatment);
			treatmentPlan.setAlternative_treatment_fee(alternative_treatment_fee);
			treatmentPlan.setTreatment_date(treatment_date);
			treatmentPlan.setPatient_id(patient_id);
			dataAccesses.save(treatmentPlan);
		
			//update Patient's last visit date
			patient.setLast_visit_date(treatment_date);
			patientDataAccesses.update(patient);
			
			System.out.println("TREATMENT PLAN SAVED. CHANGE THE BUTTON IN JSP FROM 'SAVE' INTO 'SAVED' USING JS");
			
			return "redirect:/patient/view_patient/details";
		}
		
		@RequestMapping("/edit")
		public static String editMethod(HttpServletRequest request, HttpServletResponse response, 
									ModelMap model, Principal principal) throws IOException, ServletException{
		
			Patient patient = (Patient) request.getSession().getAttribute("patient");
			//int patient_id = patient.getPatient_id();
			
			int treatment_plan_id = Integer.parseInt(request.getParameter("treatment_plan_id"));
			String treatment = request.getParameter("treatment");
			Float treatment_fee = Float.parseFloat(request.getParameter("treatment_fee"));
			String alternateTreatment = request.getParameter("alternative_treatment");
			Float alternative_treatment_fee = Float.parseFloat(request.getParameter("alternative_treatment_fee"));
			Date treatment_date = new Date();
			
			TreatmentPlan treatmentPlan = (TreatmentPlan) dataAccesses.findById(treatment_plan_id);
			treatmentPlan.setTreatment(treatment);
			treatmentPlan.setTreatment_fee(treatment_fee);
			treatmentPlan.setAlternative_treatment(alternateTreatment);
			treatmentPlan.setAlternative_treatment_fee(alternative_treatment_fee);
			treatmentPlan.setTreatment_date(treatment_date);
			//treatmentPlan.setPatient_id(patient_id);
			dataAccesses.update(treatmentPlan);
			
			
			//update Patient's last visit date
			patient.setLast_visit_date(treatment_date);
			patientDataAccesses.update(patient);
			System.out.println("TREATMENT PLAN UPDATED. CHANGE THE BUTTON IN JSP FROM 'UPDATE' INTO 'UPDATED' USING JS");
			
			return "redirect:/patient/view_patient/details";
		}
}

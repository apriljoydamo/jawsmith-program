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
import com.jawsmith.model.DentalHistory;
import com.jawsmith.model.MedicalHistory;

@Controller
@RequestMapping("dental_history")
public class DentalHistoryController {
	static ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	static DataAccesses dataAccesses = (DataAccesses)appContext.getBean("dentalHistoryBean");
	
	/***
	 * NOTE: THIS METHOD DOES NOT RETURN TO ANY PAGE. IT JUST SAVES ALL OF THESE INTO ITS RESPECTIVE DATABASE
    	
	 * @param request
	 * @param response
	 * @param model
	 * @param principal
	 * @throws IOException
	 * @throws ServletException
	 */	
	//@RequestMapping("/add")
	public static void addMethod(HttpServletRequest request, HttpServletResponse response, 
									 ModelMap model, Principal principal) throws IOException, ServletException{
		
		Boolean fluoride_treatment = Boolean.parseBoolean(request.getParameter("fluoride_treatment"));
		Boolean orthodontic_treatment = Boolean.parseBoolean(request.getParameter("orthodontic_treatment"));
		Boolean pulp_therapy = Boolean.parseBoolean(request.getParameter("pulp_therapy"));
		Boolean temporo_mandibular = Boolean.parseBoolean(request.getParameter("temporo_mandibular"));
		Boolean periodontal_therapy = Boolean.parseBoolean(request.getParameter("periodontal_therapy"));
		Boolean dental_surgery = Boolean.parseBoolean(request.getParameter("dental_surgery"));
		Boolean extraction = Boolean.parseBoolean(request.getParameter("extraction"));
		Date last_visit_date = new Date();
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		
		DentalHistory dentalHistory = new DentalHistory();
		
		dentalHistory.setLast_visit_date(last_visit_date);
		dentalHistory.setFluoride_treatment(fluoride_treatment);
		dentalHistory.setOrthodontic_treatment(orthodontic_treatment);
		dentalHistory.setPulp_therapy(pulp_therapy);
		dentalHistory.setTemporo_mandibular(temporo_mandibular);
		dentalHistory.setPeriodontal_therapy(periodontal_therapy);
		dentalHistory.setDental_surgery(dental_surgery);
		dentalHistory.setExtraction(extraction);
		dentalHistory.setPatient_id(patient_id);
		
		dataAccesses.save(dentalHistory);
		System.out.println("DENTAL HISTORY SAVED. CHANGE THE BUTTON IN JSP FROM 'SAVE' INTO 'SAVED' USING JS");
		//return "view_patient";
	}
	
	@RequestMapping("/edit")
	public static void editMethod(HttpServletRequest request, HttpServletResponse response, 
	ModelMap model, Principal principal) throws IOException, ServletException{
		
		int dental_his_id = Integer.parseInt(request.getParameter("dental_his_id"));
		Boolean fluoride_treatment = Boolean.parseBoolean(request.getParameter("fluoride_treatment"));
		Boolean orthodontic_treatment = Boolean.parseBoolean(request.getParameter("orthodontic_treatment"));
		Boolean pulp_therapy = Boolean.parseBoolean(request.getParameter("pulp_therapy"));
		Boolean temporo_mandibular = Boolean.parseBoolean(request.getParameter("temporo_mandibular"));
		Boolean periodontal_therapy = Boolean.parseBoolean(request.getParameter("periodontal_therapy"));
		Boolean dental_surgery = Boolean.parseBoolean(request.getParameter("dental_surgery"));
		Boolean extraction = Boolean.parseBoolean(request.getParameter("extraction"));
		//Date last_visit_date = new Date();
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
	
		DentalHistory dentalHistory = (DentalHistory) dataAccesses.findById(dental_his_id);
		
		//dentalHistory.setLast_visit_date(last_visit_date);
		dentalHistory.setFluoride_treatment(fluoride_treatment);
		dentalHistory.setOrthodontic_treatment(orthodontic_treatment);
		dentalHistory.setPulp_therapy(pulp_therapy);
		dentalHistory.setTemporo_mandibular(temporo_mandibular);
		dentalHistory.setPeriodontal_therapy(periodontal_therapy);
		dentalHistory.setDental_surgery(dental_surgery);
		dentalHistory.setExtraction(extraction);
		dentalHistory.setPatient_id(patient_id);
		dataAccesses.update(dentalHistory);
		System.out.println("DENTAL HISTORY UPDATED. CHANGE THE BUTTON IN JSP FROM 'UPDATE' INTO 'UPDATED' USING JS");
		
    	//return "view_patient";
	}
}

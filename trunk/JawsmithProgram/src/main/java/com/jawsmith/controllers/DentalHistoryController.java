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
public class DentalHistoryController {
	ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	DataAccesses dataAccesses = (DataAccesses)appContext.getBean("dentalHistoryBean");

	@RequestMapping("/dental_history/add")
	public String AddMethod(HttpServletRequest request, HttpServletResponse response, 
									 ModelMap model, Principal principal) throws IOException, ServletException{
	
		DentalHistory dentalHistory = new DentalHistory();
		
		Date last_visit_date = new Date();
		Boolean fluoride_treatment = (Boolean)request.getAttribute("fluoride_treatment");
		Boolean orthodontic_treatment = (Boolean)request.getAttribute("orthodontic_treatment");
		Boolean pulp_therapy = (Boolean)request.getAttribute("pulp_therapy");
		Boolean temporo_mandibular = (Boolean)request.getAttribute("temporo_mandibular");
		Boolean periodontal_therapy = (Boolean)request.getAttribute("periodontal_therapy");
		Boolean dental_surgery = (Boolean)request.getAttribute("dental_surgery");
		int extraction = (Integer)request.getAttribute("extraction");
		int patient_id = (Integer)request.getAttribute("patient_id");
		
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
		
		//Adding the list for the view
		//Return to module main page
    	return "view_patient";
	}
	
	@RequestMapping("/patient/edit")
	public String EditMethod(HttpServletRequest request, HttpServletResponse response, 
	ModelMap model, Principal principal) throws IOException, ServletException{
		
		DentalHistory dentalHistory = new DentalHistory();
		
		Date last_visit_date = new Date();
		Boolean fluoride_treatment = (Boolean)request.getAttribute("fluoride_treatment");
		Boolean orthodontic_treatment = (Boolean)request.getAttribute("orthodontic_treatment");
		Boolean pulp_therapy = (Boolean)request.getAttribute("pulp_therapy");
		Boolean temporo_mandibular = (Boolean)request.getAttribute("temporo_mandibular");
		Boolean periodontal_therapy = (Boolean)request.getAttribute("periodontal_therapy");
		Boolean dental_surgery = (Boolean)request.getAttribute("dental_surgery");
		int extraction = (Integer)request.getAttribute("extraction");
		int patient_id = (Integer)request.getAttribute("patient_id");
		
		dentalHistory.setLast_visit_date(last_visit_date);
		dentalHistory.setFluoride_treatment(fluoride_treatment);
		dentalHistory.setOrthodontic_treatment(orthodontic_treatment);
		dentalHistory.setPulp_therapy(pulp_therapy);
		dentalHistory.setTemporo_mandibular(temporo_mandibular);
		dentalHistory.setPeriodontal_therapy(periodontal_therapy);
		dentalHistory.setDental_surgery(dental_surgery);
		dentalHistory.setExtraction(extraction);
		dentalHistory.setPatient_id(patient_id);
		
		dataAccesses.update(dentalHistory);
		
    	return "view_patient";
	}
	
	@RequestMapping("/patient/delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, 
	ModelMap model, Principal principal) throws IOException, ServletException{
		
		DentalHistory dentalHistory = new DentalHistory();
		
		//dataAccesses.update(dentalHistory);
		
    	return "view_patient";
	}
	
}

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
import com.jawsmith.interfaces.OtherInformationMethods;
import com.jawsmith.model.Anxillaries;
import com.jawsmith.model.ClinicalExamination;
import com.jawsmith.model.OtherInformation;
import com.jawsmith.model.Patient;

@Controller
@RequestMapping("other_information")
public class OtherInformationController {
	static ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	static DataAccesses dataAccesses = (DataAccesses)appContext.getBean("otherInformationBean");
	static OtherInformationMethods otherInformationMethods = (OtherInformationMethods)appContext.getBean("otherInformationBean");
	
	
	@RequestMapping("/add")
	public static void addMethod(HttpServletRequest request, HttpServletResponse response, 
									 ModelMap model, Principal principal) throws IOException, ServletException{
	
		OtherInformation otherInformation = new OtherInformation();
		
		String chief_complaint = (String)request.getParameter("chief_complaint");
		String diagnosis = (String)request.getParameter("diagnosis");
		Date last_visit_date = new Date();
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		
		otherInformation.setChief_complaint(chief_complaint);
		otherInformation.setDiagnosis(diagnosis);
		otherInformation.setLast_visit_date(last_visit_date);
		otherInformation.setPatient_id(patient_id);
		dataAccesses.save(otherInformation);
		System.out.println("OTHER INFO SAVED. CHANGE THE BUTTON IN JSP FROM 'SAVE' INTO 'SAVED' USING JS");
		
	}
	
	@RequestMapping("/edit")
	public static void editMethod(HttpServletRequest request, HttpServletResponse response, 
	ModelMap model, Principal principal) throws IOException, ServletException{
		
		
		Patient patient = (Patient) request.getAttribute("patient");
		
		int other_info_id = Integer.parseInt(request.getParameter("other_info_id"));
		String chief_complaint = (String)request.getParameter("chief_complaint");
		String diagnosis = (String)request.getParameter("diagnosis");
		//Date last_visit_date = new Date();
		int patient_id = patient.getPatient_id();
		
		OtherInformation otherInformation = (OtherInformation) otherInformationMethods.findByPatientId(other_info_id);
		
		otherInformation.setChief_complaint(chief_complaint);
		otherInformation.setDiagnosis(diagnosis);
		//otherInformation.setLast_visit_date(last_visit_date);
		otherInformation.setPatient_id(patient_id);
		dataAccesses.save(otherInformation);
		System.out.println("OTHER INFO UPDATED. CHANGE THE BUTTON IN JSP FROM 'UPDATE' INTO 'UPDATED' USING JS");
	}
}

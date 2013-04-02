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
import com.jawsmith.interfaces.OcclusionMethods;
import com.jawsmith.model.Anxillaries;
import com.jawsmith.model.ClinicalExamination;
import com.jawsmith.model.Occlusion;
import com.jawsmith.model.Patient;

@Controller
@RequestMapping("occlusion")
public class OcclusionController {
	static ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	static DataAccesses dataAccesses = (DataAccesses)appContext.getBean("occlusionBean");
	static OcclusionMethods occlusionMethods = (OcclusionMethods)appContext.getBean("occlusionBean");
	
	public static void addMethod(HttpServletRequest request, HttpServletResponse response, 
									 ModelMap model, Principal principal) throws IOException, ServletException{
		
		String class_1 = (String)request.getParameter("class_1");
		String class_2 = (String)request.getParameter("class_2");
		String class_3 = (String)request.getParameter("class_3");
		Date last_visit_date = new Date();
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		
		Occlusion occlusion = new Occlusion();
		
		occlusion.setClass_1(class_1);
		occlusion.setClass_2(class_2);
		occlusion.setClass_3(class_3);
		occlusion.setLast_visit_date(last_visit_date);
		occlusion.setPatient_id(patient_id);
		dataAccesses.save(occlusion);
		System.out.println("OCCLUSION SAVED. CHANGE THE BUTTON IN JSP FROM 'SAVE' INTO 'SAVED' USING JS");
		
	}
	
	public static void editMethod(HttpServletRequest request, HttpServletResponse response, 
	ModelMap model, Principal principal) throws IOException, ServletException{

		Patient patient = (Patient) request.getSession().getAttribute("patient");
		int patient_id = patient.getPatient_id();
		
		String class_1 = (String)request.getParameter("class_1");
		String class_2 = (String)request.getParameter("class_2");
		String class_3 = (String)request.getParameter("class_3");
		Date last_visit_date = new Date();
		
		
		Occlusion occlusion = (Occlusion) occlusionMethods.findByPatientId(patient_id);
		
		occlusion.setClass_1(class_1);
		occlusion.setClass_2(class_2);
		occlusion.setClass_3(class_3);
		occlusion.setLast_visit_date(last_visit_date);
		dataAccesses.update(occlusion);
		System.out.println("OCCLUSION UPDATED. CHANGE THE BUTTON IN JSP FROM 'SAVE' INTO 'SAVED' USING JS");
	}
	
}

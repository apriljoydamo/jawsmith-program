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

import com.jawsmith.interfaces.AnxillariesMethods;
import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.model.Anxillaries;
import com.jawsmith.model.Patient;

@Controller
@RequestMapping("anxillaries")
public class AnxillariesController {
	static ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	static DataAccesses dataAccesses = (DataAccesses)appContext.getBean("anxillariesBean");
	static AnxillariesMethods anxillariesMethods = (AnxillariesMethods)appContext.getBean("anxillariesBean");
	
	
	public static void addMethod(HttpServletRequest request, HttpServletResponse response, 
							ModelMap model, Principal principal) throws IOException, ServletException{
		
		String bleeding_time = (String)request.getParameter("bleeding_time");
		String blood_pressure = (String)request.getParameter("blood_pressure");
		String radiographic_interpretation = (String)request.getParameter("radiographic_interpretation");
		String clotting_time = (String)request.getParameter("clotting_time");
		String blood_sugar = (String)request.getParameter("blood_sugar");
		Date last_visit_date = new Date();
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		
		Anxillaries anxillaries = new Anxillaries();
		anxillaries.setBleeding_time(bleeding_time);
		anxillaries.setBlood_pressure(blood_pressure);
		anxillaries.setBlood_sugar(blood_sugar);
		anxillaries.setClotting_time(clotting_time);
		anxillaries.setRadiographic_interpretation(radiographic_interpretation);
		anxillaries.setLast_visit_date(last_visit_date);
		anxillaries.setPatient_id(patient_id);
		dataAccesses.save(anxillaries);
		System.out.println("ANXILLARIES SAVED. CHANGE THE BUTTON IN JSP FROM 'SAVE' INTO 'SAVED' USING JS");
	}
	
	public static void editMethod(HttpServletRequest request, HttpServletResponse response, 
	ModelMap model, Principal principal) throws IOException, ServletException{
		
		Patient patient = (Patient) request.getSession().getAttribute("patient");
		int patient_id = patient.getPatient_id();
		
		String bleeding_time = (String)request.getParameter("bleeding_time");
		String blood_pressure = (String)request.getParameter("blood_pressure");
		String radiographic_interpretation = (String)request.getParameter("radiographic_interpretation");
		String clotting_time = (String)request.getParameter("clotting_time");
		String blood_sugar = (String)request.getParameter("blood_sugar");
		Date last_visit_date = new Date();
	
		
		Anxillaries anxillaries = (Anxillaries) anxillariesMethods.findByPatientId(patient_id);
		
		anxillaries.setBleeding_time(bleeding_time);
		anxillaries.setBlood_pressure(blood_pressure);
		anxillaries.setBlood_sugar(blood_sugar);
		anxillaries.setClotting_time(clotting_time);
		anxillaries.setRadiographic_interpretation(radiographic_interpretation);
		anxillaries.setLast_visit_date(last_visit_date);
		anxillaries.setPatient_id(patient_id);
		dataAccesses.update(anxillaries);
		System.out.println("ANXILLARIES UPDATED. CHANGE THE BUTTON IN JSP FROM 'UPDATE' INTO 'UPDATED' USING JS");
   	}
	
}

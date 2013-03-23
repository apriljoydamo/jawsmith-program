package com.jawsmith.controllers;


import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
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
import com.jawsmith.model.MedicalHistory;
import com.jawsmith.model.Patient;




@Controller
@RequestMapping("medical_history")
public class MedicalHistoryController {
		static ApplicationContext appContext = 
			new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		static DataAccesses dataAccesses = (DataAccesses)appContext.getBean("medicalHistoryBean");
	
		//@RequestMapping("/add")
		public static void addMethod(HttpServletRequest request, HttpServletResponse response, 
										 ModelMap model, Principal principal) throws IOException, ServletException{
		
			String question[] = new String[17];
			question[0] = request.getParameter("question1");
			
			String answer[] = new String[17];
			answer[0] = request.getParameter("answer1");
			
			Date last_visit_date= new Date();
			int patient_id = Integer.parseInt(request.getParameter("patient_id"));
			
			MedicalHistory medicalHistory = new MedicalHistory();
			medicalHistory.setLast_visit_date(last_visit_date);
			medicalHistory.setPatient_id(patient_id);
			//medicalHistory.setQuestion_id(question);
			//medicalHistory.setAnswer(answer);
			
			dataAccesses.save(medicalHistory);
			System.out.println("MEDICAL HISTORY SAVED. CHANGE THE BUTTON IN JSP FROM 'SAVE' INTO 'SAVED' USING JS");
		}
		
		//@RequestMapping("/edit")
		public static void EditMethod(HttpServletRequest request, HttpServletResponse response, 
		ModelMap model, Principal principal) throws IOException, ServletException{
			
			int medical_history_id = Integer.parseInt(request.getParameter("medical_history_id"));
			
			String question[] = new String[17];
			question[0] = request.getParameter("question1");
			
			String answer[] = new String[17];
			answer[0] = request.getParameter("answer1");
			
			//Date last_visit_date= new Date();
			int patient_id = Integer.parseInt(request.getParameter("patient_id"));
			
			
			MedicalHistory medicalHistory = (MedicalHistory) dataAccesses.findById(medical_history_id);
			//medicalHistory.setLast_visit_date(last_visit_date);
			medicalHistory.setPatient_id(patient_id);
			//medicalHistory.setQuestion_id(question);
			//medicalHistory.setAnswer(answer);
			
			dataAccesses.update(medicalHistory);
			System.out.println("MEDICAL HISTORY UPDATED. CHANGE THE BUTTON IN JSP FROM 'UPDATE' INTO 'UPDATED' USING JS");
		}		  
}

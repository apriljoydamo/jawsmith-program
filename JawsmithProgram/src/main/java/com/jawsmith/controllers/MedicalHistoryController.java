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
import com.jawsmith.interfaces.MedicalHistoryMethods;
import com.jawsmith.model.MedicalHistory;
import com.jawsmith.model.Patient;




@Controller
@RequestMapping("medical_history")
public class MedicalHistoryController {
		static ApplicationContext appContext = 
			new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		static DataAccesses dataAccesses = (DataAccesses)appContext.getBean("medicalHistoryBean");
		static MedicalHistoryMethods medicalHistoryMethods = (MedicalHistoryMethods)appContext.getBean("medicalHistoryBean");
		
		
		//@RequestMapping("/add")
		public static void addMethod(HttpServletRequest request, HttpServletResponse response, 
										 ModelMap model, Principal principal) throws IOException, ServletException{
		
			String question[] = new String[7];
			question[0] = request.getParameter("question1");
			question[1] = request.getParameter("question2");
			question[2] = request.getParameter("question3");
			question[3] = request.getParameter("question4");
			question[4] = request.getParameter("question5");
			question[5] = request.getParameter("question6");
			question[6] = request.getParameter("question7");
			
			String answer[] = new String[7];
			answer[0] = request.getParameter("answer1");
			answer[1] = request.getParameter("answer2");
			answer[2] = request.getParameter("answer3");
			answer[3] = request.getParameter("answer4");
			answer[4] = request.getParameter("answer5");
			answer[5] = request.getParameter("answer6");
			answer[6] = request.getParameter("answer7");
			
			Date last_visit_date= new Date();
			int patient_id = Integer.parseInt(request.getParameter("patient_id"));
			
			MedicalHistory medicalHistory = new MedicalHistory();
			medicalHistory.setLast_visit_date(last_visit_date);
			medicalHistory.setPatient_id(patient_id);
			medicalHistory.setQuestion_id(question);
			medicalHistory.setAnswer(answer);
			//medicalHistory.setQuestion_id(question);
			//medicalHistory.setAnswer(answer);
			
			dataAccesses.save(medicalHistory);
			System.out.println("MEDICAL HISTORY SAVED. CHANGE THE BUTTON IN JSP FROM 'SAVE' INTO 'SAVED' USING JS");
		}
		
		//@RequestMapping("/edit")
		public static void EditMethod(HttpServletRequest request, HttpServletResponse response, 
		ModelMap model, Principal principal) throws IOException, ServletException{
			
		
			Patient patient = (Patient) request.getAttribute("patient");
			int med_history_patient_id = (Integer)patient.getPatient_id();
		
	
			MedicalHistory medicalHistory = (MedicalHistory)medicalHistoryMethods.findByPatientId(med_history_patient_id);
			
			
			String question[] = new String[17];
			question[0] = request.getParameter("question1");
			question[1] = request.getParameter("question2");
			question[2] = request.getParameter("question3");
			question[3] = request.getParameter("question4");
			question[4] = request.getParameter("question5");
			question[5] = request.getParameter("question6");
			question[6] = request.getParameter("question7");
			
			String answer[] = new String[17];
			answer[0] = request.getParameter("answer1");
			answer[1] = request.getParameter("answer2");
			answer[2] = request.getParameter("answer3");
			answer[3] = request.getParameter("answer4");
			answer[4] = request.getParameter("answer5");
			answer[5] = request.getParameter("answer6");
			answer[6] = request.getParameter("answer7");
			
			//Date last_visit_date= new Date();
			
			
			
			//medicalHistory.setLast_visit_date(last_visit_date);
			medicalHistory.setQuestion_id(question);
			medicalHistory.setAnswer(answer);
			//medicalHistory.setQuestion_id(question);
			//medicalHistory.setAnswer(answer);
			
			dataAccesses.update(medicalHistory);
			System.out.println("MEDICAL HISTORY UPDATED. CHANGE THE BUTTON IN JSP FROM 'UPDATE' INTO 'UPDATED' USING JS");
		}		  
}

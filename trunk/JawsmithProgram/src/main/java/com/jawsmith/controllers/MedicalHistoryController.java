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
		
			String appendedPhysicalAilments = "";
			
			String[] question = (String[]) request.getParameterValues("question");
			String[] answer = (String[]) request.getParameterValues("answer");
			String[] physical_ailments = (String[]) request.getParameterValues("physical_ailments");
			
			//Append physical ailments
			if(physical_ailments!=null){
				for(int i=0;i<physical_ailments.length;i++){
					System.out.println(physical_ailments[i]);
					if(i==(physical_ailments.length-1))
						appendedPhysicalAilments+=physical_ailments[i];
					else
						appendedPhysicalAilments+=physical_ailments[i] + ",";
				}
			}
			System.out.println("Question: "+question.length);
			System.out.println("Answer: "+answer.length);
			System.out.println("Appended Physical Ailments: "+appendedPhysicalAilments);
			/*
			ArrayList<String> questions = new ArrayList<String>();
			questions.add(request.getParameter("question1"));
			questions.add(request.getParameter("question2"));
			questions.add(request.getParameter("question3"));
			questions.add(request.getParameter("question4"));
			questions.add(request.getParameter("question5"));
			questions.add(request.getParameter("question6"));
			questions.add(request.getParameter("question7"));
			questions.add(request.getParameter("question8"));
			
			String answer[] = new String[8];
			answer[0] = request.getParameter("answer1");
			answer[1] = request.getParameter("physical_ailments");
			answer[2] = request.getParameter("answer3");
			answer[3] = request.getParameter("answer4");
			answer[4] = request.getParameter("answer5");
			answer[5] = request.getParameter("answer6");
			answer[6] = request.getParameter("answer7");
			answer[7] = request.getParameter("answer8");
			
			*/
			
			Date last_visit_date= new Date();
			int patient_id = Integer.parseInt(request.getParameter("patient_id"));
			int y = 0;
			for(int x=0; x<question.length; x++){
				System.out.println("Value of x:"+x);
				MedicalHistory medicalHistory = new MedicalHistory();
				medicalHistory.setLast_visit_date(last_visit_date);
				medicalHistory.setPatient_id(patient_id);
				medicalHistory.setQuestion_id(question[x]);
				System.out.println("Question #"+question[x]);
				if(x==1){
					medicalHistory.setAnswer(appendedPhysicalAilments);
					System.out.println("Anwer: "+appendedPhysicalAilments);					
				}else{
					medicalHistory.setAnswer(answer[y]);
					System.out.println("Answer: "+answer[y]);
					y++;
				}
				dataAccesses.save(medicalHistory);
			}
			
			System.out.println("MEDICAL HISTORY SAVED. CHANGE THE BUTTON IN JSP FROM 'SAVE' INTO 'SAVED' USING JS");
		}
		
		//@RequestMapping("/edit")
		public static void editMethod(HttpServletRequest request, HttpServletResponse response, 
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
			question[7] = request.getParameter("question8");
			
			String answer[] = new String[17];
			answer[0] = request.getParameter("answer1");
			answer[1] = request.getParameter("answer2");
			answer[2] = request.getParameter("answer3");
			answer[3] = request.getParameter("answer4");
			answer[4] = request.getParameter("answer5");
			answer[5] = request.getParameter("answer6");
			answer[6] = request.getParameter("answer7");
			answer[7] = request.getParameter("answer8");
			
			//medicalHistory.setLast_visit_date(last_visit_date);
			//medicalHistory.setQuestion_id(question);
			//medicalHistory.setAnswer(answer);
			//medicalHistory.setQuestion_id(question);
			//medicalHistory.setAnswer(answer);
			for(int x=0; x<=8; x++){
				medicalHistory.setQuestion_id(question[x]);
				medicalHistory.setAnswer(answer[x]);
				dataAccesses.update(medicalHistory);
			}
			System.out.println("MEDICAL HISTORY UPDATED. CHANGE THE BUTTON IN JSP FROM 'UPDATE' INTO 'UPDATED' USING JS");
		}		
		
		
}

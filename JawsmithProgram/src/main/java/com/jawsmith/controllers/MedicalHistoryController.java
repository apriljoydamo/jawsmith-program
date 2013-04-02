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
			
		
			Patient patient = (Patient) request.getSession().getAttribute("patient");
			int patientId = patient.getPatient_id();
			Date lastVisitDate = patient.getLast_visit_date();
	
			List<MedicalHistory> medicalHistoryList = medicalHistoryMethods.findByPatientIdAndLastVisitDate(patientId, lastVisitDate);
			
			
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
				
			Iterator iter = medicalHistoryList.iterator();
			while(iter.hasNext()){
				int y = 0;
				for(int x=0; x<question.length; x++){
					System.out.println("Value of x:"+x);
					MedicalHistory medicalHistory = (MedicalHistory) iter.next();
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
					dataAccesses.update(medicalHistory);
				}
			}
			
			System.out.println("MEDICAL HISTORY UPDATED. CHANGE THE BUTTON IN JSP FROM 'UPDATE' INTO 'UPDATED' USING JS");
		}		
		
		
}

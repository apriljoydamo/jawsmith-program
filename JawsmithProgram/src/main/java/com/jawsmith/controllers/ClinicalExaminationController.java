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

import com.jawsmith.interfaces.ClinicalExaminationMethods;
import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.model.ClinicalExamination;
import com.jawsmith.model.DentalHistory;
import com.jawsmith.model.Patient;

@Controller
@RequestMapping("clinical_examination")
public class ClinicalExaminationController {
	static ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	static DataAccesses dataAccesses = (DataAccesses)appContext.getBean("clinicalExaminationBean");
	static ClinicalExaminationMethods clinicalExaminationMethods = (ClinicalExaminationMethods)appContext.getBean("clinicalExaminationBean");

	@RequestMapping("/add")
	public static void addMethod(HttpServletRequest request, HttpServletResponse response, 
									 ModelMap model, Principal principal) throws IOException, ServletException{
	
		String gingival_color = (String)request.getParameter("gingival_color");
		String consistency_of_gingival = (String)request.getParameter("consistency_of_gingival");
		String tounge = (String)request.getParameter("tounge");
		String oral_hygiene = (String)request.getParameter("oral_hygiene");
		String lymph_nodes = (String)request.getParameter("lymph_nodes");
		Date last_visit_date = new Date();
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		
		ClinicalExamination clinicalExamination = new ClinicalExamination();
		
		clinicalExamination.setGingival_color(gingival_color);
		clinicalExamination.setConsistency_of_gingival(consistency_of_gingival);
		clinicalExamination.setTounge(tounge);
		clinicalExamination.setOral_hygiene(oral_hygiene);
		clinicalExamination.setLymph_nodes(lymph_nodes);
		clinicalExamination.setLast_visit_date(last_visit_date);
		clinicalExamination.setPatient_id(patient_id);
		dataAccesses.save(clinicalExamination);
		System.out.println("CLINICAL EXAMINATION SAVED. CHANGE THE BUTTON IN JSP FROM 'SAVE' INTO 'SAVED' USING JS");
		
	}
	
	@RequestMapping("/edit")
	public static void editMethod(HttpServletRequest request, HttpServletResponse response, 
	ModelMap model, Principal principal) throws IOException, ServletException{
		
		Patient patient = (Patient) request.getAttribute("patient");
		int clinical_exam_patient_id = (Integer)patient.getPatient_id();
		int clinical_exam_id = Integer.parseInt(request.getParameter("clinical_exam_id"));
		String gingival_color = (String)request.getParameter("gingival_color");
		String consistency_of_gingival = (String)request.getParameter("consistency_of_gingival");
		String tounge = (String)request.getParameter("tounge");
		String oral_hygiene = (String)request.getParameter("oral_hygiene");
		String lymph_nodes = (String)request.getParameter("lymph_nodes");
		//Date last_visit_date = new Date();

		
		ClinicalExamination clinicalExamination = (ClinicalExamination) clinicalExaminationMethods.findByPatientId(clinical_exam_id);
		
		clinicalExamination.setGingival_color(gingival_color);
		clinicalExamination.setConsistency_of_gingival(consistency_of_gingival);
		clinicalExamination.setTounge(tounge);
		clinicalExamination.setOral_hygiene(oral_hygiene);
		clinicalExamination.setLymph_nodes(lymph_nodes);
		//clinicalExamination.setLast_visit_date(last_visit_date);
		clinicalExamination.setPatient_id(clinical_exam_patient_id);
		dataAccesses.update(clinicalExamination);
		System.out.println("CLINICAL EXAMINATION UPDATED. CHANGE THE BUTTON IN JSP FROM 'UPDATE' INTO 'UPDATED' USING JS");
		
	}
	
}

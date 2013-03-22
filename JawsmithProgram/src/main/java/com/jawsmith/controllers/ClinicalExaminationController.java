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
import com.jawsmith.model.ClinicalExamination;
import com.jawsmith.model.DentalHistory;

@Controller
public class ClinicalExaminationController {
	ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	DataAccesses dataAccesses = (DataAccesses)appContext.getBean("clinicalExaminationBean");

	@RequestMapping("/clinical_examination/add")
	public String AddMethod(HttpServletRequest request, HttpServletResponse response, 
									 ModelMap model, Principal principal) throws IOException, ServletException{
	
		ClinicalExamination clinicalExamination = new ClinicalExamination();
		
		Date last_visit_date = new Date();
		String gingival_color = (String)request.getAttribute("gingival_color");
		String consistency_of_gingival = (String)request.getAttribute("consistency_of_gingival");
		String tounge = (String)request.getAttribute("tounge");
		String oral_hygiene = (String)request.getAttribute("oral_hygiene");
		String lymph_nodes = (String)request.getAttribute("lymph_nodes");
		
		
		clinicalExamination.setGingival_color(gingival_color);
		clinicalExamination.setConsistency_of_gingival(consistency_of_gingival);
		clinicalExamination.setTounge(tounge);
		clinicalExamination.setOral_hygiene(oral_hygiene);
		clinicalExamination.setLymph_nodes(lymph_nodes);
		
		dataAccesses.save(clinicalExamination);
		
		//Adding the list for the view
		//Return to module main page
    	return "view_patient";
	}
	
	@RequestMapping("/patient/edit")
	public String EditMethod(HttpServletRequest request, HttpServletResponse response, 
	ModelMap model, Principal principal) throws IOException, ServletException{
		
		ClinicalExamination clinicalExamination = new ClinicalExamination();
		
		Date last_visit_date = new Date();
		String gingival_color = (String)request.getAttribute("gingival_color");
		String consistency_of_gingival = (String)request.getAttribute("consistency_of_gingival");
		String tounge = (String)request.getAttribute("tounge");
		String oral_hygiene = (String)request.getAttribute("oral_hygiene");
		String lymph_nodes = (String)request.getAttribute("lymph_nodes");
		
		
		clinicalExamination.setGingival_color(gingival_color);
		clinicalExamination.setConsistency_of_gingival(consistency_of_gingival);
		clinicalExamination.setTounge(tounge);
		clinicalExamination.setOral_hygiene(oral_hygiene);
		clinicalExamination.setLymph_nodes(lymph_nodes);
		
		dataAccesses.update(clinicalExamination);
		
		//Adding the list for the view
		//Return to module main page
    	return "view_patient";
	}
	
	@RequestMapping("/patient/delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, 
	ModelMap model, Principal principal) throws IOException, ServletException{
		
		ClinicalExamination clinicalExamination = new ClinicalExamination();
		
		//dataAccesses.update(dentalHistory);
		
    	return "view_patient";
	}
	
}

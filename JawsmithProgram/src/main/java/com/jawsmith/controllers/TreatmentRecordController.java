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
import com.jawsmith.model.TreatmentPlan;
import com.jawsmith.model.TreatmentRecord;

@Controller
@RequestMapping("treatment_record")
public class TreatmentRecordController {
	ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	DataAccesses dataAccesses = (DataAccesses)appContext.getBean("treatmentRecordBean");
	
	
	@RequestMapping("/add")
	public void addMethod(HttpServletRequest request, HttpServletResponse response, 
									 ModelMap model, Principal principal) throws IOException, ServletException{
		
		String tooth_number = request.getParameter("tooth_number");
		String description = request.getParameter("description");
		String prescription = request.getParameter("prescription");
		Float debit = Float.parseFloat(request.getParameter("debit"));
		Date credit_date = new Date();
		Float credit_amount = Float.parseFloat(request.getParameter("credit_amount"));
		Date last_visit_date = new Date();
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		
		TreatmentRecord treatmentRecord = new TreatmentRecord();
		
		treatmentRecord.setTooth_number(tooth_number);
		treatmentRecord.setDescription(description);
		treatmentRecord.setPrescription(prescription);
		treatmentRecord.setDebit(debit);
		treatmentRecord.setCredit_date(credit_date);
		treatmentRecord.setCredit_amount(credit_amount);
		treatmentRecord.setLast_visit_date(last_visit_date);
		treatmentRecord.setPatient_id(patient_id);
		dataAccesses.save(treatmentRecord);
		System.out.println("TREATMENT RECORD SAVED. CHANGE THE BUTTON IN JSP FROM 'SAVE' INTO 'SAVED' USING JS");
	}
	
	@RequestMapping("/edit")
	public void editMethod(HttpServletRequest request, HttpServletResponse response, 
								ModelMap model, Principal principal) throws IOException, ServletException{
		
		String tooth_number = request.getParameter("tooth_number");
		String description = request.getParameter("description");
		String prescription = request.getParameter("prescription");
		Float debit = Float.parseFloat(request.getParameter("debit"));
		Date credit_date = new Date();
		Float credit_amount = Float.parseFloat(request.getParameter("credit_amount"));
		Date last_visit_date = new Date();
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		int treatment_record_id = Integer.parseInt(request.getParameter("treatment_record_id"));
		
		TreatmentRecord treatmentRecord =  (TreatmentRecord) dataAccesses.findById(treatment_record_id);
		
		treatmentRecord.setTooth_number(tooth_number);
		treatmentRecord.setDescription(description);
		treatmentRecord.setPrescription(prescription);
		treatmentRecord.setDebit(debit);
		treatmentRecord.setCredit_date(credit_date);
		treatmentRecord.setCredit_amount(credit_amount);
		treatmentRecord.setLast_visit_date(last_visit_date);
		treatmentRecord.setPatient_id(patient_id);
		dataAccesses.update(treatmentRecord);
		System.out.println("TREATMENT RECORD UPDATED. CHANGE THE BUTTON IN JSP FROM 'UPDATE' INTO 'UPDATED' USING JS");
		
	}
}

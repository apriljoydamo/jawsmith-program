package com.jawsmith.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.TreatmentRecordMethods;
import com.jawsmith.model.Patient;
import com.jawsmith.model.TableMaintenance;
import com.jawsmith.model.TreatmentRecord;

@Controller
@RequestMapping("treatment_record")
public class TreatmentRecordController {
	 ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	 DataAccesses dataAccesses = (DataAccesses)appContext.getBean("treatmentRecordBean");
	 TreatmentRecordMethods treatmentRecordMethods = (TreatmentRecordMethods)appContext.getBean("treatmentRecordBean");
	 DataAccesses patientDataAccesses = (DataAccesses)appContext.getBean("patientsBean");
		
	
	@RequestMapping("/view")
	public String viewMethod(HttpServletRequest request, HttpServletResponse response, 
									 ModelMap model, Principal principal) throws IOException, ServletException{
		float balancePerDate;
		float totalBalance = 0;
		Patient patient = (Patient) request.getSession().getAttribute("patient");
		List<TreatmentRecord> treatmentRecordList = treatmentRecordMethods.findByPatientId(patient.getPatient_id());
		
		Iterator<TreatmentRecord> iter = treatmentRecordList.iterator();
		while(iter.hasNext()){
			TreatmentRecord tr = (TreatmentRecord) iter.next();
			balancePerDate = tr.getDebit()-tr.getCredit_amount();
			totalBalance += balancePerDate;
		}
		model.addAttribute("treatmentRecordList", treatmentRecordList);
		model.addAttribute("totalBalance", totalBalance);
		
		return "treatment_record";
	}
	
	@RequestMapping("/record")
	public String editRecord(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		
		int treatment_record_id = Integer.parseInt(request.getParameter("treatment_record_id_hidden"));
		TreatmentRecord selectedTreatmentRecord = (TreatmentRecord) dataAccesses.findById(treatment_record_id);
		
		request.getSession().setAttribute("selectedTreatmentRecord", selectedTreatmentRecord);
		System.out.println("Selected Treatment Record: "+selectedTreatmentRecord.getTreatment_record_id());
		
		return "redirect:/treatment_record/view#edit_treatment_record_div";
	}
	
	@RequestMapping("/add")
	public String addMethod(HttpServletRequest request, HttpServletResponse response, 
									 ModelMap model, Principal principal) throws IOException, ServletException{
		Patient patient = (Patient) request.getSession().getAttribute("patient");
		
		String tooth_number = request.getParameter("tooth_number");
		String description = request.getParameter("description");
		String prescription = request.getParameter("prescription");
		Float debit = Float.parseFloat(request.getParameter("debit"));
		Float credit_amount = Float.parseFloat(request.getParameter("credit_amount"));
		Date last_visit_date = new Date();
		Date credit_date = new Date();
		int treatment_record_patient_id = patient.getPatient_id();
		
		TreatmentRecord treatmentRecord = new TreatmentRecord();
		
		treatmentRecord.setTooth_number(tooth_number);
		treatmentRecord.setDescription(description);
		treatmentRecord.setPrescription(prescription);
		treatmentRecord.setDebit(debit);
		treatmentRecord.setCredit_date(credit_date);
		treatmentRecord.setCredit_amount(credit_amount);
		treatmentRecord.setLast_visit_date(last_visit_date);
		treatmentRecord.setPatient_id(treatment_record_patient_id);
		dataAccesses.save(treatmentRecord);
		
		//update Patient's last visit date
		patient.setLast_visit_date(last_visit_date);
		patientDataAccesses.update(patient);
		
		System.out.println("TREATMENT RECORD SAVED. CHANGE THE BUTTON IN JSP FROM 'SAVE' INTO 'SAVED' USING JS");
	
		return "redirect:/treatment_record/view";
	}
	
	
	
	@RequestMapping("/edit")
	public String editMethod(HttpServletRequest request, HttpServletResponse response, 
								ModelMap model, Principal principal) throws IOException, ServletException{
		
		Patient patient = (Patient) request.getSession().getAttribute("patient");
		
		/*String tooth_number = request.getParameter("tooth_number");
		String description = request.getParameter("description");
		String prescription = request.getParameter("prescription");
		Float debit = Float.parseFloat(request.getParameter("debit"));
		Float credit_amount = Float.parseFloat(request.getParameter("credit_amount"));
		Date credit_date = new Date();*/
		
		String description_notes = request.getParameter("description_notes");
		Date last_visit_date = new Date();
		int treatment_record_id = Integer.parseInt(request.getParameter("treatment_record_id"));
		
		TreatmentRecord treatmentRecord =  (TreatmentRecord) dataAccesses.findById(treatment_record_id);
		
		/*treatmentRecord.setTooth_number(tooth_number);
		treatmentRecord.setDescription(description);
		treatmentRecord.setPrescription(prescription);
		treatmentRecord.setDebit(debit);
		treatmentRecord.setCredit_date(credit_date);
		treatmentRecord.setCredit_amount(credit_amount);*/
		//treatmentRecord.setPatient_id(patient_id);
		treatmentRecord.setLast_visit_date(last_visit_date);
		treatmentRecord.setDescription_notes(description_notes);
		dataAccesses.update(treatmentRecord);
		
		//update Patient's last visit date
		patient.setLast_visit_date(last_visit_date);
		patientDataAccesses.update(patient);
		System.out.println("TREATMENT RECORD UPDATED. CHANGE THE BUTTON IN JSP FROM 'UPDATE' INTO 'UPDATED' USING JS");
		
		return "redirect:/treatment_record/view";
	}
}

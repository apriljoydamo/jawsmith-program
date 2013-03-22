package com.jawsmith.controllers;


import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.jawsmith.common.GetDateAndTime;
import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.TableMaintenanceMethods;
import com.jawsmith.model.Patient;
import com.jawsmith.model.TableMaintenance;

@Controller
@RequestMapping("patient")
public class PatientController {
ApplicationContext appContext = 
			new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		DataAccesses dataAccesses = (DataAccesses)appContext.getBean("patientsBean");
		DataAccesses tblMaintenanceDataAccesses = (DataAccesses)appContext.getBean("tableMaintenanceBean");
		TableMaintenanceMethods tblMaintenanceMethods = (TableMaintenanceMethods) appContext.getBean("tableMaintenanceBean");
		int MED_HIS_QUESTIONS_REF_ID = 2;
		int PHYSICAL_AILMENTS_REF_ID = 3;
		
		@RequestMapping("/")
		public String view(ModelMap model){
			ArrayList<Patient> list = new ArrayList<Patient>();
			List<Patient> object = dataAccesses.getAll();
	    	
			Iterator iterate = object.iterator();
	    	while(iterate.hasNext()){
	    		Patient iterlist = (Patient) iterate.next();	//Must change each object in the list as SystemUser
	    		list.add(iterlist);							//Then add to a list that would be passed in the jsp
	    	}
			model.addAttribute("patientList",list);
			return "home_page";
		}
		
		@RequestMapping("/add")
		public String addMethod(HttpServletRequest request, HttpServletResponse response, 
										 ModelMap model, Principal principal) throws IOException, ServletException{
			Patient patient = new Patient();
		
			if(validator(request, model)==true){
			String last_name = request.getParameter("last_name");
			String first_name = request.getParameter("first_name");
			String middle_name = request.getParameter("middle_name");
			String sex = request.getParameter("sex");
			String rel_status = request.getParameter("rel_status");
			String address = request.getParameter("address");
			String tel_num = request.getParameter("tel_num");
			String mobile_num = request.getParameter("mobile_num");
			String email = request.getParameter("email");
			String occupation = request.getParameter("occupation");
			String religion = request.getParameter("religion");
			String referred_by = request.getParameter("referred_by");
			String guardian = request.getParameter("guardian");
			String patient_num = "1";
			String nationality="Filipino";
			Boolean status=Boolean.valueOf("1");
			Date dob = new Date();
			Date last_visit_date= new Date();
			
			patient.setStatus(status);
			patient.setLast_visit_date(last_visit_date);
			patient.setNationality(nationality);
			patient.setPatient_num(patient_num);
			patient.setLast_name(last_name);
			patient.setFirst_name(first_name);
			patient.setMiddle_name(middle_name);
			patient.setBirthday(dob);
			patient.setSex(sex.charAt(0));
			patient.setRelationship_status(rel_status);
			patient.setAddress(address);
			patient.setTelephone_number(tel_num);
			patient.setMobile_number(mobile_num);
			patient.setEmail_address(email);
			patient.setOccupation(occupation);
			patient.setReligion(religion);
			patient.setReferred_by(referred_by);
			patient.setGuardian(guardian);
			
			dataAccesses.save(patient);
			
			//Adding the list for the view
			view(model);
			//Return to module main page
			}
	    	return "home_page";
		}
		
		@RequestMapping("/edit")
		public String editMethod(HttpServletRequest request, HttpServletResponse response, 
		ModelMap model, Principal principal) throws IOException, ServletException{
			
			Patient patient = new Patient();
			
			if(validator(request, model)==true){
			int editId = Integer.parseInt(request.getParameter("editId"));
			String last_name = request.getParameter("last_name");
			String first_name = request.getParameter("first_name");
			String middle_name = request.getParameter("middle_name");
			String sex = request.getParameter("sex");
			String rel_status = request.getParameter("rel_status");
			String address = request.getParameter("address");
			String tel_num = request.getParameter("tel_num");
			String mobile_num = request.getParameter("mobile_num");
			String email = request.getParameter("email");
			String occupation = request.getParameter("occupation");
			String religion = request.getParameter("religion");
			String referred_by = request.getParameter("referred_by");
			String guardian = request.getParameter("guardian");
			String patient_num = "1";
			String nationality="Filipino";
			Boolean status=Boolean.valueOf("1");
			Date dob = new Date();
			Date last_visit_date= new Date();
			
			patient.setStatus(status);
			patient.setLast_visit_date(last_visit_date);
			patient.setNationality(nationality);
			patient.setPatient_num(patient_num);
			patient.setLast_name(last_name);
			patient.setFirst_name(first_name);
			patient.setMiddle_name(middle_name);
			patient.setBirthday(dob);
			patient.setSex(sex.charAt(0));
			patient.setRelationship_status(rel_status);
			patient.setAddress(address);
			patient.setTelephone_number(tel_num);
			patient.setMobile_number(mobile_num);
			patient.setEmail_address(email);
			patient.setOccupation(occupation);
			patient.setReligion(religion);
			patient.setReferred_by(referred_by);
			patient.setGuardian(guardian);
			patient.setPatient_id(editId);
			
			dataAccesses.update(patient);
			}
			return "home_page";
		}
		
		@RequestMapping("/inactive")
		public String inactive(HttpServletRequest request, HttpServletResponse response, 
								ModelMap model, Principal principal) throws IOException, ServletException{
			
			int editId = Integer.parseInt(request.getParameter("editId"));
			Patient patient = (Patient)dataAccesses.findById(editId);
			patient.setStatus(Boolean.valueOf("0"));
			return "home_page";	
		}
		
		@RequestMapping("/add_record")
		public String addRecord(HttpServletRequest request, HttpServletResponse response, 
								ModelMap model, Principal principal) throws IOException, ServletException{
			
			//int patient_id = Integer.parseInt(request.getParameter("patient_id"));
			Patient patient = (Patient)dataAccesses.findById(1);
			
			List tempMedHisQuestionList = tblMaintenanceMethods.findAllByRefId(MED_HIS_QUESTIONS_REF_ID);
			List tempPhysicalAilmentList = tblMaintenanceMethods.findAllByRefId(PHYSICAL_AILMENTS_REF_ID);
			
			ArrayList<TableMaintenance> medHisQuestionList = new ArrayList<TableMaintenance>();
			List<TableMaintenance> physicalAilmentList = new ArrayList<TableMaintenance>();
			
			Iterator iter = tempMedHisQuestionList.iterator();
			while(iter.hasNext()){
				TableMaintenance medHis = (TableMaintenance) iter.next();
				System.out.println("Desc: MedHis - "+medHis.getTbl_maintenance_description());
				medHisQuestionList.add(medHis);
			}
			
			Iterator iter2 = tempPhysicalAilmentList.iterator();
			while(iter2.hasNext()){
				TableMaintenance physicalAilment = (TableMaintenance) iter2.next();
				System.out.println("Desc: PhysicalAilment - "+physicalAilment.getTbl_maintenance_description());
				medHisQuestionList.add(physicalAilment);
			}
			
			model.addAttribute("patient",patient);
			model.addAttribute("medHisQuestionList", medHisQuestionList);
			model.addAttribute("physicalAilmentList", physicalAilmentList);
			
			return "add_record";	
		}
		
		@RequestMapping("/add_record/done")
		public String addRecordDone(HttpServletRequest request, HttpServletResponse response, 
								ModelMap model, Principal principal) throws IOException, ServletException{
			
			//int patient_id = Integer.parseInt(request.getParameter("patient_id"));
			Patient patient = (Patient)dataAccesses.findById(1);
			
			AnxillariesController.addMethod(request, response, model, principal);
			ClinicalExaminationController.addMethod(request, response, model, principal);
			DentalHistoryController.addMethod(request, response, model, principal);
			//MedicalHistoryController.addMethod(request, response, model, principal);
			OcclusionController.addMethod(request, response, model, principal);
			OtherInformationController.addMethod(request, response, model, principal);
			TreatmentPlanController.addMethod(request, response, model, principal);
			model.addAttribute("patient",patient);
			
			
			return "view_patients_record";	
		}
		
		public Boolean validator(HttpServletRequest request,
				ModelMap model) throws IOException, ServletException{
					
			Boolean validateStatus = true;
			String error[] = new String[17];
			String last_name; //error[0]
			String first_name; //error[1]
			String middle_name; //error[2]
			String sex; //error[3]
			String rel_status; //error[4]
			String address; //error[5]
			String city; 
			String tel_num; //error[7]
			String mobile_num; //error[8]
			String email;
			String occupation;
			String religion;
			String referred_by;
			String guardian;
			String patient_num;
			String nationality;
			
			try{
			last_name = request.getParameter("last_name");
				if(last_name.equals("")){
					error[0]="Last name cannot be empty";
					validateStatus=false;
				}
			}catch(Exception e){
				error[0]="Last name cannot be empty";
				validateStatus=false;
			}
			
			try{
				first_name = request.getParameter("first_name");
					if(first_name.equals("")){
						error[1]="First name cannot be empty";
						validateStatus=false;
					}
			}catch(Exception e){
					error[1]="First name cannot be empty";
					validateStatus=false;
			}
			
			try{
				middle_name = request.getParameter("middle_name");
					if(middle_name.equals("")){
						error[2]="Middle name cannot be empty";
						validateStatus=false;
					}
			}catch(Exception e){				
					error[2]="Middle name cannot be empty";
					validateStatus=false;
			}
					
			try{
				sex = request.getParameter("sex");
					if(sex.equals("")){
						error[3]="Sex cannot be empty";
						validateStatus=false;
					}
			}catch(Exception e){				
					error[3]="Sex cannot be empty";
					validateStatus=false;
			}
			
			try{
				rel_status = request.getParameter("rel_status");
					if(rel_status.equals("")){
						error[4]="Relationship status cannot be empty";
						validateStatus=false;
					}
			}catch(Exception e){				
					error[4]="Relationship status cannot be empty";
					validateStatus=false;
			}
			
			try{
				address = request.getParameter("address");
					if(address.equals("")){
						error[5]="Address cannot be empty";
						validateStatus=false;
					}
			}catch(Exception e){				
					error[5]="Address cannot be empty";
					validateStatus=false;
			}
			
			
			try{
				tel_num = request.getParameter("tel_num");
					if(tel_num.equals("")){
						error[7]="Telephone Number cannot be empty";
						validateStatus=false;
					}
			}catch(Exception e){				
					error[7]="Telephone Number cannot be empty";
					validateStatus=false;
			}
		
			try{
				mobile_num = request.getParameter("mobile_num");
					if(mobile_num.equals("")){
						error[8]="Mobile Number cannot be empty";
						validateStatus=false;
					}
			}catch(Exception e){				
					error[8]="Mobile Number cannot be empty";
					validateStatus=false;
			}
			
			try{
				email = request.getParameter("email");
					if(email.equals("")){
						error[9]="Email Address cannot be empty";
						validateStatus=false;
					}
			}catch(Exception e){				
					error[9]="Email Address cannot be empty";
					validateStatus=false;
			}
			
			try{
				occupation = request.getParameter("occupation");
					if(occupation.equals("")){
						error[10]="Occupation cannot be empty";
						validateStatus=false;
					}
			}catch(Exception e){				
					error[10]="Occupation cannot be empty";
					validateStatus=false;
			}
			
			try{
				religion = request.getParameter("religion");
					if(religion.equals("")){
						error[11]="Religion cannot be empty";
						validateStatus=false;
					}
			}catch(Exception e){				
					error[11]="Religion cannot be empty";
					validateStatus=false;
			}
			
			try{
				referred_by = request.getParameter("referred_by");
					if(referred_by.equals("")){
						error[12]="Referred By cannot be empty";
						validateStatus=false;
					}
			}catch(Exception e){				
					error[12]="Referred By cannot be empty";
					validateStatus=false;
			}
			
			try{
				guardian = request.getParameter("guardian");
					if(guardian.equals("")){
						error[12]="Guardian cannot be empty";
						validateStatus=false;
					}
			}catch(Exception e){				
					error[12]="Guardian cannot be empty";
					validateStatus=false;
			}
			
			try{
				nationality = request.getParameter("nationality");
					if(nationality.equals("")){
						error[13]="Nationality cannot be empty";
						validateStatus=false;
					}
			}catch(Exception e){				
					error[13]="Nationality cannot be empty";
					validateStatus=false;
			}
		
			model.addAttribute(error);
			return validateStatus;
			}
		
		  @RequestMapping(value = "/patientGenerateReport") 
		    public void getXLS(HttpServletResponse response,HttpServletRequest request, Model model) throws ClassNotFoundException { 
		    // BusinessUnit_JService downloadService = new BusinessUnit_JService(); 
		     // Delegate to downloadService. Make sure to pass an instance of HttpServletResponse  
		  //   downloadService.downloadXLS(response); 
		 } 
		  
}
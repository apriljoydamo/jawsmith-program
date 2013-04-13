package com.jawsmith.controllers;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jawsmith.common.GetDateAndTime;
import com.jawsmith.interfaces.AnxillariesMethods;
import com.jawsmith.interfaces.ClinicalExaminationMethods;
import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.DentalHistoryMethods;
import com.jawsmith.interfaces.PatientMethods;
import com.jawsmith.interfaces.TableMaintenanceMethods;
import com.jawsmith.interfaces.TreatmentRecordMethods;
import com.jawsmith.model.Anxillaries;
import com.jawsmith.model.ClinicalExamination;
import com.jawsmith.model.DentalHistory;
import com.jawsmith.model.MedicalHistory;
import com.jawsmith.model.Occlusion;
import com.jawsmith.model.OtherInformation;
import com.jawsmith.model.Patient;
import com.jawsmith.model.ReportTable;
import com.jawsmith.model.TableMaintenance;
import com.jawsmith.model.TreatmentPlan;
import com.jawsmith.model.TreatmentRecord;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


@Controller
@RequestMapping("patient")
public class PatientController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	DataAccesses dataAccesses = (DataAccesses)appContext.getBean("patientsBean");
	DataAccesses reportTblDataAccesses = (DataAccesses)appContext.getBean("reportTblBean");
	PatientMethods patientMethods = (PatientMethods)appContext.getBean("patientsBean");
	TreatmentRecordMethods treatmentRecordMethods = (TreatmentRecordMethods)appContext.getBean("treatmentRecordBean");
	
	@RequestMapping("/list")
	public String viewList(HttpServletRequest request, ModelMap model){
		
		try{
			//destroys the patient attribute in session
			request.getSession().removeAttribute("patient");
		}catch(Exception e){
			System.out.println("ERROR IN DESTROYING SESSION");
			logger.error("ERROR IN DESTROYING SESSION");
		}
		
		pagination(request, model,null);
		return "home_page";
	}
	
	@RequestMapping("/search")
	public String searchedList(HttpServletRequest request, ModelMap model){
		
		String searchedValue = (String)request.getParameter("searchedValue");
		try{
			//destroys the patient attribute in session
			request.getSession().removeAttribute("patient");
		}catch(Exception e){
			System.out.println("ERROR IN DESTROYING SESSION");
			logger.error("ERROR IN DESTROYING SESSION");
		}
		pagination(request, model,searchedValue);
		return "home_page";
	}
	
	@RequestMapping("/add")
	public String addMethod(HttpServletRequest request, HttpServletResponse response, 
									 ModelMap model, Principal principal) throws IOException, ServletException{
		
		Patient patient = new Patient();
	
		//if(validator(request, model)==true){
		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String middle_name = request.getParameter("middle_name");
		String sex = request.getParameter("add_patient_sex");
		String rel_status = request.getParameter("rel_status");
		String address = request.getParameter("address");
		String tel_num = request.getParameter("tel_num");
		String mobile_num = request.getParameter("mobile_num");
		String email = request.getParameter("email");
		String occupation = request.getParameter("occupation");
		String religion = request.getParameter("religion");
		String referred_by = request.getParameter("referred_by");
		String guardian = request.getParameter("guardian");
		String patient_num = request.getParameter("patient_num");
		String nationality = request.getParameter("nationality");
		Boolean status = true;
		Date last_visit_date = new Date();
		Date dob = null;
		try {
			dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
		} catch (ParseException e) {
			System.out.println("ERROR WITH PARSING DATE OF BIRTH");
		}
		
		patient.setStatus(status);
		patient.setLast_visit_date(last_visit_date);
		patient.setNationality(nationality);
		patient.setPatient_num(patient_num);
		patient.setLast_name(last_name);
		patient.setFirst_name(first_name);
		patient.setMiddle_name(middle_name);
		patient.setBirthday(dob);
		patient.setSex(""+sex.charAt(0));
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
		
    	return "redirect:/patient/list";
	}
	
	@RequestMapping("/edit")
	public String editMethod(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model, Principal principal) throws IOException, ServletException{
		
		Patient patient = (Patient) request.getSession().getAttribute("patient");
		
		//if(validator(request, model)==true){
		//int editId = Integer.parseInt(request.getParameter("editId"));
		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String middle_name = request.getParameter("middle_name");
		String sex = request.getParameter("add_patient_sex");
		String rel_status = request.getParameter("rel_status");
		String address = request.getParameter("address");
		String tel_num = request.getParameter("tel_num");
		String mobile_num = request.getParameter("mobile_num");
		String email = request.getParameter("email");
		String occupation = request.getParameter("occupation");
		String religion = request.getParameter("religion");
		String referred_by = request.getParameter("referred_by");
		String guardian = request.getParameter("guardian");
		String patient_num = request.getParameter("patient_num");
		String nationality = request.getParameter("nationality");
		Boolean status = Boolean.parseBoolean(request.getParameter("status"));
		Date last_visit_date = new Date();
		Date dob = null;
		try {
			dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
			System.out.println("DATE OF BIRTH: "+dob);
		} catch (ParseException e) {
			System.out.println("ERROR WITH PARSING DATE OF BIRTH");
		}
		
		patient.setStatus(status);
		patient.setLast_visit_date(last_visit_date);
		patient.setNationality(nationality);
		patient.setPatient_num(patient_num);
		patient.setLast_name(last_name);
		patient.setFirst_name(first_name);
		patient.setMiddle_name(middle_name);
		patient.setBirthday(dob);
		patient.setSex(""+sex.charAt(0));
		patient.setRelationship_status(rel_status);
		patient.setAddress(address);
		patient.setTelephone_number(tel_num);
		patient.setMobile_number(mobile_num);
		patient.setEmail_address(email);
		patient.setOccupation(occupation);
		patient.setReligion(religion);
		patient.setReferred_by(referred_by);
		patient.setGuardian(guardian);
		//patient.setPatient_id(editId);
		
		dataAccesses.update(patient);
		//}
		
    	return "redirect:/patient/view_patient/details";
	}
	
	@RequestMapping("/inactive")
	public String inactive(HttpServletRequest request, HttpServletResponse response, 
							ModelMap model, Principal principal) throws IOException, ServletException{
		
		int editId = Integer.parseInt(request.getParameter("editId"));
		Patient patient = (Patient)dataAccesses.findById(editId);
		patient.setStatus(Boolean.valueOf("0"));

    	return "redirect:/patient/list";
	}
	
	@RequestMapping("/add_record")
	public String addRecordDone(HttpServletRequest request, HttpServletResponse response, 
							ModelMap model, Principal principal) throws IOException, ServletException{
		
		AnxillariesController.addMethod(request, response, model, principal);
		ClinicalExaminationController.addMethod(request, response, model, principal);
		DentalHistoryController.addMethod(request, response, model, principal);
		MedicalHistoryController.addMethod(request, response, model, principal);
		OcclusionController.addMethod(request, response, model, principal);
		OtherInformationController.addMethod(request, response, model, principal);
		//TreatmentPlanController.addMethod(request, response, model, principal);
		
		//update Patient's last visit date
		Date last_visit_date = new Date();
		Patient patient = (Patient) request.getSession().getAttribute("patient");
		patient.setLast_visit_date(last_visit_date);
		dataAccesses.update(patient);
		
		return "redirect:/patient/view_patient/details";
	}
	
	@RequestMapping("/edit_record")
	public String editRecordDone(HttpServletRequest request, HttpServletResponse response, 
							ModelMap model, Principal principal) throws IOException, ServletException{
		
		AnxillariesController.editMethod(request, response, model, principal);
		ClinicalExaminationController.editMethod(request, response, model, principal);
		DentalHistoryController.editMethod(request, response, model, principal);
		MedicalHistoryController.editMethod(request, response, model, principal);
		OcclusionController.editMethod(request, response, model, principal);
		OtherInformationController.editMethod(request, response, model, principal);
		//TreatmentPlanController.editMethod(request, response, model, principal);
		
		//update Patient's last visit date
		Date last_visit_date = new Date();
		Patient patient = (Patient) request.getSession().getAttribute("patient");
		patient.setLast_visit_date(last_visit_date);
		dataAccesses.update(patient);
		
		return "redirect:/patient/view_patient/details";
	}
	
	@RequestMapping("/view_patient")
	public String patientRecords(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		Patient patient = (Patient)dataAccesses.findById(patient_id);
		//puts the chosen patient in session
		request.getSession().setAttribute("patient", patient);		

		boolean success = (new File("C:\\JawsmithProgram\\")).mkdirs();
	    if(!success){
	    	System.out.println("Directory had been created. No need to create a new one.");
	    }
         
		return "redirect:/patient/view_patient/details";
	}
	
	@RequestMapping("/view_patient/details")
	public String patientDetails(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		
		Patient patient = (Patient) request.getSession().getAttribute("patient");		
		int patientId = patient.getPatient_id();
		Date lastVisitDate = patient.getLast_visit_date();
		Boolean isNewUser = false;
		System.out.println("patientID: "+ patientId);
		System.out.println("LastVisitDate: "+lastVisitDate);
		
		List<MedicalHistory> latestMedHisList = null;
		DentalHistory dentalhis = null;
		ClinicalExamination clinical = null;
		Anxillaries anxillaries = null;
		Occlusion occlusion = null;
		OtherInformation other = null;
		List<TreatmentPlan> treatmentplanList = null;
		
		//ALL THE LATEST MEDICAL RECORDS TO BE SHOWN HERE
		try{
			latestMedHisList = (List<MedicalHistory>) MedicalHistoryController.medicalHistoryMethods.findByPatientId(patientId);
			dentalhis = (DentalHistory) DentalHistoryController.dentalHistoryMethods.findByPatientId(patientId);
			clinical = (ClinicalExamination) ClinicalExaminationController.clinicalExaminationMethods.findByPatientId(patientId);
			anxillaries = (Anxillaries) AnxillariesController.anxillariesMethods.findByPatientId(patientId);
			occlusion = (Occlusion) OcclusionController.occlusionMethods.findByPatientId(patientId);
			other = (OtherInformation) OtherInformationController.otherInformationMethods.findByPatientId(patientId);
		}catch(Exception e){
			System.out.println("ERROR IN RETRIEVING LAST VISIT DATES INFOS. MIGHT BE A NEW USER");
			isNewUser = true;
		}
		
		try{
			treatmentplanList = (List<TreatmentPlan>) TreatmentPlanController.treatmentPlanMethods.findByPatientId(patientId);			
		}catch(Exception e){
			System.out.println("ERROR IN RETRIEVING TREATMENT PLAN. MIGHT BE A NEW USER");
		}
		
		//FOR JASPER REPORTS
		try{
			ReportTable report;
		
			try{
				report = (ReportTable) reportTblDataAccesses.getAll().get(0);
			}catch(Exception e){
				report = new ReportTable();
			}
			//patient
			report.setPatientId(""+patient.getPatient_id());
			report.setPatientNo(patient.getPatient_num());
			report.setFullName(patient.getLast_name()+", "+patient.getFirst_name()+" "+patient.getMiddle_name());
			report.setBirthday(""+patient.getBirthday());
			report.setGender(patient.getSex());
			report.setCivilStatus(patient.getRelationship_status());
			report.setAddress(patient.getAddress());
			report.setContactNo(patient.getMobile_number()+" / "+patient.getTelephone_number());
			report.setEmail(patient.getEmail_address());
			report.setNationality(patient.getNationality());
			report.setReligion(patient.getReligion());
			report.setOccupation(patient.getOccupation());
			report.setReferredBy(patient.getReferred_by());
			report.setGuardian(patient.getGuardian());
			report.setLastVisitDate(""+patient.getLast_visit_date());
			report.setStatus(""+patient.getStatus());
			//anxillaries
			report.setBleedingTime(anxillaries.getBleeding_time());
			report.setBloodPressure(anxillaries.getBlood_pressure());
			report.setRadiographicInterpretation(anxillaries.getRadiographic_interpretation());
			report.setClottingTime(anxillaries.getClotting_time());
			report.setBloodSugar(anxillaries.getBlood_sugar());
			//clinical
			report.setGingivalColor(clinical.getGingival_color());
			report.setConsistencyOfGingival(clinical.getConsistency_of_gingival());
			report.setTounge(clinical.getTounge());
			report.setOralHygiene(clinical.getOral_hygiene());
			report.setLymphNodes(clinical.getLymph_nodes());
			//dentalhis
			report.setOrthodonticTreatment(""+dentalhis.getOrthodontic_treatment());
			report.setPulpTherapy(""+dentalhis.getPulp_therapy());
			report.setTemporoMandibularTherapy(""+dentalhis.getTemporo_mandibular());
			report.setPeriodontalTherapy(""+dentalhis.getPeriodontal_therapy());
			report.setDentalSurgery(""+dentalhis.getDental_surgery());
			report.setExtraction(""+dentalhis.getExtraction());
			//occlusion
			report.setClassI(occlusion.getClass_1());
			report.setClassII(occlusion.getClass_2());
			report.setClassIII(occlusion.getClass_3());
			//other info
			report.setChiefComplaint(other.getChief_complaint());
			report.setDiagnosis(other.getDiagnosis());
			//medhis
			int x = 0;
			Iterator iter = latestMedHisList.iterator();
			while(iter.hasNext()){
				MedicalHistory medhis = (MedicalHistory) iter.next();
				if(x==0) report.setQ1(medhis.getAnswer());
				if(x==1){
					report.setQ2(medhis.getAnswer());
					model.addAttribute("answer2", medhis.getAnswer());
					System.out.println("answer2: "+medhis.getAnswer());
				}
				if(x==2) report.setQ3(medhis.getAnswer());
				if(x==3) report.setQ4(medhis.getAnswer());
				if(x==4) report.setQ5(medhis.getAnswer());
				if(x==5) report.setQ6(medhis.getAnswer());
				if(x==6) report.setQ7(medhis.getAnswer());
				if(x==7) report.setQ8(medhis.getAnswer());
				x++;
			}
			
			try{
				reportTblDataAccesses.update(report);
				System.out.println("UPDATE");
			}catch(Exception e){
				reportTblDataAccesses.save(report);
				System.out.println("SAVE");
			}
		}catch(Exception e){
			System.out.println("ERROR IN PUTTING DATA ON REPORT TABLE");
		}
		
		
		
		model.addAttribute("latestMedHisList", latestMedHisList);
		model.addAttribute("dentalhis", dentalhis);
		model.addAttribute("clinical", clinical);
		model.addAttribute("anxillaries", anxillaries);
		model.addAttribute("occlusion", occlusion);
		model.addAttribute("other", other);
		model.addAttribute("treatmentplanList", treatmentplanList);
		model.addAttribute("isNewUser", isNewUser);
		System.out.print("NEW USER:"+isNewUser);
		
		return "view_patients_record";
	}
	
	@RequestMapping(value = "/generate_pdf_file") 
    public String getPDF(HttpServletResponse response,HttpServletRequest request, 
                                                Model model) throws ClassNotFoundException, FileNotFoundException, JRException { 
		getPatientPDF(response, request, model);
		treatmentPlanPDF(response, request, model);
		treatmentRecordPDF(response, request, model);
		
		return "redirect:/home";
	}
	
	
	//@RequestMapping(value = "/generate_patient_info") 
    public void getPatientPDF(HttpServletResponse response,HttpServletRequest request, 
                                                Model model) throws ClassNotFoundException, FileNotFoundException, JRException { 
        //LAYOUTS
        InputStream inputStreamPatientReport = Thread.currentThread().getContextClassLoader().getResourceAsStream("reports/patient_report2.jrxml");
         
        //VALUES TO BE PRINTED HERE
        Patient patient = (Patient) request.getSession().getAttribute("patient");
        ReportTable reportTbl = (ReportTable) reportTblDataAccesses.getAll().get(0);
        ArrayList<ReportTable> dataBeanList = new ArrayList<ReportTable>();
        dataBeanList.add(reportTbl);
        
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
           
        //COMPILE JRXML FILES
        JasperDesign jasperMasterDesign = JRXmlLoader.load(inputStreamPatientReport);
        
        //COMPILE REPORT
        JasperReport jasperMasterReport = JasperCompileManager.compileReport(jasperMasterDesign);
       
        //FILL REPORT
        Map<String, Object> parameters = new HashMap<String, Object>();
       
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperMasterReport, parameters, beanColDataSource);
        
        //EXPORT REPORT
        Date date = new Date();
		String pathFile = "C:/JawsmithProgram/";
		String sDate = new SimpleDateFormat("yyyyMMMdd").format(date);
        String nameOfPatient = patient.getLast_name()+""+patient.getFirst_name();
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathFile+sDate+"_"+nameOfPatient+"_PatientInfo.pdf"); 
        
        //return "redirect:/home";
  	} 
	
	//@RequestMapping(value = "/generate_treatment_plan") 
    public void treatmentPlanPDF(HttpServletResponse response,HttpServletRequest request, 
                                                Model model) throws ClassNotFoundException, FileNotFoundException, JRException { 
                
        //LAYOUTS
        InputStream inputStreamPatientReport = Thread.currentThread().getContextClassLoader().getResourceAsStream("reports/patient_report_treatment_plan.jrxml");
         
        //VALUES TO BE PRINTED HERE
        Patient patient = (Patient) request.getSession().getAttribute("patient");
        ArrayList<TreatmentPlan> dataBeanList = (ArrayList<TreatmentPlan>) TreatmentPlanController.treatmentPlanMethods.findByPatientId(patient.getPatient_id());
        
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
           
        //COMPILE JRXML FILES
        JasperDesign jasperMasterDesign = JRXmlLoader.load(inputStreamPatientReport);
        
        //COMPILE REPORT
        JasperReport jasperMasterReport = JasperCompileManager.compileReport(jasperMasterDesign);
       
        //FILL REPORT
        Map<String, Object> parameters = new HashMap<String, Object>();
       
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperMasterReport, parameters, beanColDataSource);
        
        //EXPORT REPORT
        Date date = new Date();
		String pathFile = "C:/JawsmithProgram/";
		String sDate = new SimpleDateFormat("yyyyMMMdd").format(date);
        String nameOfPatient = patient.getLast_name()+""+patient.getFirst_name();
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathFile+sDate+"_"+nameOfPatient+"_TreatmentPlan.pdf"); 
               
        //return "redirect:/home";
  
	} 
	
	//@RequestMapping(value = "/generate_treatment_record") 
    public void treatmentRecordPDF(HttpServletResponse response,HttpServletRequest request, 
                                                Model model) throws ClassNotFoundException, FileNotFoundException, JRException { 
           	//LAYOUTS
            InputStream inputStreamPatientReport = Thread.currentThread().getContextClassLoader().getResourceAsStream("reports/patient_report_treatment_record.jrxml");
             
            //VALUES TO BE PRINTED HERE
            Patient patient = (Patient) request.getSession().getAttribute("patient");
            ArrayList<TreatmentRecord> dataBeanList = (ArrayList<TreatmentRecord>) treatmentRecordMethods.findByPatientId(patient.getPatient_id());
            
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
               
            //COMPILE JRXML FILES
            JasperDesign jasperMasterDesign = JRXmlLoader.load(inputStreamPatientReport);
            
            //COMPILE REPORT
            JasperReport jasperMasterReport = JasperCompileManager.compileReport(jasperMasterDesign);
           
            //FILL REPORT
            Map<String, Object> parameters = new HashMap<String, Object>();
           
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperMasterReport, parameters, beanColDataSource);
            
            //EXPORT REPORT
            Date date = new Date();
    		String pathFile = "C:/JawsmithProgram/";
    		String sDate = new SimpleDateFormat("yyyyMMMdd").format(date);
            String nameOfPatient = patient.getLast_name()+""+patient.getFirst_name();
            JasperExportManager.exportReportToPdfFile(jasperPrint, pathFile+sDate+"_"+nameOfPatient+"_TreatmentRecord.pdf"); 
            
            //return "redirect:/home";
  
	}
	        
	
	public void pagination(HttpServletRequest request, ModelMap model,String searchedValue){ 
		  int pageNum = 1;
		  int offset = 0;
		  int recordsPerPage = 10;
		  int noOfRecords = patientMethods.getNumOfRecords();
		  int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		  model.addAttribute("noOfPages", noOfPages);
		

		  
		  try{
			  System.out.println("getting page property..");
			  pageNum= Integer.parseInt(request.getParameter("page"));
			
			System.out.println("pagenum is : "+pageNum);
			offset=(offset+1)*((pageNum-1)*recordsPerPage);
			System.out.println("offset is : "+offset);
		  }catch(Exception E){
			  System.out.println("failed to get page property.."); 
			  model.addAttribute("pageNum", pageNum);
			  model.addAttribute("offset", offset);
			  
		  }
		        if(request.getParameter("page") != null)
		        	model.addAttribute("pageNum", pageNum);
		 
		        ArrayList<Patient> patientList = new ArrayList<Patient>();
		       try{
		    	   if(searchedValue.equals(null)||searchedValue.equals(""));
		    	   List<Patient> object =(List) patientMethods.paginatedSearch(offset, recordsPerPage, searchedValue) ;
		    	   Iterator iterate = object.iterator();
		    	   while(iterate.hasNext()){
			    		Patient iterlist = (Patient) iterate.next();	//Must change each object in the list as SystemUser
			    		patientList.add(iterlist);							//Then add to a list that would be passed in the jsp
			    	}
		       }catch(Exception E){
		        List<Patient> object =(List)patientMethods.paginatedView(offset, recordsPerPage);
		        Iterator iterate = object.iterator();
		    	while(iterate.hasNext()){
		    		Patient iterlist = (Patient) iterate.next();	//Must change each object in the list as SystemUser
		    		patientList.add(iterlist);							//Then add to a list that would be passed in the jsp
		    	}
		       }
		    	
		        model.addAttribute("patientList", patientList);	    
	  }
	
	
	/**
	 * 
	 * public Boolean validator(HttpServletRequest request,
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
		}**/
}

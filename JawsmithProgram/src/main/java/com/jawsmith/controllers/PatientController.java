package com.jawsmith.controllers;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
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

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.PatientMethods;
import com.jawsmith.interfaces.TableMaintenanceMethods;
import com.jawsmith.model.Patient;
import com.jawsmith.model.TableMaintenance;

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
	PatientMethods patientMethods = (PatientMethods)appContext.getBean("patientsBean");
	
	@RequestMapping("/list")
	public String viewList(HttpServletRequest request, ModelMap model){
		
		try{
			//destroys the patient attribute in session
			request.getSession().removeAttribute("patient");
		}catch(Exception e){
			System.out.println("ERROR IN DESTROYING SESSION");
			logger.error("ERROR IN DESTROYING SESSION");
		}
		
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
		
    	return "redirect:/patient/list";
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
		
    	return "redirect:/patient/list";
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
		
		//AnxillariesController.addMethod(request, response, model, principal);
		//ClinicalExaminationController.addMethod(request, response, model, principal);
		//DentalHistoryController.addMethod(request, response, model, principal);
		MedicalHistoryController.addMethod(request, response, model, principal);
		//OcclusionController.addMethod(request, response, model, principal);
		//OtherInformationController.addMethod(request, response, model, principal);
		//TreatmentPlanController.addMethod(request, response, model, principal);
		
		return "redirect:/patient/view_patient/details";
	}
	
	@RequestMapping("/view_patient")
	public String patientRecords(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		Patient patient = (Patient)dataAccesses.findById(patient_id);
		//puts the chosen patient in session
		request.getSession().setAttribute("patient", patient);		
		
		return "redirect:/patient/view_patient/details";
	}
	
	@RequestMapping("/view_patient/details")
	public String patientDetails(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		
		Patient patient = (Patient) request.getSession().getAttribute("patient");		
		
		//ALL THE LATEST MEDICAL RECORDS TO BE SHOWN HERE

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
	
	  @RequestMapping(value = "/generate_pdf_file") 
	    public String getPDF(HttpServletResponse response,HttpServletRequest request, 
	    						Model model) throws ClassNotFoundException, FileNotFoundException, JRException { 
		 	
		  	//LAYOUTS
		  	InputStream inputStreamPatientReport = new FileInputStream("reports/patient_report.jrxml");
			/*InputStream  inputStreamReportAnxillaries = new FileInputStream("reports/patient_report_anxillaries.jrxml");
		  	InputStream inputStreamReportClinical = new FileInputStream("reports/patient_report_clinical.jrxml");
			InputStream  inputStreamReportDentalHis = new FileInputStream("reports/patient_report_dentalhis.jrxml");
		  	InputStream inputStreamReportMedHis = new FileInputStream("reports/patient_report_medhis.jrxml");
			InputStream  inputStreamReportOcclusion = new FileInputStream("reports/patient_report_occlusion.jrxml");
		  	InputStream inputStreamReportOtherInfo = new FileInputStream("reports/patient_report_other_info.jrxml");
			InputStream  inputStreamReportTreatmentPlan = new FileInputStream("reports/patient_report_treatment_plan.jrxml");
			InputStream  inputStreamReportTreatmentRecord = new FileInputStream("reports/patient_report_treatment_record.jrxml");
			*/
		  	
			//VALUES TO BE PRINTED HERE
		  	//DataBeanMaker dataBeanMaker = new DataBeanMaker();
			//ArrayList<DataBean> dataBeanList = dataBeanMaker.getDataBeanList();
			Patient patient = (Patient) request.getSession().getAttribute("patient");
			ArrayList<Patient> dataBeanList = new ArrayList<Patient>();
			dataBeanList.add(patient);
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
			
			//COMPILE JRXML FILES
			/*JasperDesign jasperSubDesign1 = JRXmlLoader.load(inputStreamReportAnxillaries);
			JasperDesign jasperSubDesign2 = JRXmlLoader.load(inputStreamReportClinical);
			JasperDesign jasperSubDesign3 = JRXmlLoader.load(inputStreamReportDentalHis);
			JasperDesign jasperSubDesign4 = JRXmlLoader.load(inputStreamReportMedHis);
			JasperDesign jasperSubDesign5 = JRXmlLoader.load(inputStreamReportOcclusion);
			JasperDesign jasperSubDesign6 = JRXmlLoader.load(inputStreamReportOtherInfo);
			JasperDesign jasperSubDesign7 = JRXmlLoader.load(inputStreamReportTreatmentPlan);
			JasperDesign jasperSubDesign8 = JRXmlLoader.load(inputStreamReportTreatmentRecord);
			*/JasperDesign jasperMasterDesign = JRXmlLoader.load(inputStreamPatientReport);
			
	        
	        //COMPILE REPORT
			/*JasperReport jasperSubReport1 = JasperCompileManager.compileReport(jasperSubDesign1);
			JasperReport jasperSubReport2 = JasperCompileManager.compileReport(jasperSubDesign2);
			JasperReport jasperSubReport3 = JasperCompileManager.compileReport(jasperSubDesign3);
			JasperReport jasperSubReport4 = JasperCompileManager.compileReport(jasperSubDesign4);
			JasperReport jasperSubReport5 = JasperCompileManager.compileReport(jasperSubDesign5);
			JasperReport jasperSubReport6 = JasperCompileManager.compileReport(jasperSubDesign6);
			JasperReport jasperSubReport7 = JasperCompileManager.compileReport(jasperSubDesign7);
			JasperReport jasperSubReport8 = JasperCompileManager.compileReport(jasperSubDesign8);
			*/JasperReport jasperMasterReport = JasperCompileManager.compileReport(jasperMasterDesign);
	        
			//FILL REPORT
			Map<String, Object> parameters = new HashMap<String, Object>();
			/*parameters.put("subreportParameterAnxillaries", jasperSubReport1);
			parameters.put("subreportParameterClinical", jasperSubReport2);
			parameters.put("subreportParameterDentalHis", jasperSubReport3);
			parameters.put("subreportParameterMedHis", jasperSubReport4);
			parameters.put("subreportParameterOcclusion", jasperSubReport5);
			parameters.put("subreportParameterOtherInfo", jasperSubReport6);
			parameters.put("subreportParameterTreatmentPlan", jasperSubReport7);
			parameters.put("subreportParameterTreatmentRecord", jasperSubReport8);
			*/
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperMasterReport, parameters, beanColDataSource);

	        //EXPORT REPORT
	        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Users/April Joy Damo/Documents/JasperReports/reports/test_jasper.pdf"); 
	
	        return "redirect:/home";
	  
	  } 
	  
	  public void pagination(HttpServletResponse response,HttpServletRequest request, ModelMap model) throws ClassNotFoundException { 
		  int pageNum = 1;
		  int offset = 0;
		  int recordsPerPage = 20;
		  try{
			pageNum=(Integer)request.getAttribute("pageNum");
			offset=(Integer)request.getAttribute("offset");
			offset=offset*pageNum;
		  }catch(Exception E){
			  model.addAttribute("pageNum", pageNum);
			  model.addAttribute("offset", offset);
			  
		  }
		        if(request.getParameter("page") != null)
		            pageNum = Integer.parseInt(request.getParameter("page"));
		        Patient dao = new Patient();
		        List<Patient> patientlist =(List)patientMethods.paginatedView(offset, recordsPerPage);
		        model.addAttribute("patientlist", patientlist);	    
	  }
			 
}

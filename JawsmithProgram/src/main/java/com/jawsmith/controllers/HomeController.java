package com.jawsmith.controllers;

import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

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
import org.springframework.web.bind.annotation.RequestMethod;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.PatientMethods;
import com.jawsmith.interfaces.SystemUserMethods;
import com.jawsmith.interfaces.TableMaintenanceMethods;
import com.jawsmith.model.Patient;
import com.jawsmith.model.SystemUser;
import com.jawsmith.model.TableMaintenance;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	SystemUserMethods sysUserMethods = (SystemUserMethods)appContext.getBean("systemUserBean");
	DataAccesses dataAccesses = (DataAccesses)appContext.getBean("patientsBean");
	TableMaintenanceMethods tblMaintenanceMethods = (TableMaintenanceMethods) appContext.getBean("tableMaintenanceBean");
	PatientMethods patientMethods = (PatientMethods)appContext.getBean("patientsBean");
	DataAccesses tblMaintenanceDataAccesses = (DataAccesses)appContext.getBean("tableMaintenanceBean");
	DataAccesses sysUserDataAccesses = (DataAccesses)appContext.getBean("systemUserBean");
	int CODE_TBL_REF = 1;
	int MED_HIS_QUESTIONS_REF_ID = 2;
	int PHYSICAL_AILMENTS_REF_ID = 3;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		return "redirect:/loginPage";
	}
	
	@RequestMapping("/loginPage")
	public String systemUsersPage2(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		return "login_page";
	}
	
	@RequestMapping("/loginSuccess")
	public String login(Locale locale, HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		SystemUser user = (SystemUser) sysUserMethods.findByName(principal.getName());		
		model.addAttribute("serverTime", formattedDate );
		//User in session
		request.getSession().setAttribute("user", user );		
		
		//ADDS ALL RECORDS(in the form of attributes containing lists) FROM TABLE MAINTENANCE TO THE SESSION 
		//(These attributes would float in the application context as long as the app is not closed
		List tempMedHisQuestionList = tblMaintenanceMethods.findAllByRefId(MED_HIS_QUESTIONS_REF_ID);
		List tempPhysicalAilmentList = tblMaintenanceMethods.findAllByRefId(PHYSICAL_AILMENTS_REF_ID);
		
		ArrayList<TableMaintenance> medHisQuestionList = new ArrayList<TableMaintenance>();
		ArrayList<TableMaintenance> physicalAilmentList = new ArrayList<TableMaintenance>();
	
		Iterator<TableMaintenance> iter = tempMedHisQuestionList.iterator();
		while(iter.hasNext()){
			TableMaintenance medHis = (TableMaintenance) iter.next();
			System.out.println("Desc: MedHis - "+medHis.getTbl_maintenance_description());
			medHisQuestionList.add(medHis);
		}
		
		Iterator<TableMaintenance> iter2 = tempPhysicalAilmentList.iterator();
		while(iter2.hasNext()){
			TableMaintenance physicalAilment = (TableMaintenance) iter2.next();
			System.out.println("Desc: PhysicalAilment - "+physicalAilment.getTbl_maintenance_description());
			physicalAilmentList.add(physicalAilment);
		}
		
		request.getSession().setAttribute("medHisQuestionList", medHisQuestionList);
		request.getSession().setAttribute("physicalAilmentList", physicalAilmentList);
		
		return "redirect:/home";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		return "login_page";
	}
	
	@RequestMapping("/denied")
	public String Denied(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		System.out.println("User is denied of access");
		return "login_page";
	}
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		return "home_page";
	}
	
	@RequestMapping("/admin")
	public String adminTools(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		
		List<SystemUser> sysUsersList = sysUserDataAccesses.getAll();
		model.addAttribute("sysUsersList", sysUsersList);
	
		List<TableMaintenance> tblMaintenanceList = tblMaintenanceDataAccesses.getAll();
		model.addAttribute("tblMaintenanceList", tblMaintenanceList);
		
		List refIdList = tblMaintenanceMethods.findAllByRefId(CODE_TBL_REF);
		model.addAttribute("refIdList", refIdList);
		
		return "admin_page";
	}
	
	@RequestMapping("/home")
	public String home(Locale locale, HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		//Fills patient table in jsp
		
		/*ArrayList<Patient> list = new ArrayList<Patient>();
		List<Patient> object = dataAccesses.getAll();
		Iterator<Patient> iterate = object.iterator();
    	while(iterate.hasNext()){
    		Patient iterlist = (Patient) iterate.next();	
    		list.add(iterlist);						
    	}
		model.addAttribute("patientList",list);
		*/
		
		
		return "redirect:/patient/list";
	}
	
	@RequestMapping("/general_error")
	public String errorPage(HttpServletRequest request, HttpServletResponse response, 
			  ModelMap model){
		return "error_page";
		
	}
	
	
}

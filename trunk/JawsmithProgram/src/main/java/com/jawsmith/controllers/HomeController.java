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
import com.jawsmith.interfaces.SystemUserMethods;
import com.jawsmith.model.Patient;
import com.jawsmith.model.SystemUser;

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
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("hello", "HELLO DEVELOPER" );
		
		return "home";
	}
	
	@RequestMapping("/loginPage")
	public String systemUsersPage2(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		return "login_page";
	}
	
	@RequestMapping("/table_maintenance_page")
	public String tableMaintenancePage(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		return "table_maintenance_page";
	}
	
	@RequestMapping("/view_patients_record")
	public String PatientRecords(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		return "table_maintenance_page";
	}
	
	@RequestMapping("/add_patientPage")
	public String add_patientPage(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		return "add_patient";
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
		
		//Fills patient table in jsp
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
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		return "home_page";
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
	
	  @RequestMapping(value = "/homeGenerateReport") 
	    public void getXLS(HttpServletResponse response,HttpServletRequest request, Model model) throws ClassNotFoundException { 
	  //   SystemUser_JService downloadService = new SystemUser_JService(); 
	     // Delegate to downloadService. Make sure to pass an instance of HttpServletResponse  
	  //   downloadService.downloadXLS(response); 
	 } 
	  
}

package com.jawsmith.controllers;


import java.io.IOException;
import java.security.Principal;

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
import com.jawsmith.model.SystemUser;



 
@Controller
@RequestMapping("/SystemUsers")
public class SystemUserController {
	ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");

	DataAccesses sysUserDataAccesses = (DataAccesses)appContext.getBean("systemUserBean");
	
	/**
	 * Redirecting to /systemUsersPage
	 **/
	@RequestMapping("/")
	public String systemUsersPage(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		
		//Filling out systemUserList 
		//view(model);
		
		//Filling out the header.jsp
    	return "systemUsersPage";
	}
	
	/**
	 * This is from /systemUsersPage Add System Users button
	 * To redirect in ae_systemUsersPages
	 **/
	@RequestMapping("/add")
	public String Add(HttpServletRequest request, HttpServletResponse response, 
									 ModelMap model, Principal principal) throws IOException, ServletException{
		//Filling out the header.jsp
    	return "ae_systemUsers";
	}
	
	/**
	 * changes in url
	 * This is from /systemUsersPage/add submit button
	 * Where the add process is...
	 * To redirect in systemUsersPage
	 **/
	@RequestMapping("/add/done")
	public String AddMethod(HttpServletRequest request, HttpServletResponse response, 
											ModelMap model, Principal principal) throws IOException, ServletException{
		
		//Instantiate System User
		SystemUser sysUser = new SystemUser();
		
		//Get all values from the jsp
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		int access = Integer.parseInt(request.getParameter("access"));
		
		sysUser.setUsername(username);
		sysUser.setPassword(password);
		sysUser.setFirst_name(first_name);
		sysUser.setLast_name(last_name);
		sysUser.setAccess(access);
		
		sysUserDataAccesses.save(sysUser);
		
		return "login_page";
	}
	
	/**
	 * changes in url
	 * This is from /systemUsersPage Edit System Users button
	 * To redirect in ae_systemUsersPage
	 **/
	@RequestMapping("/edit")
	public String Edit(HttpServletRequest request, HttpServletResponse response, 
									  ModelMap model, Principal principal) throws IOException, ServletException{
		return "login_page";
	}
 
	/**
	 * changes in url
	 * This is from /systemUsersPage/edit submit button
	 * To redirect in systemUsersPage
	 **/
	@RequestMapping("/edit/done")
	public String EditMethod(HttpServletRequest request, HttpServletResponse response, 
											ModelMap model, Principal principal) throws IOException, ServletException{
		return "login_page";
	}
	

	
	  @RequestMapping(value = "/systemUserGenerateReport") 
	    public void getXLS(HttpServletResponse response,HttpServletRequest request, Model model) throws ClassNotFoundException { 
	  //   SystemUser_JService downloadService = new SystemUser_JService(); 
	     // Delegate to downloadService. Make sure to pass an instance of HttpServletResponse  
	  //   downloadService.downloadXLS(response); 
	 } 
	  
}
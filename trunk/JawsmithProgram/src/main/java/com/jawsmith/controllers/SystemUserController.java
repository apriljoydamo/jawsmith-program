package com.jawsmith.controllers;


import java.io.IOException;
import java.security.Principal;
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

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.model.SystemUser;



 
@Controller
@RequestMapping("system_users")
public class SystemUserController {
	static ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");

	static DataAccesses sysUserDataAccesses = (DataAccesses)appContext.getBean("systemUserBean");

	
	@RequestMapping("/record")
	public static String editRecord(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		
		int user_id = Integer.parseInt(request.getParameter("user_id_hidden"));
		SystemUser selectedUser = (SystemUser) sysUserDataAccesses.findById(user_id);
		
		request.getSession().setAttribute("selectedUser", selectedUser);
		System.out.println("Selected User: "+selectedUser.getUsername());
		
		return "redirect:/admin#edit_user_div";
	}
	
	/**
	 * This is from /systemUsersPage Add System Users button
	 * To redirect in ae_systemUsersPages
	 **/
	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response, 
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
		
		return "redirect:/admin";
	}
	
	/**
	 * changes in url
	 * This is from /systemUsersPage Edit System Users button
	 * To redirect in ae_systemUsersPage
	 **/
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, 
									  ModelMap model, Principal principal) throws IOException, ServletException{
		
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		SystemUser sysUser = (SystemUser) sysUserDataAccesses.findById(user_id);
		
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
		
		sysUserDataAccesses.update(sysUser);

		return "redirect:/admin";
	}
}
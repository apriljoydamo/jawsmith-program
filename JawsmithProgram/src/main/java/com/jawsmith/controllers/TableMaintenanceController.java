package com.jawsmith.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jawsmith.interfaces.DataAccesses;

@Controller
@RequestMapping("table_maintenance")
public class TableMaintenanceController {
	ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	DataAccesses dataAccesses = (DataAccesses)appContext.getBean("tableMaintenanceBean");
	
	@RequestMapping("/view")
	public String tableMaintenancePage(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		return "table_maintenance_page";
	}
}

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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.model.TableMaintenance;

@Controller
@RequestMapping("table_maintenance")
public class TableMaintenanceController {
	static ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	static DataAccesses dataAccesses = (DataAccesses)appContext.getBean("tableMaintenanceBean");
	
	@RequestMapping("/view")
	public static String tableMaintenancePage(HttpServletRequest request, HttpServletResponse response, 
								  ModelMap model, Principal principal) throws IOException, ServletException{
		
		List<TableMaintenance> tblMaintenanceList = dataAccesses.getAll();
		model.addAttribute("tblMaintenanceList", tblMaintenanceList);
		return "admin_page";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response, 
									 ModelMap model, Principal principal) throws IOException, ServletException{
		//Instantiate System User
		TableMaintenance tblMaintenance = new TableMaintenance();
		
		//Get all values from the jsp
		int reference_id = Integer.parseInt(request.getParameter("reference_id"));
		String code_table_value = request.getParameter("code_table_value");
		String tbl_maintenance_description = request.getParameter("tbl_maintenance_description");
		String last_name = request.getParameter("last_name");
		Boolean status = Boolean.valueOf(request.getParameter("status"));
		
		tblMaintenance.setReference_id(reference_id);
		tblMaintenance.setCode_table_value(code_table_value);
		tblMaintenance.setTbl_maintenance_description(tbl_maintenance_description);
		tblMaintenance.setStatus(status);
		
		dataAccesses.save(tblMaintenance);
		
		return "redirect:/table_maintenance/view";
	}
	
	/**
	 * changes in url
	 * This is from /systemUsersPage Edit System Users button
	 * To redirect in ae_systemUsersPage
	 **/
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, HttpServletResponse response, 
									  ModelMap model, Principal principal) throws IOException, ServletException{
		
		int table_maintenance_id = Integer.parseInt(request.getParameter("table_maintenance_id"));
		TableMaintenance tblMaintenance = (TableMaintenance) dataAccesses.findById(table_maintenance_id);
		
		//Get all values from the jsp
		int reference_id = Integer.parseInt(request.getParameter("reference_id"));
		String code_table_value = request.getParameter("code_table_value");
		String tbl_maintenance_description = request.getParameter("tbl_maintenance_description");
		String last_name = request.getParameter("last_name");
		Boolean status = Boolean.valueOf(request.getParameter("status"));
		
		tblMaintenance.setReference_id(reference_id);
		tblMaintenance.setCode_table_value(code_table_value);
		tblMaintenance.setTbl_maintenance_description(tbl_maintenance_description);
		tblMaintenance.setStatus(status);
		
		dataAccesses.update(tblMaintenance);

		return "redirect:/table_maintenance/view";
	}
}

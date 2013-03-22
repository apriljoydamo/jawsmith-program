package com.jawsmith.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.jawsmith.interfaces.DataAccesses;

@Controller
public class TableMaintenanceController {
	ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	DataAccesses dataAccesses = (DataAccesses)appContext.getBean("tableMaintenanceBean");
	
}

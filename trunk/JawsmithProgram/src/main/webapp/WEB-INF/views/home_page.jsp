<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Home Page</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home_page.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/modal.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/register.css"/>
	</head>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-prod.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-ui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/home_page.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/register.js"></script>
	<jsp:include page="header.jsp" />
	
	<body>
	<!--
	<div class="" id="acc_panel">
		<label id="user_name" class="">Hi Admin!</label><label id="logout_button" class="button mouseout_button">Log Out</label>
	</div>
	-->
	<div id="register_div" class="modalDialog">
		<div id="register_panel" class="">
	      <a href="#close" class="close_reg close" title="">X</a>
	      <h4>ADD PATIENT</h4>
	      <table>
	          <tr>
	                <td>First Name: </td>
	                <td><input type="text" id="" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Middle Name: </td>
	                <td><input type="text" id="" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Last Name: </td>
	                <td><input type="text" id="" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Date of Birth: </td>
	                <td><input type="date" id="" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Gender: </td>
	                <td><label><input type="radio" name="gender" value="male" id="" />Male</label>
	        			<label><input type="radio" name="gender" value="female" id="" />Female</label></td>  
	          </tr>
	          <tr>              
	                <td>Marital Status: </td>
	                <td><select name="select" id="select">
	                      <option value="single">Single</option>
	                      <option value="married">Married</option>
	                      <option value="widow">Widow</option>
	                      <option value="divorced">Divorced</option>
	                      <option value="seperated">Seperated</option>
		                  </select></td> 
	          </tr>
	          <tr>              
	                <td></td> 
	          </tr>
	          <tr>              
	                <td>Postal Address: </td>
	                <td><input type="text" id="" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Home Phone No. </td>
	                <td><input type="text" id="" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Mobile Number: </td>
	                <td><input type="text" id="" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>E-mail: </td>
	                <td><input type="text" id="" class=""/></td> 
	          </tr>
	          <tr>               
	                <td></td> 
	          </tr>
	          <tr>              
	                <td>Occupation: </td>
	                <td><input type="text" id="" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Religion: </td>
	                <td><input type="text" id="" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Guardian: </td>
	                <td><input type="text" id="" class=""/></td> 
	          </tr>
	          <tr>              
	                <td><input type="button" id="save_button" class="button mouseout_button" value="Save"/></td>
	          </tr>
	      </table>
	  </div>
	</div>
	<div class="" id="homepage_panel">
		<label id="patients_button" class="button mouseout_button">Patients</label>
		<label id="table_maintenance_button" class="button mouseout_button">Table Maintenance</label> 
	    <input type="text" id="" class="" />
		<label id="search_button" class="button mouseout_button">Search</label>
		<label id="advance_search_button" class="button mouseout_button">Advance Search</label>
		<label id="plus_button" class="button mouseout_button">Add Patients</label>
	</div>
	<div class="" id="patient_list">
	<table id="patient_table">
		<tr class="header_row">
	    	<td class="results">1</td>
	    	<td class="results">2</td>
	    	<td class="results">3</td>
	        
	    	<td class="results">4</td>
	    	<td class="results">5</td>
	    	<td class="results">6</td>
	    </tr>
	</table>
	<label id="save_report_button" class="button mouseout_button">Save Report</label>
	</div>
	</body>
</html>

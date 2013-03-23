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
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-prod.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-ui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/home_page.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/register.js"></script>
		<jsp:include page="header.jsp" />
	</head>
	
	<body>
	<div id="register_div" class="modalDialog">
		<div id="register_panel" class="">
	      <a href="#close" class="close_reg close" title="">X</a>
	      <h4>ADD PATIENT</h4>
	      <form action="${pageContext.request.contextPath}/patient/add" method="POST" >
	        <table>
	          <tr>
	                <td>Patient No: </td>
	                <td><input type="text" id="" name="patient_num" class=""/></td> 
	          </tr>
	          <tr>
	                <td>First Name: </td>
	                <td><input type="text" id="" name="first_name" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Middle Name: </td>
	                <td><input type="text" id="" name="middle_name" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Last Name: </td>
	                <td><input type="text" id="" name="last_name" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Date of Birth: </td>
	                <td><input type="date" id="" name="dob" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Gender: </td>
	                <td><label><input type="radio" name="sex" value="Male" id="" />Male</label>
	        			<label><input type="radio" name="sex" value="Female" id="" />Female</label></td>  
	          </tr>
	          <tr>              
	                <td>Marital Status: </td>
	                <td><select name="rel_status" id="select">
	                      <option value="single">Single</option>
	                      <option value="married">Married</option>
	                      <option value="widow">Widow</option>
	                      <option value="divorced">Divorced</option>
	                      <option value="seperated">Seperated</option>
		                  </select>
		           	</td> 
	          </tr>
	          <tr>              
	                <td></td> 
	          </tr>
	          <tr>              
	                <td>Postal Address: </td>
	                <td><input type="text" id="" name="address" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Home Phone No. </td>
	                <td><input type="text" id="" name="tel_num" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Mobile Number: </td>
	                <td><input type="text" id="" name="mobile_num" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>E-mail: </td>
	                <td><input type="text" id="" name="email" class=""/></td> 
	          </tr>
	          <tr>               
	                <td></td> 
	          </tr>
	          <tr>              
	                <td>Nationality: </td>
	                <td><input type="text" id="" name="nationality" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Occupation: </td>
	                <td><input type="text" id="" name="occupation" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Religion: </td>
	                <td><input type="text" id="" name="religion" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Guardian: </td>
	                <td><input type="text" id="" name="guardian" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Referred by: </td>
	                <td><input type="text" id="" name="referred_by" class=""/></td> 
	          </tr>
	          
	          <c:if test="${param.edit==true && user.access==1}">
	          <tr>              
	                <td>Patient Status: </td>
	                <td><select name="status" id="select">
	                      <option value="1">Active</option>
	                      <option value="0">Inactive</option>
		                  </select></td> 
	          </tr>
	          </c:if>
	          
	          <tr>              
	                <td><input type="submit" id="save_button" class="button mouseout_button" value="Save"/></td>
	          </tr>
	      	</table>
	      </form>
	  </div>
	</div>
	
	
	
	<div class="" id="homepage_panel">
		<label id="patients_button" onclick="buttonNextPage('${pageContext.request.contextPath}/patient/')" class="button mouseout_button">
		Patients</label>
		<c:if test="${user.access==1}">
	          <label id="table_maintenance_button" class="button mouseout_button">Table Maintenance</label> 
	    </c:if>
	    <input type="text" id="" class="" />
		<label id="search_button" class="button mouseout_button">Search</label>
		<label id="advance_search_button" class="button mouseout_button">Advance Search</label>
		<label id="plus_button" class="button mouseout_button">Add Patients</label>
	</div>
	
	
	
	<div class="" id="patient_list">
	<table id="patient_table">
	    <tr class="header_row">
	    	<td class="results">Patient No</td>
	    	<td class="results">Last Name</td>
	    	<td class="results">First Name</td>
	    	<td class="results">Middle Name</td>	    	
	    	<td class="results">Last Visit Date</td>
	    	<td class="results">Birthday</td>	    	
	    	<td class="results">Gender</td>
	    	<td class="results">Marital Status</td>
	    	<td class="results">Address</td>
	    	<td class="results">Tel No.</td>
	    	<td class="results">Cell No.</td>
	    	<td class="results">E-mail</td>
	    	<td class="results">Nationality</td>
	    	<td class="results">Occupation</td>
	    	<td class="results">Religion</td>
	    	<td class="results">Referred By</td>
	    	<td class="results">Guardian</td>
	    </tr>
	    <c:forEach var="patient" items="${patientList}">
	    <tr id="patient_id_${patient.patient_id}" class="patient_records">	    	
	    	<td class="results"><c:out value="${patient.patient_num}" /></td>
	    	<td class="results"><c:out value="${patient.last_name}" /></td>
	    	<td class="results"><c:out value="${patient.first_name}" /></td>
	    	<td class="results"><c:out value="${patient.middle_name}" /></td>	    	
	    	<td class="results"><c:out value="${patient.last_visit_date}" /></td>
	    	<td class="results"><c:out value="${patient.birthday}" /></td>	    	
	    	<td class="results"><c:out value="${patient.sex=='M' ? 'Male' : 'Female'}" /></td>
	    	<td class="results"><c:out value="${patient.relationship_status}" /></td>
	    	<td class="results"><c:out value="${patient.address}" /></td>
	    	<td class="results"><c:out value="${patient.telephone_number}" /></td>
	    	<td class="results"><c:out value="${patient.mobile_number}" /></td>
	    	<td class="results"><c:out value="${patient.email_address}" /></td>
	    	<td class="results"><c:out value="${patient.nationality}" /></td>
	    	<td class="results"><c:out value="${patient.occupation}" /></td>
	    	<td class="results"><c:out value="${patient.religion}" /></td>
	    	<td class="results"><c:out value="${patient.referred_by}" /> </td>
	    	<td class="results"><c:out value="${patient.guardian}" /></td>
	    </tr>
	    </c:forEach>
	</table>
	
	<label id="save_report_button" class="button mouseout_button">Save Report</label>
	</div>
	</body>
</html>

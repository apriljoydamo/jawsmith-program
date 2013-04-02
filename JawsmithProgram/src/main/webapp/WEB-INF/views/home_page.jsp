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
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/common.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/home_page.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/register.js"></script>
		<jsp:include page="header.jsp" />
	</head>
	
	<body>
	<div id="register_div" class="modalDialog">
		<div id="register_panel" class="">
	      <a href="#close" class="close_reg close" title="">X</a>
	      <label id="add_patient_label">ADD PATIENT</label>
	      <form id="add_patient_form" action="${pageContext.request.contextPath}/patient/add" method="POST" >
	        <table>
	          <tr>
	                <td>Patient No: </td>
	                <td><input type="text" id="add_patient_num" name="patient_num" class=""/></td> 
	          </tr>
	          <tr>
	                <td>First Name: </td>
	                <td><input type="text" id="add_patient_first_name" name="first_name" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Middle Name: </td>
	                <td><input type="text" id="add_patient_middle_name" name="middle_name" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Last Name: </td>
	                <td><input type="text" id="add_patient_last_name" name="last_name" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Date of Birth: </td>
	                <td><input placeholder="yyyy-MM-dd" type="text" id="add_patient_date_of_birth" name="dob" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Gender: </td>
	                <td><label><input type="radio" name="add_patient_sex" value="Male" />Male</label>
	        			<label><input type="radio" name="add_patient_sex" value="Female" />Female</label></td>  
	          </tr>
	          <tr>              
	                <td>Marital Status: </td>
	                <td><select name="rel_status" id="add_patient_marital_status">
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
	                <td><textarea id="add_patient_postal_address" name="address" class=""></textarea></td> 
	          </tr>
	          <tr>              
	                <td>Home Phone No. </td>
	                <td><input type="text" id="add_patient_home_no" name="tel_num" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Mobile Number: </td>
	                <td><input type="text" id="add_patient_mobile_no" name="mobile_num" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>E-mail: </td>
	                <td><input type="text" id="add_patient_email" name="email" class=""/></td> 
	          </tr>
	          <tr>               
	                <td></td> 
	          </tr>
	          <tr>              
	                <td>Nationality: </td>
	                <td><input type="text" id="add_patient_nationality" name="nationality" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Occupation: </td>
	                <td><input type="text" id="add_patient_occupation" name="occupation" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Religion: </td>
	                <td><input type="text" id="add_patient_religion" name="religion" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Guardian: </td>
	                <td><input type="text" id="add_patient_guardian" name="guardian" class=""/></td> 
	          </tr>
	          <tr>              
	                <td>Referred by: </td>
	                <td><input type="text" id="add_patient_referred_by" name="referred_by" class=""/></td> 
	          </tr>
	          
	          <c:if test="${param.edit==true && user.access==1}">
	          <tr>              
	                <td>Patient Status: </td>
	                <td><select name="status" id="add_patient_status">
	                      <option value="1">Active</option>
	                      <option value="0">Inactive</option>
		                  </select></td> 
	          </tr>
	          </c:if>
	          
	          <tr>              
	                <td><label id="save_button" class="button mouseout_button" onclick="validatePatient()" >Save</label></td>
	          </tr>
	      	</table>
	      </form>
	  </div>
	</div>
	
	<div class="" id="homepage_panel">
		<label id="patients_button" onclick="buttonNextPage('${pageContext.request.contextPath}/patient/list')" class="button mouseout_button">
		Patients</label>
		<c:if test="${user.access==1}">
	          <label id="table_maintenance_button" onclick="buttonNextPage('${pageContext.request.contextPath}/admin')" class="button mouseout_button">Admin Tools</label>
	    </c:if>
	    <input type="text" id="" class="" />
		<label id="search_button" class="button mouseout_button">Search</label>
		<label id="advance_search_button" class="button mouseout_button">Advance Search</label>
		<label id="plus_button" class="button mouseout_button">Add Patients</label>
	</div>
	
	<div class="" id="patient_list">
	<table id="patient_table">
	    <tr class="header_row">
	    	<td class="table_header">Patient No</td>
	    	<td class="table_header">Last Name</td>
	    	<td class="table_header">First Name</td>
	    	<td class="table_header">Middle Name</td>	    	
	    	<td class="table_header">Last Visit Date</td>
	    	<td class="table_header">Birthday</td>	    	
	    	<td class="table_header">Gender</td>
	    	<td class="table_header">Marital Status</td>
	    </tr>
	    <c:forEach var="patient" items="${patientList}">
	    <tr id="patient_id_${patient.patient_id}" onclick="selectPatient('${patient.patient_id}')" class="patient_records record_mouseout_button">	    	
	    	<td class="results"><c:out value="${patient.patient_num}" /></td>
	    	<td class="results"><c:out value="${patient.last_name}" /></td>
	    	<td class="results"><c:out value="${patient.first_name}" /></td>
	    	<td class="results"><c:out value="${patient.middle_name}" /></td>	    	
	    	<td class="results"><c:out value="${patient.last_visit_date}" /></td>
	    	<td class="results"><c:out value="${patient.birthday}" /></td>	    	
	    	<td class="results"><c:out value="${patient.sex=='M' ? 'Male' : 'Female'}" /></td>
	    	<td class="results"><c:out value="${patient.relationship_status}" /></td>
	    </tr>
	    </c:forEach>
	    
	    <tr id="patient_id_" onclick="selectPatient('1')" class="patient_records record_mouseout_button">	    	
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>	    	
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>	    	
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>
	    </tr>
	    <tr id="patient_id_" onclick="selectPatient('2')" class="patient_records record_mouseout_button">	    	
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>	    	
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>	    	
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>
	    </tr>
	    <tr id="patient_id_" onclick="selectPatient('3')" class="patient_records record_mouseout_button">	    	
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>	    	
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>	    	
	    	<td class="results">TEST</td>
	    	<td class="results">TEST</td>
	    </tr>
	</table>
	
	<table border="1" cellpadding="5" cellspacing="5">
        <tr>

            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${pageNum eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
	       				<td><a href="${pageContext.request.contextPath}/patient/list?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
    
	<form id="view_patient_form" action="${pageContext.request.contextPath}/patient/view_patient" method="post">
		<input type="hidden" id="patient_id" name="patient_id"/>
	</form>
	</div>
	
	<div id="footer_panel" class="">
	</div>
	</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Treatment Records</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/patients_record.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/modal.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/treatment_record.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-1.9.1.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-ui-1.10.2.custom.js"></script>        
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/common.js"></script>        
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/treatment_page.js"></script>
	 	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/treatment_record.js"></script>
	</head>
	
	<body>
	<center>
	<div id="body_div">		
	<jsp:include page="header.jsp" />
 		<div class="" id="patient_info_panel" style="width: 300px; margin-left:590px;">
	       	<a href="${pageContext.request.contextPath}/patient/view_patient/details"><label class="patient_name" id="">${patient.last_name}, ${patient.first_name} ${patient.middle_name}</label></a><br/>
	        <label class="sub_info" id="">Last Visit Date: ${patient.last_visit_date}</label><br/>
		</div>
		
		<div id="treatment_record_image" class="">
			<img id="treatment_record_image" alt="" src="${pageContext.request.contextPath}/resources/images/chart3.jpg" />
		</div>
		
		<div id="patients_treatment_plan" class="">
			<table id="record_table">
				<tr>
					<th>Date</th>
					<th>Tooth No.</th>
					<th>Description</th>
					<th>Prescription</th>
					<th>Debit</th>
					<th>Credit Date</th>
					<th>Credit Amount</th>
					<th>Balance</th>
					<th>Note/s</th>
				</tr>
				<c:forEach var="treatment_rec" items="${treatmentRecordList}">
				<tr id="treatment_record_id" class="patient_records record_mouseout_button" onclick="selectTreatmentRecord('${treatment_rec.treatment_record_id}')">
					<td class="results"><c:out value="${treatment_rec.last_visit_date}" /></td>
					<td class="results"><c:out value="${treatment_rec.tooth_number}" /></td>
					<td class="results"><c:out value="${treatment_rec.description}" /></td>
					<td class="results"><c:out value="${treatment_rec.prescription}" /></td>
					<td class="results"><fmt:formatNumber value="${treatment_rec.debit}" type="currency" currencySymbol="" /></td>
					<td class="results"><fmt:formatDate value="${treatment_rec.credit_date}" pattern="yyyy-MM-dd" /></td>
					<td class="results"><fmt:formatNumber value="${treatment_rec.credit_amount}" type="currency" currencySymbol="" /></td>
					<td class="results"><fmt:formatNumber value="${treatment_rec.debit - treatment_rec.credit_amount}" type="currency" currencySymbol=""/></td>	
					<td class="results"><c:out value="${treatment_rec.description_notes}" /></td>
				</tr>
				</c:forEach>
				<tr>
					<td w_bg></td>
					<td w_bg></td>
					<td w_bg></td>
					<td w_bg></td>
					<td w_bg></td>
					<td w_bg></td>
					<td w_bg>Total Balance:</td>
					<td w_bg><fmt:formatNumber value="${totalBalance}" type="currency" currencySymbol="" /></td>
					<td w_bg></td>
				</tr>
			</table>
		</div>
		
		<label id="add_record_button" class="button mouseout_button" onclick="buttonNextPage('#add_treatment_record_div')">Add Record</label>
		
		<form id="treatment_record_form_id" action="${pageContext.request.contextPath}/treatment_record/record" method="POST">
			<input type="hidden" value="" id="treatment_record_id_hidden" name="treatment_record_id_hidden" />
		</form>
		
		<jsp:include page="add_treatment_record.jsp"/>
		<jsp:include page="edit_treatment_record.jsp"/>
	</div>	
	</center>
	</body>
</html>
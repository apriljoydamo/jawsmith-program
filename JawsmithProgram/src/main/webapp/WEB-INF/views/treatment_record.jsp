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
	</head>
	
	<center>
	<body>
	<div id="body_div">		
	<jsp:include page="header.jsp" />
 		<div class="" id="patient_info_panel">
	        <label class="patient_name" id="">${patient.last_name}, ${patient.first_name} ${patient.middle_name}</label><br/>
	        <label class="sub_info" id="">Last Visit Date: ${patient.last_visit_date}</label><br/>
	        <label class="sub_info" id="">Birthday: ${patient.birthday}</label><br/>
	        <label class="sub_info" id="">${patient.sex} | ${patient.relationship_status} | ${patient.nationality}</label><br/>
	        <label class="sub_info" id="">${patient.address}</label><br/>
	        <label class="sub_info" id="">${patient.mobile_number} / ${patient.telephone_number} / ${patient.email_address}</label><br/>
	        <label class="sub_info" id="">${patient.occupation} | ${patient.religion}</label><br/>
	        <label class="sub_info" id="">${patient.referred_by} | ${patient.guardian}</label><br/>
	        <label class="sub_info" id="">${patient.status}</label><br/>
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
				</tr>
				<c:forEach var="treatment_rec" items="${treatmentRecordList}">
				<tr>
					<td><c:out value="${treatment_rec.last_visit_date}" /></td>
					<td><c:out value="${treatment_rec.tooth_number}" /></td>
					<td><c:out value="${treatment_rec.description}" /></td>
					<td><c:out value="${treatment_rec.prescription}" /></td>
					<td><fmt:formatNumber value="${treatment_rec.debit}" type="currency" currencySymbol="" /></td>
					<td><fmt:formatDate value="${treatment_rec.credit_date}" pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatNumber value="${treatment_rec.credit_amount}" type="currency" currencySymbol="" /></td>
					<td><fmt:formatNumber value="${treatment_rec.debit - treatment_rec.credit_amount}" type="currency" currencySymbol=""/></td>	
				</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>Total Balance:</td>
					<td><fmt:formatNumber value="${totalBalance}" type="currency" currencySymbol="" /></td>
				</tr>
			</table>
		</div>
		
		<label id="add_record_button" class="button mouseout_button" onclick="buttonNextPage('#add_treatment_record_div')">Add Record</label>
		
		
		<jsp:include page="add_treatment_record.jsp"/>
		<jsp:include page="edit_treatment_record.jsp"/>
	</div>	
	</body>
	</center>
</html>
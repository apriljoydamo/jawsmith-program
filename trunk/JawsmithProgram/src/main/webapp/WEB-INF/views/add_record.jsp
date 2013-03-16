<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Beauteethful</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
		<jsp:include page="header.jsp" />
	</head>
	<body>
		<div id="patient_info">
		${patient.last_name}, ${patient.first_name} ${patient.middle_name}<br/>
		Last Visit Date ${patient.last_visit_date}
		Born ${patient.birthday}<br/>
		${patient.sex}<span>|</span>${patient.relationship_status}<span>|</span>${patient.nationality}<br/>
		${patient.address}, ${patient.city}<br/>
		${patient.mobile_number}<span>|</span>${patient.telephone_number}<span>|</span>${patient.email_address}<br/>
		${patient.occupation}<span>|</span>${patient.religion}<br/>
		${patient.referred_by}<span>|</span>${patient.guardian}<br/>
		Status ${patient.status}<br/>
		</div>
		
		
		<div>
			<form action="${pageContext.request.contextPath}/add_record" method="POST">
			<div id="patient_medical_info">
				<h3>Medical History</h3>
				<div id="medical_his_div">
				<!-- MEDICAL HISTORY BASED ON FORM HERE -->
				</div>
				<h3>Dental History</h3>
				<div id="dental_his_div">
				<!-- DENTAL HISTORY BASED ON FORM HERE -->
				</div>
				<h3>Clinical Examination</h3>
				<div id="clinic_exam_div">
				<!-- CLINICAL EXAM BASED ON FORM HERE -->
				</div>
				<h3>Occlusion</h3>
				<div id="occlusion_div">
				<!-- OCCLUSION BASED ON FORM HERE -->
				</div>
				<h3>Anxillaries</h3>
				<div id="anxillaries_div">
				<!-- ANXILLARIES BASED ON FORM HERE -->
				</div>
				<h3>Chief Complaint</h3>
				<div id="chief_complaint_div">
				<!-- CHIEF COMPLAINT BASED ON FORM HERE -->
				</div>
				<h3>Diagnosis</h3>
				<div id="diagnosis_div">
				<!-- DIAGNOSIS BASED ON FORM HERE -->
				</div>
				<h3>Treatment Plan</h3>
				<div id="treatment_plan_div">
				<!-- TREATMENT PLAN BASED ON FORM HERE -->
				</div>
			</div>
			
			<input type="submit" value="Save"/>
			</form>
		</div>
	</body>
</html>
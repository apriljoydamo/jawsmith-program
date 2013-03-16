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
		<div id="view_patient_page_div1">
			<div id="patient_info">
				<h1>${patient.last_name}, ${patient.first_name} ${patient.middle_name}</h1><br/>
				Last Visit Date ${patient.last_visit_date}
				Born ${patient.birthday}<br/>
				${patient.sex}<span>|</span>${patient.relationship_status}<span>|</span>${patient.nationality}<br/>
				${patient.address}, ${patient.city}<br/>
				${patient.mobile_number}<span>|</span>${patient.telephone_number}<span>|</span>${patient.email_address}<br/>
				${patient.occupation}<span>|</span>${patient.religion}<br/>
				${patient.referred_by}<span>|</span>${patient.guardian}<br/>
				Status ${patient.status}<br/>
			</div>
			<div id="edit_patient_button">
				<form action="${pageContext.request.contextPath}/editPatient" method="POST">
					<input type="submit" value="Edit Patient"/>
				</form>
			</div>
		</div>
		<div id="view_patient_page_div2">
			<div id="patient_medical_info">
				<h3>Medical History</h3><span>dropdown_image</span>
				<div id="medical_his_div">
				${medical_his.question} - ${medical_his.answer}<br/>
				${medical_his.question} - ${medical_his.answer}<br/>
				${medical_his.question} - ${medical_his.answer}<br/>
				</div>
				<h3>Dental History</h3><span>dropdown_image</span>
				<div id="dental_his_div">
				${dental_his.fluoride_treatment}<br/>
				${dental_his.orthodontic_treatment}<br/>
				</div>
				<h3>Clinical Examination</h3><span>dropdown_image</span>
				<div id="clinic_exam_div">
				${clinic_exam.gingival_color}<br/>
				${clinic_exam.consistency_of_gingival}<br/>
				${clinic_exam.tounge}<br/>
				</div>
				<h3>Occlusion</h3><span>dropdown_image</span>
				<div id="occlusion_div">
				${occlusion.class_1}<br/>
				${occlusion.class_2}<br/>
				${occlusion.class_3}<br/>
				</div>
				<h3>Anxillaries</h3><span>dropdown_image</span>
				<div id="anxillaries_div">
				${anxillaries.bleeding_time}<br/>
				${anxillaries.blood_pressure}<br/>
				${anxillaries.radiographic_interpretation}<br/>
				</div>
				<h3>Chief Complaint</h3><span>dropdown_image</span>
				<div id="chief_complaint_div">
				</div>
				<h3>Diagnosis</h3><span>dropdown_image</span>
				<div id="diagnosis_div">
				</div>
				<h3>Treatment Plan</h3><span>dropdown_image</span>
				<div id="treatment_plan_div">
				</div>
			</div>
			<div id="edit_medical_button">
				<form action="${pageContext.request.contextPath}/editPatient" method="POST">
					<input type="submit" value="Edit Patient"/>
				</form>
			</div>
		</div>

		<div id="view_patient_page_div3">
			<form action="${pageContext.request.contextPath}/addMedicalRecord" method="POST">
			<input type="submit" value="Add Medical Record"/>
			</form>
			
			<form action="${pageContext.request.contextPath}/addTreatmentPlan" method="POST">
			<input type="submit" value="Add Treatment Plan"/>
			</form>
			
			<form action="${pageContext.request.contextPath}/treatmentRecord" method="POST">
			<input type="submit" value="Treatment Record"/>
			</form>
		</div>
	</body>
</html>
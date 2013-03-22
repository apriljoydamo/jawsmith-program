<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Beauteethful</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/patients_record.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/modal.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-1.9.1.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-ui-1.10.2.custom.js"></script>        
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/common.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/patients_record.js"></script>
		<jsp:include page="header.jsp" />
	</head>
		
	<body>
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
		<div id="view_patient_page_div1">
			<div id="edit_patient_button">
				<form action="${pageContext.request.contextPath}/editPatient" method="POST">
					<label style="position:relative; top: 50px;" id="" class="button mouseout_button" onClick="submitForm('edit_patient')">Edit Patient</label>
				</form>
			</div>
		</div>
		<div id="view_patient_page_div2">
			<div id="patient_medical_info">
				<h3 class="patient_medical_info patient_medical_info_mouseout">Medical History</h3>
				<div id="medical_his_div" class="">
                    ${medical_his.question} - ${medical_his.answer}<br/>
                    ${medical_his.question} - ${medical_his.answer}<br/>
                    ${medical_his.question} - ${medical_his.answer}<br/>
				</div>
				<h3 class="patient_medical_info patient_medical_info_mouseout">Dental History</h3>
				<div id="dental_his_div">
                    ${dental_his.fluoride_treatment}<br/>
                    ${dental_his.orthodontic_treatment}<br/>
				</div>
				<h3 class="patient_medical_info patient_medical_info_mouseout">Clinical Examination</h3>
				<div id="clinic_exam_div">
                    ${clinic_exam.gingival_color}<br/>
                    ${clinic_exam.consistency_of_gingival}<br/>
                    ${clinic_exam.tounge}<br/>
				</div>
				<h3 class="patient_medical_info patient_medical_info_mouseout">Occlusion</h3>
				<div id="occlusion_div">
                    ${occlusion.class_1}<br/>
                    ${occlusion.class_2}<br/>
                    ${occlusion.class_3}<br/>
				</div>
				<h3 class="patient_medical_info patient_medical_info_mouseout">Anxillaries</h3>
				<div id="anxillaries_div">
                    ${anxillaries.bleeding_time}<br/>
                    ${anxillaries.blood_pressure}<br/>
                    ${anxillaries.radiographic_interpretation}<br/>
				</div>
				<h3 class="patient_medical_info patient_medical_info_mouseout">Chief Complaint</h3>
				<div id="chief_complaint_div">
                	test complaints
				</div>
				<h3 class="patient_medical_info patient_medical_info_mouseout">Diagnosis</h3>
				<div id="diagnosis_div">
					test diagnosis
                </div>
				<h3 class="patient_medical_info patient_medical_info_mouseout">Treatment Plan</h3>
				<div id="treatment_plan_div">
					test plan
                </div>
			</div>
		</div>

		<div id="view_patient_controllers">			
        	<form id="edit_patients_record" action="${pageContext.request.contextPath}/editPatient" method="POST">	
			</form>
            <label id="" class="button mouseout_button" onClick="submitForm('edit_patients_record')">Edit Record</label>
			<label id="" class="button mouseout_button" onClick="buttonNextPage('${pageContext.request.contextPath}/patient/add_record')">Add Medical Record</label>
			<label id="" class="button mouseout_button" onClick="buttonNextPage('#add_treatment_plan')">Add Treatment Plan</label>
            <label id="" class="button mouseout_button" onClick="buttonNextPage('${pageContext.request.contextPath}/treatmentRecord')">Treatment Record</label>
		</div>
        
		<div id="add_treatment_plan" class="modalDialog">
		        <div id="add_treatment_panel">
		        <a href="#close" class="close_add_treat close">X</a>     
					<h1>TREATMENT PLAN</h1>			
					<form id="saveRecord" action="${pageContext.request.contextPath}/add_record" method="POST">
		            	<table>
		                <tr>
		                	<td>Treatment: </td>
		                	<td><input type="text" name="treatment" value="" />	</td>
		                	<td><input type="text" name="fee" value="Fee" /></td>
		                </tr>
		                <tr>
		                	<td>Alternate Treatment: </td>
		                	<td><input type="text" name="alternateTreatment" value="" /></td>
		                	<td><input type="text" name="altFee" value="Fee" /></td>
		                </tr>
		                </table>
		                <label id="" class="button mouseout_button" onClick="submitForm('saveRecord')">Add Treatment Plan</label>
					</form>
				</div>
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Beauteethful</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/patients_record.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/modal.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add_record.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-1.9.1.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-ui-1.10.2.custom.js"></script>        
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/common.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/patients_record.js"></script>
		<jsp:include page="header.jsp" />
	</head>
		
	<body>
	<jsp:include page="add_record.jsp" />
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
		<div id="edit_patient_button">
			<form action="${pageContext.request.contextPath}/editPatient" method="POST">
				<label style="position:relative; top: 50px;" id="" class="button mouseout_button" onClick="submitForm('edit_patient')">Edit Patient</label>
			</form>
		</div>

		<div id="view_patient_page_div">
			<div id="patient_medical_info">
				<h3 class="patient_medical_info patient_medical_info_mouseout">Medical History</h3>
				<div id="medical_his_div" class="">
                   <table>
					<c:forEach var="medhis" items="${latestMedHisList}" >
						<tr>
							<td><c:out value="${medhis.question_id}" /></td>
							<td><c:out value="${medhis.answer}" /></td>
						</tr>
					</c:forEach>
					</table>
				</div>
				<h3 class="patient_medical_info patient_medical_info_mouseout">Dental History</h3>
				<div id="dental_his_div">
                  <img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox.png"/>
                  <img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/>
                  
                   <table>
                  		<tr>
                  			<td>
                  				<c:choose>
                  					<c:when test="${dentalhis.fluoride_treatment==true}"><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/></c:when>
                  					<c:otherwise><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox.png"/></c:otherwise>
                  				</c:choose>
                  			</td>
                  			<td>Fluoride Treatment</td>
                  		</tr>
                  		<tr>
                  			<td>
                  				<c:choose>
                  					<c:when test="${dentalhis.fluoride_treatment==true}"><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/></c:when>
                  					<c:otherwise><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox.png"/></c:otherwise>
                  				</c:choose>
                  			</td>
                  			<td>Orthodontic Treatment</td>
                  		</tr>
                  		<tr>
                  			<td>
                  				<c:choose>
                  					<c:when test="${dentalhis.fluoride_treatment==true}"><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/></c:when>
                  					<c:otherwise><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox.png"/></c:otherwise>
                  				</c:choose>
                  			</td>
                  			<td>Pulp Therapy</td>
                  		</tr>
                  		<tr>
                  			<td>
                  				<c:choose>
                  					<c:when test="${dentalhis.fluoride_treatment==true}"><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/></c:when>
                  					<c:otherwise><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox.png"/></c:otherwise>
                  				</c:choose>
                  			</td>
                  			<td>Temporo Mandibular</td>
                  		</tr>
                  		<tr>
                  			<td>
                  				<c:choose>
                  					<c:when test="${dentalhis.fluoride_treatment==true}"><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/></c:when>
                  					<c:otherwise><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox.png"/></c:otherwise>
                  				</c:choose>
                  			</td>
                  			<td>Periodontal Therapy</td>
                  		</tr>
                  		<tr>
                  			<td>
                  				<c:choose>
                  					<c:when test="${dentalhis.fluoride_treatment==true}"><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/></c:when>
                  					<c:otherwise><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox.png"/></c:otherwise>
                  				</c:choose>
                  			</td>
                  			<td>Dental Surgery</td>
                  		</tr>
                  		<tr>
                  			<td>
                  				<c:choose>
                  					<c:when test="${dentalhis.fluoride_treatment==true}"><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/></c:when>
                  					<c:otherwise><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox.png"/></c:otherwise>
                  				</c:choose>
                  			</td>
                  			<td>Extraction</td>
                  		</tr>
                   </table>
				</div>
				<h3 class="patient_medical_info patient_medical_info_mouseout">Clinical Examination</h3>
				<div id="clinic_exam_div">
                    <table>
                   		<tr>
                   			<td>Gingival Color:</td>
                   			<td><c:out value="${clinical.gingival_color}" /></td>
                   		</tr>
                   		<tr>
                   			<td>Consistency of Gingival:</td>
                   			<td><c:out value="${clinical.consistency_of_gingival}" /></td>
                   		</tr>
                   		<tr>
                   			<td>Tounge:</td>
                   			<td><c:out value="${clinical.tounge}" /></td>
                   		</tr>
                   		<tr>
                   			<td>Oral Hygiene:</td>
                   			<td><c:out value="${clinical.oral_hygiene}" /></td>
                   		</tr>
                   		<tr>
                   			<td>Lymph Nodes:</td>
                   			<td><c:out value="${clinical.lymph_nodes}" /></td>
                   		</tr>
                    </table>
				</div>
				<h3 class="patient_medical_info patient_medical_info_mouseout">Occlusion</h3>
				<div id="occlusion_div">
                   <table>
                   		<tr>
                   			<td>Class I</td>
                   			<td>div: <c:out value="${occlusion.class_1}" /></td>
                   		</tr>
                   		<tr>
                   			<td>Class II</td>
                   			<td>div: <c:out value="${occlusion.class_2}" /></td>
                   		</tr>
                   		<tr>
                   			<td>Class III</td>
                   			<td>div: <c:out value="${occlusion.class_3}" /></td>
                   		</tr>
                    </table>
				</div>
				<h3 class="patient_medical_info patient_medical_info_mouseout">Anxillaries</h3>
				<div id="anxillaries_div">
                   <table>
                   		<tr>
                   			<td>Bleeding Time:</td>
                   			<td><c:out value="${anxillaries.bleeding_time}" /></td>
                   		</tr>
                   		<tr>
                   			<td>Blood Pressure:</td>
                   			<td><c:out value="${anxillaries.blood_pressure}" /></td>
                   		</tr>
                   		<tr>
                   			<td>Radiographic Interpretation</td>
                   			<td><c:out value="${anxillaries.radiographic_interpretation}" /></td>
                   		</tr>
                   		<tr>
                   			<td>Clotting Time</td>
                   			<td><c:out value="${anxillaries.clotting_time}" /></td>
                   		</tr>
                   		<tr>
                   			<td>Blood Sugar</td>
                   			<td><c:out value="${anxillaries.blood_sugar}" /></td>
                   		</tr>
                    </table>
				</div>
				<h3 class="patient_medical_info patient_medical_info_mouseout">Chief Complaint</h3>
				<div id="chief_complaint_div">
                	<c:out value="${other.chief_complaint}" />
				</div>
				<h3 class="patient_medical_info patient_medical_info_mouseout">Diagnosis</h3>
				<div id="diagnosis_div">
					<c:out value="${other.diagnosis}" />
                </div>
                <h3 class="patient_medical_info patient_medical_info_mouseout">Note/s</h3>
				<div id="notes_div">
					<c:out value="${other.description_notes}" />
                </div>
				<h3 class="patient_medical_info patient_medical_info_mouseout">Treatment Plan</h3>
				<div id="treatment_plan_div">
					<table>
						<tr>
							<td>Treatment:</td>
							<td><c:out value="${treatmentplan.treatment}" /></td>
							<td>Treatment Fee:</td>
							<td><fmt:formatNumber value="${treatmentplan.treatment_fee}" type="currency" currencySymbol="" /></td>
						</tr>
						<tr>
							<td>Alternative Treatment:</td>
							<td><c:out value="${treatmentplan.alternative_treatment}" /></td>
							<td>Alternative Treatment Fee:</td>
							<td><fmt:formatNumber value="${treatmentplan.alternative_treatment_fee}" type="currency" currencySymbol="" /></td>
						</tr>
					</table>
                </div>
			</div>
		</div>

		<div id="view_patient_controllers">			
        	<form id="edit_patients_record" action="${pageContext.request.contextPath}/editPatient" method="POST">	
			</form>
            <label id="" class="button mouseout_button" onClick="submitForm('edit_patients_record')">Edit Medical Record</label>
			<label id="" class="button mouseout_button" onClick="buttonNextPage('#add_record_div')">Add Medical Record</label>
			<label id="" class="button mouseout_button" onClick="buttonNextPage('#add_treatment_plan')">Add Treatment Plan</label>
            <label id="" class="button mouseout_button" onClick="buttonNextPage('${pageContext.request.contextPath}/treatment_record/view')">Treatment Record</label>
            <label id="" class="button mouseout_button" onClick="buttonNextPage('${pageContext.request.contextPath}/patient/generate_pdf_file')">Save Report</label>
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
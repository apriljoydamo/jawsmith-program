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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/register.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-1.9.1.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-ui-1.10.2.custom.js"></script>        
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/common.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/patients_record.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/register.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/home_page.js"></script>
		<jsp:include page="header.jsp" />
	</head>
		
	<body>
	<jsp:include page="edit_record.jsp" />
	<jsp:include page="edit_patient.jsp" />
	<jsp:include page="add_record.jsp" />
	 
	   <div class="" id="patient_info_panel">
	        <label class="patient_name" id="">${patient.last_name}, ${patient.first_name} ${patient.middle_name}</label><br/>
	        <label class="sub_info" id="">Last Visit Date: <fmt:formatDate value="${patient.last_visit_date}" pattern="yyyy-MM-dd"/></label><br/>
	        <label class="sub_info" id="">Birthday: <fmt:formatDate value="${patient.birthday}" pattern="yyyy-MM-dd"/></label><br/>
	        <label class="sub_info" id="">${patient.sex} | ${patient.relationship_status} | ${patient.nationality}</label><br/>
	        <label class="sub_info" id="">${patient.address}</label><br/>
	        <label class="sub_info" id="">${patient.mobile_number} / ${patient.telephone_number} / ${patient.email_address}</label><br/>
	        <label class="sub_info" id="">${patient.occupation} | ${patient.religion}</label><br/>
	        <label class="sub_info" id="">${patient.referred_by} | ${patient.guardian}</label><br/>
	        <label class="sub_info" id="">${patient.status}</label><br/>
		</div>
		<div id="edit_patient_button">
			<c:if test="${user.access==1 || user.access==2}">
			<label style="position:relative; top: 50px;" id="plus_button" class="button mouseout_button">Edit Patient</label>
			</c:if>
			<label style="position:relative; top: 50px;" class="button mouseout_button" onClick="buttonNextPage('${pageContext.request.contextPath}/patient/generate_pdf_file')">Save Report</label>
		</div>

		<div id="view_patient_page_div">
			<div id="patient_medical_info">
				<h3 class="patient_medical_info patient_medical_info_mouseout">Medical History</h3>
				<div id="medical_his_div" class="">
                   <table>
                  	 	<tr>
							<th>Question</th>
							<th>Answer</th>
						</tr>
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
                  <table>
                  		<tr>
                  			<td>
                  				<c:choose>
                  					<c:when test="${dentalhis.fluoride_treatment=='true'}"><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/></c:when>
                  					<c:otherwise><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox.png"/></c:otherwise>
                  				</c:choose>
                  			</td>
                  			<td>Fluoride Treatment</td>
                  		</tr>
                  		<tr>
                  			<td>
                  				<c:choose>
                  					<c:when test="${dentalhis.orthodontic_treatment=='true'}"><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/></c:when>
                  					<c:otherwise><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox.png"/></c:otherwise>
                  				</c:choose>
                  			</td>
                  			<td>Orthodontic Treatment</td>
                  		</tr>
                  		<tr>
                  			<td>
                  				<c:choose>
                  					<c:when test="${dentalhis.pulp_therapy=='true'}"><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/></c:when>
                  					<c:otherwise><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox.png"/></c:otherwise>
                  				</c:choose>
                  			</td>
                  			<td>Pulp Therapy</td>
                  		</tr>
                  		<tr>
                  			<td>
                  				<c:choose>
                  					<c:when test="${dentalhis.temporo_mandibular=='true'}"><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/></c:when>
                  					<c:otherwise><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox.png"/></c:otherwise>
                  				</c:choose>
                  			</td>
                  			<td>Temporo Mandibular</td>
                  		</tr>
                  		<tr>
                  			<td>
                  				<c:choose>
                  					<c:when test="${dentalhis.periodontal_therapy=='true'}"><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/></c:when>
                  					<c:otherwise><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox.png"/></c:otherwise>
                  				</c:choose>
                  			</td>
                  			<td>Periodontal Therapy</td>
                  		</tr>
                  		<tr>
                  			<td>
                  				<c:choose>
                  					<c:when test="${dentalhis.dental_surgery=='true'}"><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/></c:when>
                  					<c:otherwise><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox.png"/></c:otherwise>
                  				</c:choose>
                  			</td>
                  			<td>Dental Surgery</td>
                  		</tr>
                  		<tr>
                  			<td>
                  				<c:choose>
                  					<c:when test="${dentalhis.extraction=='true'}"><img alt="" src="${pageContext.request.contextPath}/resources/images/checkbox2.png"/></c:when>
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
            </div>
			<div id="treatment_plan_div">
				<table>
					<tr>
						<th>Treatment Date</th>
						<th>Treatment</th>
						<th>Treatment Fee</th>
						<th>Alternative Treatment</th>
						<th>Alternative Treatment Fee</th>
					</tr>
					<c:forEach var="treatmentplan" items="${treatmentPlanList}">
					<tr>
						<td><fmt:formatDate value="${treatmentplan.treatment_date}" pattern="yyyy-MM-dd" /></td>
						<td><c:out value="${treatmentplan.treatment}" /></td>
						<td><fmt:formatNumber value="${treatmentplan.treatment_fee}" type="currency" currencySymbol="" /></td>
						<td><c:out value="${treatmentplan.alternative_treatment}" /></td>
						<td><fmt:formatNumber value="${treatmentplan.alternative_treatment_fee}" type="currency" currencySymbol="" /></td>
					</tr>
					</c:forEach>
				</table>
	        </div>
		</div>
		
		<div id="view_patient_controllers">			
        	<c:if test="${user.access==1 || user.access==2}">
				<c:if test="${isNewUser==false}">
					<label id="" class="button mouseout_button" onClick="buttonNextPage('#edit_record_div')">Edit Medical Record</label>
				</c:if>
				<c:if test="${isNewUser==true}">
					<label id="" class="button mouseout_button" onClick="buttonNextPage('#add_record_div')">Add Medical Record</label>
				</c:if>
				<label id="" class="button mouseout_button" onClick="buttonNextPage('#add_treatment_plan')">Add Treatment Plan</label>
	            <label id="" class="button mouseout_button" onClick="buttonNextPage('#edit_treatment_plan')">Edit Treatment Plan</label>
	            <label id="" class="button mouseout_button" onClick="buttonNextPage('${pageContext.request.contextPath}/treatment_record/view')">Treatment Record</label>
			</c:if>
		</div>
        
        <jsp:include page="add_treatment_plan.jsp"/>
		<jsp:include page="edit_treatment_plan.jsp"/>
		
	</body>
</html>
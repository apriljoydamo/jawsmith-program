<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Beauteethful</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
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
		
		
			<div id="patient_medical_info">
				<form action="${pageContext.request.contextPath}/patient/add_record/done" method="POST">
				<input type="hidden" name="patient_id" value="${patient.patient_id}" /> 
				<!-- MEDICAL HISTORY 
					 * If this does not work out, we may have to redesign medical_history table.
				-->
				<div id="medical_his_div">
				<h3>Medical History</h3>
					<c:forEach var="tbl_med_his" items="medHisQuestionList" >
					<table>
						<tr><td>Question: ${tbl_med_his.tbl_maintenance_description}
								<input type="hidden" value="${tbl_med_his.code_table_value}" name="question" />
						</td></tr>
						<tr><td>
								<c:if test="${tbl_med_his.code_table_value=='2'}">
									<tr><td>Physical Ailments:</td></tr>
									<c:forEach var="tbl_physical" items="physicalAilmentList">
										<tr><td>Physical Ailments:</td></tr>
										<tr><td>${tbl_physical.tbl_maintenance_description}</td></tr>
									</c:forEach>
								</c:if>
							</td>
						</tr>
						<tr><td><input type="text" name="answer" /></td></tr>
					</table>
					</c:forEach>
					<!-- 
					<form action="${pageContext.request.contextPath}/medical_history/add" method="POST">
					<input type="hidden" name="patient_id" value="${patient.patient_id}" /> 
					<input type="submit" value="Save"/>
					</form>
					-->
				</div>
				
				
				<!-- DENTAL HISTORY -->
				<div id="dental_his_div">
				<h3>Dental History</h3>
					<input type="checkbox" name="fluoride_treatment" value="true">Fluoride Treatment<br>
					<input type="checkbox" name="orthodontic_treatment" value="true">Orthodontic Treatment<br>
					<input type="checkbox" name="pulp_therapy" value="true">Pulp Therapy<br>
					<input type="checkbox" name="temporo_mandibular" value="true">Temporo Mandibular<br>
					<input type="checkbox" name="periodontal_therapy" value="true">Periodontal Therapy<br>
					<input type="checkbox" name="dental_surgery" value="true">Dental Surgery<br>
					<input type="checkbox" name="extraction" value="true">Extraction<br>
					<!-- 
					<form action="${pageContext.request.contextPath}/dental_history/add" method="POST">
						<input type="hidden" name="patient_id" value="${patient.patient_id}" />
						<input type="submit" value="Save"/>
					</form>
					 -->
				</div>
				
				<!-- CLINICAL EXAM -->
				<div id="clinic_exam_div">
				<h3>Clinical Examination</h3>
					<table>
						<tr>
							<td>Gingival Color</td>
							<td><input type="radio" name="gingival_color" value="pink" />pink</td>
							<td><input type="radio" name="gingival_color" value="bright red" />bright red</td>
							<td><input type="radio" name="gingival_color" value="pale" >pale</td>
						</tr>
						<tr>
							<td>Consistency of gingival</td>
							<td><input type="radio" name="consistency_of_gingival" value="firm" />firm</td>
							<td><input type="radio" name="consistency_of_gingival" value="hyperplastic" />hyperplastic</td>
							<td><input type="radio" name="consistency_of_gingival" value="smooth" />smooth</td>
						</tr>
						<tr>
							<td>Tounge</td>
							<td><input type="radio" name="tounge" value="normal" />normal</td>
							<td><input type="radio" name="tounge" value="coated" />coated</td>
							<td></td>
						</tr>
						<tr>
							<td>Oral Hygiene</td>
							<td><input type="radio" name="oral_hygiene" value="good" />good</td>
							<td><input type="radio" name="oral_hygiene" value="fair" />fair</td>
							<td><input type="radio" name="oral_hygiene" value="bad" />bad</td>
						</tr>
						<tr>
							<td>Lymph Nodes</td>
							<td><input type="radio" name="lymph_nodes" value="not palpable" />not palpable</td>
							<td><input type="radio" name="lymph_nodes" value="palpable" />palpable</td>
							<td></td>
						</tr>
					</table>
					<!-- 
					<form action="${pageContext.request.contextPath}/clinical_examination/add" method="POST">
					<input type="hidden" name="patient_id" value="${patient.patient_id}" />
					<input type="submit" value="Save"/>
					</form>
					-->
				</div>
				
				<!-- OCCLUSION -->
				<div id="occlusion_div">
				<h3>Occlusion</h3>
					<table>
						<tr>
							<td>Class I</td>
							<td>div: <input type="text" name="class_1" /></td>
						</tr>
						<tr>
							<td>Class II</td>
							<td>div: <input type="text" name="class_2" /></td>
						</tr>
						<tr>
							<td>Class III</td>
							<td>div: <input type="text" name="class_3" /></td>
						</tr>
					</table>
					<!-- 
					<form action="${pageContext.request.contextPath}/occlusion/add" method="POST">
					<input type="hidden" name="patient_id" value="${patient.patient_id}" />
					<input type="submit" value="Save"/>
					</form>
					-->
				</div>
				
				<!-- ANXILLARIES -->
				<div id="anxillaries_div">
				<h3>Anxillaries</h3>
					<table>
						<tr>
							<td>Bleeding Time</td>
							<td><input type="text" name="bleeding_time" /></td>
						</tr>
						<tr>
							<td>Blood Pressure</td>
							<td><input type="text" name="blood_pressure" /></td>
						</tr>
						<tr>
							<td>Radiographic Interpretation</td>
							<td><input type="text" name="radiographic_interpretation" /></td>
						</tr>
						<tr>
							<td>Clotting Time</td>
							<td><input type="text" name="clotting_time" /></td>
						</tr>
						<tr>
							<td>Blood Sugar</td>
							<td><input type="text" name="blood_sugar" /></td>
						</tr>
					</table>
					
					<!--<form action="${pageContext.request.contextPath}/anxillaries/add" method="POST">
					<input type="hidden" name="patient_id" value="${patient.patient_id}" />
					<input type="submit" value="Save"/>
					</form>
					-->
				</div>
				
				<!-- OTHER INFORMATION-->
				<div id="other_info_div">
					<h3>Other Information</h3>
					<table>
						<tr>
							<td>Chief Complaint</td>
							<td><input type="text" name="chief_complaint" /></td>
						</tr>
						<tr>
							<td>Diagnosis</td>
							<td><input type="text" name="diagnosis" /></td>
						</tr>
					</table>
					<!--<form action="${pageContext.request.contextPath}/other_information/add" method="POST">
					<input type="hidden" name="patient_id" value="${patient.patient_id}" />
					<input type="submit" value="Save"/>
					</form>
					-->
				</div>
				
				<!-- TREATMENT PLAN -->
				<div id="treatment_plan_div">
				<h3>Treatment Plan</h3>
				<table>
						<tr>
							<td>Treatment:</td>
							<td><input type="text" name="treatment" /></td>
							<td>Treatment Fee:</td>
							<td><input type="text" name="treatment_fee" /></td>	
						</tr>
						<tr>
							<td>Alternative Treatment:</td>
							<td><input type="text" name="alternative_treatment" /></td>
							<td>Alternative Treatment Fee:</td>
							<td><input type="text" name="alternative_treatment_fee" /></td>	
						</tr>
					</table>
					<!--<form action="${pageContext.request.contextPath}/treatment_plan/add" method="POST">
					<input type="hidden" name="patient_id" value="${patient.patient_id}" />
					<input type="submit" value="Save"/>
					</form>
					-->
				</div>
				
				<input type="submit" value="Save"/>
			</form>
			</div>
	</body>
</html>
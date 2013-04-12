<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<div id="edit_record_div" name="edit_record_div" class="modalDialog">
   	<div name="add_record_div_form" id="add_record_div_form"> 
	<a id="close_add_record" href="#close" class="close_add_record close" title="">X</a>	
   	
   	<form id="edit_record_form" action="${pageContext.request.contextPath}/patient/edit_record" method="POST">
	<h3>EDIT MEDICAL RECORDS</h3>
	<!-- MEDICAL HISTORY -->
	<div id="medical_his_div">
		<table>
			<c:forEach var="tbl_med_his" items="${medHisQuestionList}" >
			<tr><td>Question: ${tbl_med_his.tbl_maintenance_description}
					<input type="hidden" value="${tbl_med_his.tbl_maintenance_description}" name="question" />
			</td></tr>
			<c:choose>
				<c:when test="${tbl_med_his.code_table_value=='2'}">
					<tr><td>Physical Ailments:</td></tr>
					<c:forEach var="tbl_physical" items="${physicalAilmentList}">
						<tr><td><input type="checkbox" name="physical_ailments" value="${tbl_physical.tbl_maintenance_description}" ${fn:contains(answer2, tbl_physical.tbl_maintenance_description) ? 'checked' : ''} > ${tbl_physical.tbl_maintenance_description}</td></tr>
					</c:forEach>
				</c:when>
				<c:when test="${tbl_med_his.code_table_value=='8' && patient.sex=='M'}">
					<tr><td><input type="text" disabled="disabled" name="answer" /></td></tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="medhis" items="${latestMedHisList}">
						<c:if test="${medhis.question_id==tbl_med_his.tbl_maintenance_description}">
						<tr><td><input type="text" name="answer" value="${medhis.answer}"/></td></tr>
						</c:if>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		</table>
	</div>
	
	
	<!-- DENTAL HISTORY -->
	<div id="dental_his_div">
	<h3>Dental History</h3>
		<input type="checkbox" name="fluoride_treatment" value="true" ${dentalhis.fluoride_treatment=='true' ? 'checked' :''} />Fluoride Treatment<br>
		<input type="checkbox" name="orthodontic_treatment" value="true" ${dentalhis.orthodontic_treatment=='true' ? 'checked' :''} />Orthodontic Treatment<br>
		<input type="checkbox" name="pulp_therapy" value="true" ${dentalhis.pulp_therapy=='true' ? 'checked' :''} />Pulp Therapy<br>
		<input type="checkbox" name="temporo_mandibular" value="true" ${dentalhis.temporo_mandibular=='true' ? 'checked' :''} />Temporo Mandibular<br>
		<input type="checkbox" name="periodontal_therapy" value="true" ${dentalhis.periodontal_therapy=='true' ? 'checked' :''} />Periodontal Therapy<br>
		<input type="checkbox" name="dental_surgery" value="true" ${dentalhis.dental_surgery=='true' ? 'checked' :''} />Dental Surgery<br>
		<input type="checkbox" name="extraction"  value="true" ${dentalhis.extraction=='true' ? 'checked' :''} />Extraction<br>
	</div>
	
	<!-- CLINICAL EXAM -->
	<div id="clinic_exam_div">
	<h3>Clinical Examination</h3>
		<table>
			<tr>
				<td>Gingival Color</td>
				<td><input type="radio" name="gingival_color" value="pink" ${clinical.gingival_color=='pink' ? 'checked' : ''} />pink</td>
				<td><input type="radio" name="gingival_color" value="bright red" ${clinical.gingival_color=='bright red' ? 'checked' :''} />bright red</td>
				<td><input type="radio" name="gingival_color" value="pale" ${clinical.gingival_color=='pale' ? 'checked' :''} />pale</td>
			</tr>
			
			<tr>
				<td>Consistency of gingival</td>
				<td><input type="radio" name="consistency_of_gingival" value="firm" ${clinical.consistency_of_gingival=='firm' ? 'checked' :''} />firm</td>
				<td><input type="radio" name="consistency_of_gingival" value="hyperplastic" ${clinical.consistency_of_gingival=='hyperplastic' ? 'checked' :''} />hyperplastic</td>
				<td><input type="radio" name="consistency_of_gingival" value="smooth" ${clinical.consistency_of_gingival=='smooth' ? 'checked' :''} />smooth</td>
			</tr>
			<tr>
				<td>Tounge</td>
				<td><input type="radio" name="tounge" value="normal" ${clinical.tounge=='normal' ? 'checked' :''} />normal</td>
				<td><input type="radio" name="tounge" value="coated" ${clinical.tounge=='coated' ? 'checked' :''} />coated</td>
				<td></td>
			</tr>
			<tr>
				<td>Oral Hygiene</td>
				<td><input type="radio" name="oral_hygiene" value="good" ${clinical.oral_hygiene=='good' ? 'checked' :''} />good</td>
				<td><input type="radio" name="oral_hygiene" value="fair" ${clinical.oral_hygiene=='fair' ? 'checked' :''} />fair</td>
				<td><input type="radio" name="oral_hygiene" value="bad" ${clinical.oral_hygiene=='bad' ? 'checked' :''} />bad</td>
			</tr>
			<tr>
				<td>Lymph Nodes</td>
				<td><input type="radio" name="lymph_nodes" value="not palpable" ${clinical.lymph_nodes=='not palpable' ? 'checked' :''} />not palpable</td>
				<td><input type="radio" name="lymph_nodes" value="palpable" ${clinical.lymph_nodes=='palpable' ? 'checked' :''} />palpable</td>
				<td></td>
			</tr>
		</table>
	</div>
	
	<!-- OCCLUSION -->
	<div id="occlusion_div">
	<h3>Occlusion</h3>
		<table>
			<tr>
				<td>Class I</td>
				<td>div: <input type="text" name="class_1" value="${occlusion.class_1}"/></td>
			</tr>
			<tr>
				<td>Class II</td>
				<td>div: <input type="text" name="class_2" value="${occlusion.class_2}"/></td>
			</tr>
			<tr>
				<td>Class III</td>
				<td>div: <input type="text" name="class_3" value="${occlusion.class_3}"/></td>
			</tr>
		</table>
	</div>
	
	<!-- ANXILLARIES -->
	<div id="anxillaries_div">
	<h3>Anxillaries</h3>
		<table>
			<tr>
				<td>Bleeding Time</td>
				<td><input type="text" name="bleeding_time" value="${anxillaries.bleeding_time}"/></td>
			</tr>
			<tr>
				<td>Blood Pressure</td>
				<td><input type="text" name="blood_pressure" value="${anxillaries.blood_pressure}"/></td>
			</tr>
			<tr>
				<td>Radiographic Interpretation</td>
				<td><input type="text" name="radiographic_interpretation" value="${anxillaries.radiographic_interpretation}"/></td>
			</tr>
			<tr>
				<td>Clotting Time</td>
				<td><input type="text" name="clotting_time" value="${anxillaries.clotting_time}"/></td>
			</tr>
			<tr>
				<td>Blood Sugar</td>
				<td><input type="text" name="blood_sugar" value="${anxillaries.blood_sugar}"/></td>
			</tr>
		</table>
	</div>
	
	<!-- OTHER INFORMATION-->
	<div id="other_info_div">
		<h3>Other Information</h3>
		<table>
			<tr>
				<td>Chief Complaint</td>
				<td><input type="text" name="chief_complaint" value="${other.chief_complaint}"/></td>
			</tr>
			<tr>
				<td>Diagnosis</td>
				<td><input type="text" name="diagnosis" value="${other.diagnosis}"/></td>
			</tr>
		</table>
	</div>
	<label id="" class="button mouseout_button" onClick="submitForm('edit_record_form')">Save</label>
	</form>
	</div>
</div>
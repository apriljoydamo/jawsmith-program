<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div id="add_record_div" name="add_record_div" class="modalDialog">
	     	<div name="add_record_div_form" id="add_record_div_form"> 
				<a id="close_add_record" href="#close" class="close_add_record close" title="">X</a>	
	     		<form id="add_record_form" action="${pageContext.request.contextPath}/patient/add_record" method="POST">
				<input type="hidden" name="patient_id" value="${patient.patient_id}" /> 
				
				<!-- MEDICAL HISTORY -->
				<div id="medical_his_div">
				<h3>Medical History</h3>
					<c:forEach var="tbl_med_his" items="${medHisQuestionList}" >
					<table>
						<tr><td>Question: ${tbl_med_his.tbl_maintenance_description}
								<input type="hidden" value="${tbl_med_his.code_table_value}" name="question" />
						</td></tr>
						<c:choose>
							<c:when test="${tbl_med_his.code_table_value=='2'}">
								<tr><td>Physical Ailments:</td></tr>
								<c:forEach var="tbl_physical" items="${physicalAilmentList}">
									<tr><td><input type="checkbox" name="physical_ailments" value="${tbl_physical.code_table_value}"> ${tbl_physical.tbl_maintenance_description}</td></tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr><td><input type="text" name="answer" /></td></tr>
							</c:otherwise>
						</c:choose>
					</table>
					</c:forEach>
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
				</div>
				
				<label id="" class="button mouseout_button" onClick="submitForm('add_record_form')">Save</label>
			</form>
			</div>
</div>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<div id="edit_treatment_record_div" class="modalDialog">
	<div id="edit_treatment_record">
		<a href="#close" class="close_add_treat close">X</a>
		<h3>TREATMENT RECORD</h3>
		<form action="${pageContext.request.contextPath}/treatment_record/edit"
			method="POST">
			<input type="hidden" value="${selectedTreatmentRecord.treatment_record_id}" name="treatment_record_id" />
			<table>
				<tr>
					<td>Tooth No.:</td>
					<td><c:out value="${selectedTreatmentRecord.tooth_number}" />
					</td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><c:out value="${selectedTreatmentRecord.description}" />
					</td>
				</tr>
				<tr>
					<td>Prescription:</td>
					<td><c:out value="${selectedTreatmentRecord.prescription}" />
					</td>
				</tr>
				<tr>
					<td>Debit:</td>
					<td><c:out value="${selectedTreatmentRecord.debit}" />
					</td>
				</tr>
				<tr>
					<td>Credit Date:</td>
					<td><c:out value="${selectedTreatmentRecord.credit_date}"/>
					</td>
				</tr>
				<tr>
					<td>Credit Amount:</td>
					<td><c:out value="${selectedTreatmentRecord.credit_amount}" />
					</td>
				</tr>
				<tr>
					<td>NOTE/S:</td>
					<td><textarea name="description_notes">${selectedTreatmentRecord.description_notes}</textarea>
					</td>
				</tr>
			</table>
			<input type="submit" value="Save" />
		</form>
	</div>
</div>
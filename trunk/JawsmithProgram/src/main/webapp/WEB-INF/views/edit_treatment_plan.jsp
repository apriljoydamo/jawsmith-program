<div id="edit_treatment_plan_div" class="modalDialog">
	<div id="edit_treatment_panel">
		<a href="#close" class="close_add_treat close">X</a>
		<h1>EDIT TREATMENT PLAN</h1>
		<form id="editRecord" action="${pageContext.request.contextPath}/treatment_plan/edit"	method="POST">
			<input type="hidden" name="treatment_plan_id" value="${selectedTreatmentPlan.treatment_plan_id}" />
			<table>
				<tr>
					<td>Treatment:</td>
					<td><input type="text" name="treatment"
						value="${selectedTreatmentPlan.treatment}" /></td>
					<td><input type="text" name="treatment_fee"
						value="${selectedTreatmentPlan.treatment_fee}" />
					</td>
				</tr>
				<tr>
					<td>Alternate Treatment:</td>
					<td><input type="text" name="alternative_treatment"
						value="${selectedTreatmentPlan.alternative_treatment}" />
					</td>
					<td><input type="text" name="alternative_treatment_fee"
						value="${selectedTreatmentPlan.alternative_treatment_fee}" />
					</td>
				</tr>
			</table>
			<label id="" class="button mouseout_button"
				onClick="submitForm('editRecord')">Edit Treatment Plan</label>
		</form>
	</div>
</div>
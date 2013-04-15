<div id="add_treatment_plan" class="modalDialog">
	<div id="add_treatment_panel">
		<a href="#close" class="close_add_treat close">X</a>
		<h1>ADD TREATMENT PLAN</h1>
		<form id="treatmentPlan_add"
			action="${pageContext.request.contextPath}/treatment_plan/add"
			method="POST">
			<table>
				<tr>
					<td>Treatment:</td>
					<td><input type="text" id="treatmentPlan_add_treatment" name="treatment" value="" /></td>
					<td><input type="text" id="treatmentPlan_add_treatmentFee" name="treatment_fee" placeholder="Fee" />
					</td>
				</tr>
				<tr>
					<td>Alternate Treatment:</td>
					<td><input type="text" id="treatmentPlan_add_alternativeTreatment" name="alternative_treatment" value="" />
					</td>
					<td><input type="text" id="treatmentPlan_add_alternativeTreatmentFee" name="alternative_treatment_fee"
placeholder="Fee" />
					</td>
				</tr>
			</table>
		 <td><label id="save_button" class="button mouseout_button" onclick="validateTreatmentPlanAdd()">Save</label></td>
	        
		</form>
	</div>
</div>
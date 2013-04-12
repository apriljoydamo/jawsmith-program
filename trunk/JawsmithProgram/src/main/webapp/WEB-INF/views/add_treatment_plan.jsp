<div id="add_treatment_plan" class="modalDialog">
	<div id="add_treatment_panel">
		<a href="#close" class="close_add_treat close">X</a>
		<h1>ADD TREATMENT PLAN</h1>
		<form id="saveRecord"
			action="${pageContext.request.contextPath}/treatment_plan/add"
			method="POST">
			<table>
				<tr>
					<td>Treatment:</td>
					<td><input type="text" name="treatment" value="" /></td>
					<td><input type="text" name="treatment_fee" placeholder="Fee" />
					</td>
				</tr>
				<tr>
					<td>Alternate Treatment:</td>
					<td><input type="text" name="alternative_treatment" value="" />
					</td>
					<td><input type="text" name="alternative_treatment_fee"
						placeholder="Fee" />
					</td>
				</tr>
			</table>
			<label id="" class="button mouseout_button"
				onClick="submitForm('saveRecord')">Add Treatment Plan</label>
		</form>
	</div>
</div>
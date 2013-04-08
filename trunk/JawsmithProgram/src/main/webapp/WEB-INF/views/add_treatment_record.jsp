<div name="add_treatment_record_div" id="add_treatment_record_div" class="modalDialog">
	<div id="add_treatment_record">
		<a href="#close" class="close_add_treat close">X</a>
		<h3>TREATMENT RECORD</h3>
		<form action="${pageContext.request.contextPath}/treatment_record/add"
			method="POST">
			<table>
				<tr>
					<td>Tooth No.</td>
					<td><input type="text" name="tooth_number"></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text" name="description"></td>
				</tr>
				<tr>
					<td>Prescription</td>
					<td><input type="text" name="prescription"></td>
				</tr>
				<tr>
					<td>Debit</td>
					<td><input type="text" name="debit"></td>
				</tr>
				<tr>
					<td>Credit Date</td>
					<td><input type="text" name="credit_date" value="yyyy-MM-dd">
					</td>
				</tr>
				<tr>
					<td>Credit Amount</td>
					<td><input type="text" name="credit_amount"></td>
				</tr>
			</table>
			<input type="submit" value="Save" />
		</form>
	</div>
</div>
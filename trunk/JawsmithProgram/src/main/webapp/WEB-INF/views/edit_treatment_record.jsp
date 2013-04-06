<div id="edit_treatment_record_div" class="modalDialog">
	<div id="edit_treatment_record">
		<a href="#close" class="close_add_treat close">X</a>
		<h3>TREATMENT RECORD</h3>
		<form
			action="${pageContext.request.contextPath}/treatment_record/edit"
			method="POST">
			<table>
				<tr>
					<td>Tooth No.:</td>
					<td><input type="text" disabled="disabled" name="tooth_number"
						value="${treatment_rec.tooth_number}">
					</td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input type="text" disabled="disabled" name="description"
						value="${treatment_rec.description}">
					</td>
				</tr>
				<tr>
					<td>Prescription:</td>
					<td><input type="text" disabled="disabled" name="prescription"
						value="${treatment_rec.prescription}">
					</td>
				</tr>
				<tr>
					<td>Debit:</td>
					<td><input type="text" disabled="disabled" name="debit"
						value="<fmt:formatNumber value='${treatment_rec.debit}' type='currency' currencySymbol='' />" />
					</td>
				</tr>
				<tr>
					<td>Credit Date:</td>
					<td><input type="text" disabled="disabled" name="credit_date"
						value="<fmt:formatDate value='${treatment_rec.credit_date}' pattern='yyyy-MM-dd' />" />
					</td>
				</tr>
				<tr>
					<td>Credit Amount:</td>
					<td><input type="text" disabled="disabled"
						name="credit_amount"
						value="<fmt:formatNumber value='${treatment_rec.credit_amount}' type='currency' currencySymbol='' />" />
					</td>
				</tr>
				<tr>
					<td>NOTE/S:</td>
					<td><textarea type="text" name="desc_notes"></textarea>
					</td>
				</tr>
			</table>
			<input type="submit" value="Save" />
		</form>
	</div>
</div>
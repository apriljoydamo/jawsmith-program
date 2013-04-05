 
        <div id="add_treatment_plan" class="modalDialog">
		    <div id="add_treatment_panel">
		    <a href="#close" class="close_add_treat close">X</a>     
			<h1>ADD TREATMENT PLAN</h1>			
			<form id="saveRecord" action="${pageContext.request.contextPath}/treatment_plan/add" method="POST">
			         	<table>
			             <tr>
			             	<td>Treatment: </td>
			             	<td><input type="text" name="treatment" />	</td>
			             	<td>Treatment Fee: </td>
			             	<td><input type="text" name="treatment_fee" /></td>
			             </tr>
			             <tr>
			             	<td>Alternate Treatment: </td>
			             	<td><input type="text" name="alternative_treatment" /></td>
			             	<td>Alternative Treatment Fee: </td>
			             	<td><input type="text" name="alternative_treatment_fee" /></td>
			             </tr>
			             </table>
			             <label id="" class="button mouseout_button" onClick="submitForm('saveRecord')">Add Treatment Plan</label>
				</form>
			</div>
		</div>
		
		<div id="edit_treatment_plan" class="modalDialog">
		    <div id="add_treatment_panel">
		    <a href="#close" class="close_add_treat close">X</a>     
			<h1>EDIT TREATMENT PLAN</h1>			
			<form id="editRecord" action="${pageContext.request.contextPath}/treatment_plan/add" method="POST">
			         	<table>
			             <tr>
			             	<td>Treatment: </td>
			             	<td><input type="text" name="treatment" value="${treatmentplan.treatment}" /></td>
			             	<td>Treatment Fee: </td>
			             	<td><input type="text" name="treatment_fee" value="${treatmentplan.treatment_fee}" /></td>
			             </tr>
			             <tr>
			             	<td>Alternate Treatment: </td>
			             	<td><input type="text" name="alternative_treatment" value="${treatmentplan.alternative_treatment}" /></td>
			             	<td>Alternative Treatment Fee: </td>
			             	<td><input type="text" name="alternative_treatment_fee" value="${treatmentplan.alternative_treatment_fee}" /></td>
			             </tr>
			             </table>
			             <label id="" class="button mouseout_button" onClick="submitForm('editRecord')">Edit Treatment Plan</label>
				</form>
			</div>
		</div>
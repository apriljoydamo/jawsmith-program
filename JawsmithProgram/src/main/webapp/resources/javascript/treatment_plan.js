

function selectTreatmentPlan(id){
	//$("#user_id").val(id);
	//alert($("#patient_id").val());
	
	$("#treatment_plan_id_hidden").val(id);
	$("#treatment_plan_form_id").submit();
}

$(document).ready(function(e) {
	setButtons();    
	setHighlightRecords();
	
});
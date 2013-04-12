// JavaScript Document

function selectTreatmentRecord(id){
	//$("#user_id").val(id);
	//alert($("#patient_id").val());
	
	$("#treatment_record_id_hidden").val(id);
	$("#treatment_record_form_id").submit();
}

$(document).ready(function(e) {
	setButtons();    
	setHighlightRecords();
	
});
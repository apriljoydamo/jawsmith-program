

function selectUser(id){
	//$("#user_id").val(id);
	//alert($("#patient_id").val());
	
	$("#user_id_hidden").val(id);
	$("#user_form_id").submit();
}

function selectTblMaintenance(id){
	$("#tablem_id_hidden").val(id);
	$("#tablem_form_id").submit();
}


$(document).ready(function(e) {
	setButtons();    
	setHighlightRecords();
	
});
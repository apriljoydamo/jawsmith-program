

function selectTreatmentPlan(id){
	//$("#user_id").val(id);
	//alert($("#patient_id").val());
	
	$("#treatment_plan_id_hidden").val(id);
	$("#treatment_plan_form_id").submit();
}

function validateTreatmentPlanAdd(){
	var fields = new Array();
	var approved = true;
		
	//ADMIN TOOLS FIELDS
	fields.push($("#treatmentPlan_add_treatment"));		
	fields.push($("#treatmentPlan_add_treatmentFee"));

	//CHECK FOR EMPTY VALUES
	for(var x = 0 ; x<fields.length; x++){
		if($.trim(fields[x].val()) == "" || fields[x].val() == null){
		//alert(fields[x].parent().child().length);
			if ( fields[x].parent().children().length < 2 ) {
				fields[x].parent().append('<label id="asterisk" class="asterisk'+x+'">*</label>');
			}	
			approved = false;
		}else{
			$('.asterisk'+x).remove();
		}
	}
	
	if(!approved){
		alert("Please input values on all required fields");
		
	} else if(approved){
		$("#treatmentPlan_add").submit();
	}
}

$(document).ready(function(e) {
	setButtons();    
	setHighlightRecords();
	
});
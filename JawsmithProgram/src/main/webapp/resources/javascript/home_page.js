// JavaScript Document

function validatePatient(){
	var approved = true;
	var fields = new Array();

	
	//PATiENT NUM
	fields.push($("#add_patient_num"));
	
	//FIRST NAME
	fields.push($("#add_patient_first_name"));
	
	//MIDDLE NAME
	fields.push($("#add_patient_middle_name"));
	
	//LAST NAME
	fields.push($("#add_patient_last_name"));
	
	//DATE OF BIRTH
	fields.push($("#add_patient_date_of_birth"));
	
	//GET VALUE RADIO BUTTON
	//var selectedVal = "";
	fields.push($("input[type='radio'][name='add_patient_sex']:checked"));
	//if (selected.length > 0){
	//    selectedValue = selected.val();
	//}
	
	//MARITAL STATUS
	fields.push($("#add_patient_sex"));
	
	//MARITAL STATUS
	fields.push($("#add_patient_marital_status"));
	
	//POSTAL ADDRESS
	fields.push($("#add_patient_postal_address"));
	
	//HOME NO
	fields.push($("#add_patient_home_no"));
	
	//MOBILE NO
	fields.push($("#add_patient_mobile_no"));
	
	//EMAIL
	fields.push($("#add_patient_email"));
	
	//NATIONALITY
	fields.push($("#add_patient_nationality"));
	
	//OCCUPATION
	fields.push($("#add_patient_occupation"));
	
	//RELIGION
	fields.push($("#add_patient_religion"));
	
	//GUARDIAN
	fields.push($("#add_patient_guardian"));
	
	//REFERRED BY
	fields.push($("#add_patient_referred_by"));
	
	//STATUS
	//fields.push($("#add_patient_status"));
	
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
		alert("Please input on all required fields");
	} else if(approved){
		$("#add_patient_form").submit();
	}
}

function selectPatient(id){
	$("#patient_id").val(id);
	//alert($("#patient_id").val());
	
	$("#view_patient_form").submit();
}

$(document).ready(function(e) {
	$("#add_patient_date_of_birth").datepicker({
    	maxDate: new Date(),
    	inline: true,  
    	showOtherMonths: true,  
    	dayNamesMin: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
		changeYear: true,
		changeMonth: true		
	});
	
	setButtons();    
	setHighlightRecords();
	$("#plus_button").click(function(e) {
		buttonNextPage("#register_div");
    });
});
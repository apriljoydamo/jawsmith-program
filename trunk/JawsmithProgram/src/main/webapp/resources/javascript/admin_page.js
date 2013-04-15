

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

function validateAdminAddUser(){
	var fields = new Array();
	var approved = true;
		
	//ADMIN TOOLS FIELDS
	fields.push($("#admin_add_username"));		
	fields.push($("#admin_add_password"));
	fields.push($("#admin_add_firstname"));
	fields.push($("#admin_add_lastname"));

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
		$("#admin_add_users").submit();
	}
}

function validateAdminEditUser(){
	var fields = new Array();
	var approved = true;
		
	//ADMIN TOOLS FIELDS
	fields.push($("#admin_edit_username"));		
	fields.push($("#admin_edit_password"));
	fields.push($("#admin_edit_firstname"));
	fields.push($("#admin_edit_lastname"));

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
			$("#admin_edit_users").submit();
	}
}

function validateAdminAddTable(){
	var fields = new Array();
	var approved = true;
		
	//ADMIN TOOLS FIELDS
	fields.push($("#admin_add_codevalue"));		
	fields.push($("#admin_add_codedesc"));

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
		$("#admin_add_codevalues").submit();
	}
}

function validateAdminEditTable(){
	var fields = new Array();
	var approved = true;
		
	//ADMIN TOOLS FIELDS
	fields.push($("#admin_edit_codevalue"));		
	fields.push($("#admin_edit_codedesc"));

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
		$("#admin_edit_codevalues").submit();
	}
}

$(document).ready(function(e) {
	setButtons();    
	setHighlightRecords();
	
});

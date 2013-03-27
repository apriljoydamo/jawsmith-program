// JavaScript Document

//CHANGE URL
////document.location.href = newUrl;

function setHighlightRecords(){
	$(".patient_records").mousedown(function() {        
		$(this).attr("class", "patient_records record_mouseclick_button");
    });
	$(".patient_records").mouseout(function() {        
		$(this).attr("class", "patient_records record_mouseout_button");
    });
	$(".patient_records").mouseup(function() {        
		$(this).attr("class", "patient_records record_mouseover_button");
    });
	$(".patient_records").mouseover(function() {        
		$(this).attr("class", "patient_records record_mouseover_button");
    });

}

function buttonNextPage(nextPage){
	document.location.href = nextPage;
}

function submitForm(formToSubmit){
	$("form#"+formToSubmit).submit(); 
}

function setButtons(){
	$(".button").mousedown(function() {        
		$(this).attr("class", "button mouseclick_button");
    });
	$(".button").mouseout(function() {        
		$(this).attr("class", "button mouseout_button");
    });
	$(".button").mouseup(function() {        
		$(this).attr("class", "button mouseover_button");
    });
	$(".button").mouseover(function() {        
		$(this).attr("class", "button mouseover_button");
    });
}
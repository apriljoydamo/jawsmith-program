// JavaScript Document

function setAccordion(){
	$(".patient_medical_info").mousedown(function() {        
		$(this).attr("class", "patient_medical_info patient_medical_info_mouseclick");
    });
	$(".patient_medical_info").mouseout(function() {        
		$(this).attr("class", "patient_medical_info patient_medical_info_mouseout");
    });
	$(".patient_medical_info").mouseup(function() {        
		$(this).attr("class", "patient_medical_info patient_medical_info_mouseout");
    });
	$(".patient_medical_info").mouseover(function() {        
		$(this).attr("class", "patient_medical_info patient_medical_info_mouseover");
    });
}

$(document).ready(function() {
    setButtons();
	$("#patient_medical_info").accordion();
	setAccordion();;
	
});
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

	$("#dd11").slideUp();
	$("#dd22").slideUp();
	$("#dd33").slideUp();
	$("#dd44").slideUp();
	$("#dd55").slideUp();
	$("#dd66").slideUp();
	$("#dd77").slideUp();

    $("#hh11").click(function(){
    	$("#dd11").slideToggle();
    });
    $("#hh22").click(function(){
    	$("#dd22").slideToggle();
    });
    $("#hh33").click(function(){
    	$("#dd33").slideToggle();
    });
    $("#hh44").click(function(){
    	$("#dd44").slideToggle();
    });
    $("#hh55").click(function(){
    	$("#dd55").slideToggle();
    });
    $("#hh66").click(function(){
    	$("#dd66").slideToggle();
    });
    $("#hh77").click(function(){
    	$("#dd77").slideToggle();
    });
    //$("#patient_medical_info").accordion();
	setAccordion();;
	
});
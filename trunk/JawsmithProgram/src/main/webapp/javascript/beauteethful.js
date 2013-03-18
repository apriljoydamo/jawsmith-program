function setSubmitButton(){
	$("#submit_button").mousedown(function() {        
		$(this).attr("class", "submit_button mouseclick_button");
    });
	$("#submit_button").mouseout(function() {        
		$(this).attr("class", "submit_button mouseout_button");
    });
	$("#submit_button").mouseup(function() {        
		$(this).attr("class", "submit_button mouseover_button");
    });
	$("#submit_button").mouseover(function() {        
		$(this).attr("class", "submit_button mouseover_button");
    });
}

$(document).ready(function(e) {
	setSubmitButton();    
});
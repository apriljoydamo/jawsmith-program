// JavaScript Document
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



$(document).ready(function(e) {
	setButtons();    
	$("#plus_button").click(function(e) {
        document.location.href = "#register_div";
    });
});
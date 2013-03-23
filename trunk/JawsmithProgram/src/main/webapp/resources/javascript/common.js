// JavaScript Document

//CHANGE URL
////document.location.href = newUrl;


function buttonNextPage(nextPage){
	alert(nextPage);
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
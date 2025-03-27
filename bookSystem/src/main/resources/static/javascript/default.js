/*
 *   default.js 
   
 */

$(function(){  //windos.onload=function(){}
	
	$("#menuToggle").click(function(){ //document.getElementsByClassName("menuShow")[0].addEventListener("click", onButtonClick); 이거랑 같음
	    $(".menushow").toggle();
		$(".menuHide").toggle();
		var left = $("#userBox").css("left");
	
		left = Math.abs(parseInt(left));
		console.log(left);
		$("#userBox").css("left", (left-125)+"px");		
		
		
	});
	



})

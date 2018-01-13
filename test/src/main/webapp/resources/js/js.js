$(function(){
	//testaaa();
	
//	//$(".sleBtn1 .sleBtn2").click(function(){
//	//$("#sleBtn1 #sleBtn2").click(function(){
//	$("#sleBtn1").click(function(){
//		//var result;
//		//var result = "";
//		alert(typeof($(this)));
//		var btnType = $(this).attr("btnType");
//		alert("btnType:"+btnType);
//		var result = null;
//		alert("result:"+result);
//		if(result){
//			alert("来自js.jsp页面的testImport()方法");
//		}
//	})
	
	$(document).on("click", ".sleBtn1_test, .sleBtn2_test",function(){
		//var result;
		//var result = "";
		alert(typeof($(this)));
		var btnType = $(this).attr("btnType");
		alert("btnType:"+btnType);
		var result = null;
		alert("result:"+result);
		if(result){
			alert("来自js.jsp页面的testImport()方法");
		}
	})
	
})
//此种方式$(this)不生效
function testaaa(){
	//var result;
	//var result = "";
	var btnType = $(this).attr("btnType");
	alert("btnType:"+btnType);
	var result = null;
	alert("result:"+result);
	if(result){
		alert("来自js.jsp页面的testImport()方法");
	}
}

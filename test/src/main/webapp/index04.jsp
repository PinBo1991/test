<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="resources/form/jquery.form.js"></script>
</head>
<body>
	<script type="text/javascript">
		$(function() {
			$("#sleBtn").click(function() {
				$("#sle").append("<option value=\"1\">1</option>");
				$("#sle").append("<option value=\"2\">2</option>");
				$("#sle").append("<option value=\"3\">3</option>");
				alert("=======");
				$("#sle").val(1);
			})
		})
	</script>
	<select name="sle" id="sle">
		<!-- 		
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		-->
	</select>

	<input type="button" id="sleBtn" value="testSleVal">

</body>
</html>
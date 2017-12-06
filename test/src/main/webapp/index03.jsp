<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
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
		
		$(function(){
			$("#importBtn").click(function(){
				alert("来自index03页面");
				testImport();
			})
		})
	</script>
	 <div> 
		<jsp:include page="js.jsp" flush="true"/>
	 </div>
	<input type="button" id="importBtn" value="测试引入">
</body>
</html>
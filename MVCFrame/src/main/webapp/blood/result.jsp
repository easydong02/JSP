<%@page import="com.koreait.mvc.model.blood.BloodManager"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	
	String result= (String)request.getAttribute("result");
	out.print(result);
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Param1</title>
</head>
<body>
<jsp:include page="actionParam2.jsp">
	<jsp:param name="date" value="<%=new java.util.Date() %>"/>
</jsp:include>
</body>
</html>
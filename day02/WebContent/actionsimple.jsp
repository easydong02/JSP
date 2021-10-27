<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% request.setCharacterEncoding("UTF-8"); %>

<jsp:include page="./include/inc_act_simple.jsp">
	<jsp:param name="para1" value="p1값"/>
	<jsp:param name="para2" value="p2값"/>
	<jsp:param name="para3" value="파라미터3값"/>
</jsp:include>

</body>
</html>


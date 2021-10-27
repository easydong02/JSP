<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<%
session.setAttribute("id", "admin");
session.setAttribute("name", "고길동");


out.print("세션 설정 끝");
%>

<p><a href="sessionCheck.jsp">[세션 정보 확인]</a></p>


</body>
</html>
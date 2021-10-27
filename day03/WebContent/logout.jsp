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
	session.invalidate();
	out.print("로그 아웃 하셨습니다.");
	

%>

<a href="./loginForm.jsp">[세션 삭제 확인]</a>
</body>
</html>
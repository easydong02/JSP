<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
   
   
<%@ page import="java.lang.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 기본 구조 page structure</title>
</head>
<body>
	<h3>JSP 페이지 기본 구조</h3>
	
	
	<%-- 주석문 comment--%>
	
	<%! //선언문 declaration %>
	
	<% //스크립트릿 scriptlet
	
		String a= "지역변수";
	
	
	
	%>
	
	표현식 expression <%= a %>
	
</body>
</html>
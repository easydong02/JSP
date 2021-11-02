<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
String str= "<p align = center><br>로그 아웃 완료  <br><br>";
str += "<a href ='login.html'<button>로그인하기</button></a></p>";
out.print(str);





%>
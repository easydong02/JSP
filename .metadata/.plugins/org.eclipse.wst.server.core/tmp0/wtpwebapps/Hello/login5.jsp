<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("id");
	String res = "<h3>사용자 아이디 : " + uid + "</h3>";
	out.print(res);
	
%>
<%@ include file = "loginTime.jsp" %>

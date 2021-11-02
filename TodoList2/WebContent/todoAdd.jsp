<%@page import="dao.TodoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%
	request.setCharacterEncoding("utf-8");

	String todo = request.getParameter("todo");
	
	TodoDAO dao = new TodoDAO();
	
	if (dao.insert(todo)) {
		response.sendRedirect("main.jsp");
	}else {
		out.print("오류 발생");
	}
	
	
	
%>

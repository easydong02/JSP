<%@page import="dao.TodoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       
<%
	String no = request.getParameter("no");

	TodoDAO dao = new TodoDAO();
	
	if (dao.del(no)) {
		response.sendRedirect("main.jsp");
	}else {
		out.print("오류 발생");
	}

%>
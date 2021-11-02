<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="dao.*" %>    

<%
	request.setCharacterEncoding("utf-8");
	String utodo = request.getParameter("todo");

	TodoDAO dao = new TodoDAO();


	if(dao.insert(utodo)){
		response.sendRedirect("main.jsp");
	}else{
		out.print("실패");
	}




%>
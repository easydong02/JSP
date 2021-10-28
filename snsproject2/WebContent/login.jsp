<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.UserDAO" %>


<%
	request.setCharacterEncoding("utf-8");

	String uid = request.getParameter("id");
	String upass = request.getParameter("pw");
	String uname = request.getParameter("name");
	
	UserDAO dao = new UserDAO();
	
	int code =dao.login(uid,upass);
	if(code ==1){
		out.print("아이디가 존재하지 않습니다.");
		response.sendRedirect("login.html");
	}else if(code==2){
		out.print("비밀번호가 일치하지 않습니다.");
		response.sendRedirect("login.html");
	}else{
		session.setAttribute("id", uid);
		response.sendRedirect("main.jsp");
	}








%>
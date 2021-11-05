<%@page import="dao.MemberDAO"%>
<%@page import="util.ConnectionPool"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	String cid = request.getParameter("id");
	String cpass = request.getParameter("password");
	String cname = request.getParameter("name");
	String cgender = request.getParameter("gender");
	
	String year = request.getParameter("birthyy");
	String month = request.getParameter("birthmm");
	String day = request.getParameter("birthdd");
	String cbirth = year + "/" + month + "/" + day;
	
	String cemail = request.getParameter("email");
	String cphone = request.getParameter("phone");
	String caddress = request.getParameter("address");
	
	MemberDAO dao = new MemberDAO();
	int code = dao.join(cid, cpass, cname, cgender, cbirth, cemail, cphone, caddress);
	
	if (code == 1){
		response.sendRedirect("/product/products.jsp");
	} else {
		response.sendRedirect("joinMember.jsp");
	}


%>
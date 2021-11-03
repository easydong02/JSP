<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="dao.*" %>
<% 
	String cid = request.getParameter("id");

	String cpassword = request.getParameter("pass");
	
	MemberDAO dao = new MemberDAO();
	int count = dao.login(cid,cpassword);
	
	if(count ==1){
		out.print("아이디가 존재하지 않습니다.");
	}if(count ==2){
		out.print("패스워드가 일치하지 않습니다.");
		response.sendRedirect("loginMember.jsp");
	}else{
		out.print("로그인 성공!");
		session.setAttribute("id", cid);
		response.sendRedirect("/product/product.jsp");
	}













%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="dao.*" %>
<% 
	String cid = request.getParameter("id");
	String cpassword = request.getParameter("pass");
	String cname = request.getParameter("name");
	String cgender = request.getParameter("gender");
	String cbirth = request.getParameter("birth");
	String cemail = request.getParameter("email");
	String cphone = request.getParameter("tel");
	String addr1 = request.getParameter("addr1");
	String addr2 = request.getParameter("addr2");
	String caddr = addr1 + " " + addr2;
	
	MemberDAO dao = new MemberDAO();
	boolean count = dao.join(cid,cpassword,cname,cgender,cbirth,cemail,cphone,caddr);
	
	
	
	if(count ==true){
		response.sendRedirect("/product/products.jsp");
	}
	













%>
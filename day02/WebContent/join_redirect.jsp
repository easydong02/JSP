<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.net.URLEncoder" %>

<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String cust_id= request.getParameter("id");
	String cust_pw= request.getParameter("pw");

	out.print(cust_id + "<br>");
	out.print(cust_pw);
	
	String para = "대한민국";
	String encode_para = URLEncoder.encode(para,"utf-8");
	
	
	//response.sendRedirect("redirect.jsp");
	response.sendRedirect("redirect_check.jsp?para=" + encode_para); //? 뒷부분은 옵션임. 그 페이지로 가는데 옵션을 들고가는 것임.

%>

	<p><a href="redirect.jsp">[폼으로 돌악가기]</a></p>

</body>
</html>
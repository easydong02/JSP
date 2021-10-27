<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String user_id = "root";
	String user_pw="admin";
	String user_name="관리자";
	
	String cust_id = request.getParameter("cust_id");
	String cust_pw = request.getParameter("cust_pw");
	
	if(cust_id.equals(user_id)&& cust_pw.equals(user_pw)){
		session.setAttribute("cust_id", user_id);
		session.setAttribute("cust_name", user_name);
		
		out.print("<br>" + session.getAttribute("cust_id") + "("+session.getAttribute("cust_name")+")님 방문을 환영합니다.</br>");
	}
	else{
		out.print("회원 가입 후 방문하십시요<br>");
	}

	


%>

<a href="./loginForm.jsp">[로그인 폼]</a>

</body>
</html>
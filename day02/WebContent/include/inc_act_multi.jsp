<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] para3 =request.getParameterValues("para3");
	
if(para3 != null){
	for(int i =0; i<para3.length;i++){
		out.print("전송파라미터3: " + para3[i]+"<br>");
	}
}

%>

전송 파라미터 1: <%=request.getParameter("para1") %><br>
전송 파라미터 2: <%=request.getParameter("para2") %><br>

</body>
</html>
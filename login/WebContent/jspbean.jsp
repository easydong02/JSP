<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="login.Login" id ="user"/>  
<jsp:setProperty name="user" property ="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

이 페이지를 띄울 때 받은 변수 userid= <%=request.getParameter("userid") %>
이 페이지를 띄울 때 받은 변수 userpw= <%=request.getParameter("userpw") %>

Bean Calss 활용해서 Beans만들고 그 객체 user 에 있는 변수 userid:

<jsp:getProperty name ="user" property ="userid" />

Bean Calss 활용해서 Beans만들고 그 객체 user 에 있는 변수 userpw:

<jsp:getProperty name ="user" property ="userpw" />


로그인 체크 메서드 : <%=user.checkLogin() %>


</body>
</html>
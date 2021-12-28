<%@page import="com.koreait.mvc.model.movie.MovieManager"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%//스크립틀릿 이 jsp가 서블릿으로 변경될 때의 service(request,resonse)메서드 영역
	//서비스 메서드의 request로는 전달된 객체가 들어올 수 있다.
	
	String result= (String)request.getAttribute("result");
	out.print(result);
%>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
 /*
 	applocation 내장객체의 자료형은 ServletContext
 
 
 */
	String path = application.getRealPath("/WEB-INF/mapping.data");
	out.print(path);



%>
</body>
</html>
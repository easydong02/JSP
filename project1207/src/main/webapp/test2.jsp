<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
톰캣이 제공해주는 커넥션풀을 사용해보되, JNDI(java naming directory interface)를 이용하여 접근해보자!
JNDI : 특정 자원을 이름을 통해 접근하게 해주는 자바의 자원 접근 기술

<%
	//JNDI로 자원을 검색
	InitialContext context = new InitialContext();
	DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/mysql"); //자원을 찾아 나선다!!
	
	
	Connection con = ds.getConnection(); //그냥 평범한 커넥션이 아니라 커넥션풀에 있었던 커넥션
	//따라서 Connection을 close()하면, 다시 Pool로 돌아감
	out.print(con);
	con.close();
	

%>


</body>
</html>
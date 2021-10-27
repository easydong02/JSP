<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//JDBC 드라이버 로딩
String driverClass = "org.mariadb.jdbc.Driver";
try{
	Class.forName(driverClass); //DB
	out.print("JDBC Driver load 성공");
}catch(ClassNotFoundException e){
	out.print("JDBC Driver load 실패");
}

//MariaDB 서버 연결

String url = "jdbc:mariadb://localhost:3307/";
String id = "root";
String pw = "1234";

Connection conn =null;
PreparedStatement pstmt = null;
try{
	conn=DriverManager.getConnection(url, id, pw);
	out.print("MariaDB 연결 성공!");
	
	
	
	
	
	
	
}catch(SQLException e){
	out.print("MariaDB 연결 실패");
	out.print(e.getMessage());
}finally{
	
	
	
	
	
}

%>


</body>
</html>
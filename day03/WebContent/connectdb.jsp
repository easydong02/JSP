<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC 드라이버 로딩</title>
</head>
<body>
<%
	String driverClass = "org.mariadb.jdbc.Driver";

	try{
		Class.forName(driverClass);
		out.print("JDBC Driver loading 성공!");
	}catch(ClassNotFoundException err){
		out.print("JDBC Driver loading 실패 ㅜ");
	}


	//Maria DB 연결
	
	String url ="jdbc:mariadb://localhost:3307";
	String id = "root";
	String pw = "1234";
	
	Connection conn = null;
	
	try{
		conn = DriverManager.getConnection(url,id,pw);
		out.print("MariaDB 서버 연결 성공");
	}catch(SQLException sqlerr){
		out.print("MariaDB 서버 연결 실패 ㅜ"+ "<br>");
		out.print(sqlerr.getMessage());
	}finally{
		if (conn !=null){
			try{
				conn.close();
				out.print("MariaDB 서버 연결 종료!<br>");
			}catch(Exception conerr){
				conerr.printStackTrace();
			}
		}
	}
%>



</body>
</html>
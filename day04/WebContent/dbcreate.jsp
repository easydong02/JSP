<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "java.sql.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String driverClass = "org.mariadb.jdbc.Driver";
	

	try{
		Class.forName(driverClass);
		out.println("JDBC 드라이버 로딩 성공"+"<br>");
	}
	catch(ClassNotFoundException e){
		out.print("JDBC드라이버 로딩 실패"+"<br>");
		
	}
	
	String url = "jdbc:mariadb://localhost:3307";
	String id = "root";
	String pw = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try{
		conn = DriverManager.getConnection(url,id,pw);
		out.print("MariaDB 서버 연결 성공"+"<br>");
		
		//SQL 처리
		
		String sql ="CREATE DATABASE univ2";
		pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		out.print("데이터베이스 생성 성공"+"<br>");
		
		
		
		
		
		
		
		
	}
	catch(SQLException e){
		out.print("MariaDB  실패."+"<br>");
	}
	finally{
		//데이터 베이스 연결 종료
		if(pstmt != null){
			try{
				pstmt.close();
				out.print("pstmt 연결 종료" +"<br>");
			}catch(Exception conerr){
				conerr.printStackTrace();
			}
		}
		if(conn != null){
			try{
				conn.close();
				out.print("MariaDB 서버 연결 종료" +"<br>");
			}catch(Exception conerr){
				conerr.printStackTrace();
			}
		}
	}

%>

</body>
</html>
	
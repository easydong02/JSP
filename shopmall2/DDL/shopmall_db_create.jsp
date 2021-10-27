<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
 <title>쇼핑몰데이터베이스(shopmall) DB 생성(shopmall_db_create.jsp)</title>
 <meta charset="UTF-8">
</head>

<body>
 <% 
  // JDBC 드라이버 로딩(loading JDBC driver)
  String driverClass = "org.mariadb.jdbc.Driver";
	 
  try {
     Class.forName(driverClass);
     out.println("JDBC Driver loading 성공!<Br>");
  } catch (ClassNotFoundException err) {
     out.println("JDBC Driver loading 실패!!...WEB-INF/lib 폴더 확인<Br>");
  }
    
  // MariaDB 서버 연결(connect server)
  // "jdbc:mariadb://server_IP:3306/datbase_name
  String url = "jdbc:mariadb://localhost:3306/";
  String id = "root";      // DB 사용자 아이디
  String pw = "admin";     // DB 사용자 패스워드
   
  // 객체 참조 변수
  Connection conn = null;
  PreparedStatement pstmt = null;
   
  try {
     conn = DriverManager.getConnection(url, id, pw);
    
     // SQL 질의어 처리(Perform SQL query(DDL))
     // 쇼핑몰데이터베이스(shopmall) 스키마 생성
     String sql = "CREATE DATABASE shopmall";
     pstmt = conn.prepareStatement(sql);
     pstmt.executeUpdate();    
     out.println("쇼핑몰데이터베이스(shopmall) 생성 성공!<Br>");
  
  } catch (SQLException sqlerr) {
	 out.println("쇼핑몰데이터베이스(shopmall) 생성 실패!!" + sqlerr.getMessage() + "<Br>");

  } finally {
     // 데이터베이스 연결 종료(close database)
     if (pstmt != null) try {pstmt.close();} catch (SQLException sqlerr) {}
     if (conn != null) try {conn.close();} catch (SQLException sqlerr) {}
  }
 %>

</body>
</html>
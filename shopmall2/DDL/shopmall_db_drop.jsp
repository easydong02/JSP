<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<%@ page import="dbconnclose.*"%>

<!DOCTYPE html>
<html>
<head>
 <title>쇼핑몰데이터베이스(shopmall) DB 삭제(shopmall_db_drop.jsp)</title>
 <meta charset="UTF-8">
</head>

<body>
 <%
  // 객체 참조 변수
  Connection conn = null;
  PreparedStatement pstmt = null;

  // JDBC 드라이버 로딩(loading JDBC driver) &
  // MariaDB 서버와 데이터베이스 연결(connect server & database )
  conn = DbConnClose.getConnection();

  try {
     // SQL 질의어 처리(Perform SQL query(DDL))
     // 쇼핑몰데이터베이스(shopmall) 스키마 삭제
     String sql = "DROP DATABASE shopmall";
     pstmt = conn.prepareStatement(sql);
     pstmt.executeUpdate();    
     out.println("쇼핑몰데이터베이스(shopmall) 삭제 성공!<Br>");
  
  } catch (SQLException sqlerr) {
     out.println("SQL 질의처리 오류!" + sqlerr.getMessage());

  } finally {
     // 데이터베이스 연결 종료(close database)
     DbConnClose.resourceClose(pstmt, conn);  
  }
 %>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<%@ page import="dbconnclose.*"%>

<!DOCTYPE html>
<html>
<head>
 <title>쇼핑몰데이터베이스(shopmall) 테이블 생성(shopmall_tbl_create.jsp)</title>
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
     // SQL 질의어 처리(perform SQL query(DML))
     // 고객테이블(customer) 스키마 생성
     String sql = "CREATE TABLE customer2("
                       + "cust_id         varchar(10) NOT NULL,"
     		           + "cust_pw         varchar(10),"
     		           + "cust_name       varchar(15),"
     		           + "cust_tel_no     varchar(13),"
     		           + "cust_addr       varchar(100),"
     		           + "cust_gender     char(1),"
     		           + "cust_email      varchar(30),"
     		           + "cust_join_date  date,"
     		           + "primary key(cust_id))";
     pstmt = conn.prepareStatement(sql);
     pstmt.executeUpdate();    
     out.println("고객테이블(customer) 생성 성공!<Br>");
      
  } catch (SQLException sqlerr) {
     out.println("SQL 질의처리 오류!" + sqlerr.getMessage());

  } finally {
     // 데이터베이스 연결 종료(close database)
     DbConnClose.resourceClose(pstmt, conn);  
  }
 %>

</body>
</html>
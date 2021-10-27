<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<%@ page import="dbconnclose.*"%>

<% // 전송 한글 데이터 처리
   request.setCharacterEncoding("UTF-8"); %>
   
<!DOCTYPE html>
<html>
<head>
 <title>개인 회원정보  DB 삭제(customer_delete_db.jsp)</title>
 <meta charset="UTF-8">
 <link rel="stylesheet" href="../../common/CSS/common.css">
</head>

<body>
 <%
  // 전송 데이터 변수 할당
  String cust_id = request.getParameter("cust_id"); 
  String cust_pw = request.getParameter("cust_pw");

  // 객체 참조 변수
  Connection conn = null;
  PreparedStatement pstmt = null;

  // JDBC 드라이버 로딩(loading JDBC driver) &
  // MariaDB 서버와 데이터베이스 연결(connect server & database )
  conn = DbConnClose.getConnection();

  try {
     // SQL 질의어 처리(perform SQL query(DML))
     // 고객테이블(customer) 튜플 검색   
     String sql = "DELETE FROM customer "
                + "WHERE (cust_id = ?) and (cust_pw = ?)";
     pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, cust_id);
        pstmt.setString(2, cust_pw);
     pstmt.executeUpdate();
      
  } catch (SQLException sqlerr) {
     out.println("SQL 질의처리 오류!" + sqlerr.getMessage());

  } finally {
     // 데이터베이스 연결 종료(close database)
     DbConnClose.resourceClose(pstmt, conn);  
  }
  
  // 튜플 삭제 후 고객정보 관리 메뉴
  out.println("고객테이블(customer) 튜플 삭제 성공!" + "<Br>");
  out.println("<script>alert('회원 정보가 삭제 되었습니다!!');"
                    + "location.href = './customer_maintenance.jsp';"
            + "</script>");
 %>

</body>
</html>
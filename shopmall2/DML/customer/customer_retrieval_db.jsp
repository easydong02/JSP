<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<%@ page import="dbconnclose.*"%>

<% // 전송 한글 데이터 처리
   request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
 <title>개인 회원정보 검색(customer_retrieval_db.jsp)</title>
 <meta charset="UTF-8">
 <link rel="stylesheet" href="../../common/CSS/common.css">
</head>

<body>
 <%
  // 전송 데이터(아이디) 확인 및 변수 할당
 %>  
  <%@ include file="../../common/include/jsp_id_check_irud.inc"%>
 <%
 
  // 객체 참조 변수
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rset = null;   

  // JDBC 드라이버 로딩(loading JDBC driver) &
  // MariaDB 서버와 데이터베이스 연결(connect server & database )
  conn = DbConnClose.getConnection();

  try {
     // SQL 질의어 처리(perform SQL query(DML))
     // 고객테이블(customer) 튜플 검색
 %>     
  <%@ include file="../../common/include/jsp_sql_dbget_rud.inc"%>
 <%
  // 회원 검색정보 출력
 %>

<form name="customer_form">
 <table>
  <caption>회원정보 검색</caption> 
  <tr style="border-style:hidden hidden solid hidden;">
   <td colspan="2" style="background-color:white; text-align:right;">
       <span class="msg_red">* 부분은 필수입력 항목입니다!</span></td>
  </tr>

  <%@ include file="../../common/include/html_output_rd.inc"%>

  <tr>
   <td colspan="2" style="text-align:center;">
       <a href="./customer_maintenance.jsp">[ 고객정보 관리 ]</a></td>
  </tr>
 </table>
</form>

<%
  } catch (SQLException sqlerr) {
     out.println("SQL 질의처리 오류!" + sqlerr.getMessage());

  } finally {
    // 데이터베이스 연결 종료(close database)
    DbConnClose.resourceClose(rset, pstmt, conn);  
  }

  out.println("고객테이블(customer) 튜플 검색 성공!" + "<Br>");
 %>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<%@ page import="dbconnclose.*"%>

<% // 전송 한글 데이터 처리
   request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 체크 및 세션 설정(login_ses_create.jsp)</title>
</head>
<body>
 <%
  // 전송 데이터 변수 할당 
  String cust_id = request.getParameter("cust_id"); 
  String cust_pw = request.getParameter("cust_pw");
  
  // 아이디, 비밀번호 체크
  if (cust_id.isEmpty() || cust_pw.isEmpty()) {
     out.print("<script>alert('아이디와 비밀번호를 확인하십시오!!');"
                     + "history.back();"
             + "</script>");
  }

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
     String sql = "SELECT * FROM customer "
                + "WHERE (cust_id = ?) and (cust_pw = ?)";
     pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, cust_id);
        pstmt.setString(2, cust_pw);
     rset = pstmt.executeQuery();

     // 질의처리 결과(rset) 체크
     // cursor - 초기 상태 아니거나 행(결과)이 없으면 false 리턴
     if (!rset.isBeforeFirst()) {
        out.print("<script>alert('존재하지 않는 아이디와 비밀번호입니다!!');"
                        + "history.back();"
                + "</script>");
     }
      
     // 첫 번째 레코드 커서 이동
     rset.next();
         
     String cust_name = rset.getString("cust_name");

     // 세션 객체의 속성(세션 변수) 생성
     session.setAttribute("cust_id", cust_id);
     session.setAttribute("cust_name", cust_name);

  } catch (SQLException sqlerr) {
      out.println("SQL 질의처리 오류!" + sqlerr.getMessage());

  } finally {
     // 데이터베이스 연결 종료(close database)
     DbConnClose.resourceClose(rset, pstmt, conn);  
  }
  
  // 경고 창 무시하고 지정 페이지(URL)로 강제 이동
  response.sendRedirect("./index.jsp");  
 %>

</body>
</html>
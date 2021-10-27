<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<%@ page import="dbconnclose.*"%>

<!DOCTYPE html>
<html>
<head>
 <title>고객정보 테이블 검색과 갱신 및 삭제(customer_retrieval_table.jsp)</title>
 <meta charset="UTF-8">
 <link rel="stylesheet" href="../../common/CSS/table_retrieval.css">
</head>

<body>
<%
   // 객체 참조 변수
   Connection conn = null;
   Statement stmt = null;
   ResultSet rset = null;   

   // JDBC 드라이버 로딩(loading JDBC driver) &
   // MariaDB 서버와 데이터베이스 연결(connect server & database )
   conn = DbConnClose.getConnection();
   
   try {
      // SQL 질의어 처리(perform SQL query(DML))
      // 고객테이블(customer) 튜플 검색 - prepareStatement(sql)
      String sql = "SELECT * FROM customer ORDER BY cust_id ASC";
      stmt = conn.createStatement();          
      rset = stmt.executeQuery(sql);

      // 질의처리 결과(rset) 체크
      // cursor - 초기 상태 아니거나 행(결과)이 없으면 false 리턴
      if (!rset.isBeforeFirst()) {
         out.print("<script>alert('고객테이블(customer)이 비어 있습니다!!');"
                         + "history.back();"
                 + "</script>");
      }

  // 회원 검색정보 출력
 %> 
      
<form name="customer_form_table">
 <table>
  <caption>운영자 고객정보 관리</caption>
  <tr>
   <th>아이디</th>
   <th>비밀번호</th>
   <th>이름</th>
   <th>전화번호</th>
   <th>주소</th>
   <th>성별</th>
   <th>이메일</th>
   <th>가입일</th>
   <th>갱신</th>
   <th>삭제</th>
  </tr>      
 <%
      // 고객정보(레코드 셋) 출력
      // ResultSet 객체 rset 생성, cursor positioned before the first row
      while (rset.next()) {

         String cust_id = rset.getString("cust_id");
         String cust_pw = rset.getString("cust_pw");
         String cust_name = rset.getString("cust_name");
         String cust_tel_no = rset.getString("cust_tel_no");
         String cust_addr = rset.getString("cust_addr");
         String cust_gender = rset.getString("cust_gender");
         if (cust_gender == null) {
             cust_gender = "";
         } else if (cust_gender.equals("M")) {
                   cust_gender = "남자(" + cust_gender + ")";
                } else {
                      cust_gender = "여자(" + cust_gender + ")";
         }         
         String cust_email = rset.getString("cust_email");
         String cust_join_date = rset.getString("cust_join_date");
%>
  <tr>
   <td><%=cust_id%></td>
   <td><%=cust_pw%></td>
   <td><%=cust_name%></td>
   <td><%=cust_tel_no%></td>
   <td><%=cust_addr%></td>
   <td><%=cust_gender%></td>
   <td><%=cust_email%></td>
   <td><%=cust_join_date%></td>
   <td style="text-align:center;">
       <a href="./customer_update_retrieval.jsp?cust_id=<%=cust_id%>">[갱신]</a></td>
   <td style="text-align:center;">
       <a href="./customer_delete_retrieval.jsp?cust_id=<%=cust_id%>">[삭제]</a></td>
  </tr>
<%
      }
     
   } catch (SQLException sqlerr) {
      out.println("SQL 질의처리 오류!" + sqlerr.getMessage());

   } finally {

%> 
 </table>
</form>
<%
      rset.last();                 // 마지막  행으로 cursor 이동
      int row_cnt = rset.getRow(); // 커서의 인덱스 값 리턴(튜픞 수)
      out.println("고객테이블(customer) " + row_cnt + "개 레코드 검색 성공!" + "<Br>");

      // 데이터베이스 연결 종료(database close)
      DbConnClose.resourceClose(rset, stmt, conn);
   }   
%>

</body>
</html>
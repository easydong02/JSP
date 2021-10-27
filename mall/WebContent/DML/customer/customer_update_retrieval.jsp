<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<%@ page import="dbconnclose.*"%>

<% // 전송 한글 데이터 처리
   request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
 <title>개인 회원정보 갱신(customer_update_retrieval.jsp)</title>
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

<form name="customer_form" method="post" action="customer_update_db.jsp">
 <table>
  <caption>회원정보 갱신</caption> 
  <tr style="border-style:hidden hidden solid hidden;">
   <td colspan="2" style="background-color:white; text-align:right;">
       <span class="msg_red">* 부분은 필수입력 항목입니다!</span></td>
  </tr>
  <tr>
   <th><span class="mmsg_red">*</span>아 이 디</th>
   <td><input type="text" name="cust_id" size="10" maxlength="10" value="<%=cust_id%>" readonly>
       <span class="msg_blue">(영,숫자 10자리이내)</span></td>
  </tr>
  <tr>
   <th><span class="msg_red">*</span>비밀번호</th>
   <td><input type="text" name="cust_pw" size="11" maxlength="10" value="<%=cust_pw%>" style="ime-mode:disabled" autofocus required>
       <span class="msg_blue">(영,숫자 10자리이내)</span></td>
  </tr>

  <tr>
   <th><span class="msg_red">*</span> 이 &nbsp; 름 &nbsp; &nbsp;</th>
   <td><input type="text" name="cust_name" size="10" maxlength="5" value="<%=cust_name%>" style="ime-mode:active" required></td>
  </tr>
  <tr>
   <th><span class="msg_red">*</span>전화번호</th>
   <td><select name="tel_no_gubun" required>
               <option selected value="">서비스 구분</option>
               <option value="010">010</option>
               <option value="011">011</option>
               <option value="016">016</option>
               <option value="017">017</option>
               <option value="018">018</option>
               <option value="019">019</option>
 <%
  // 문자열 내부 " 포함(\")
  String[] cust_tel_no = custTelNo.split("-", 3);
  if (cust_tel_no[0].equals("010")) {
     out.print("<option selected value=\"010\">010</option>");
  } else if (cust_tel_no[0].equals("011")) {
            out.print("<option selected value=\"011\">011</option>");
         } else if (cust_tel_no[0].equals("016")) {
        	       out.print("<option selected value=\"016\">016</option>");
               } else if (cust_tel_no[0].equals("017")) {
            	         out.print("<option selected value=\"017\">017</option>");
                     } else if (cust_tel_no[0].equals("018")) {
                    	       out.print("<option selected value=\"018\">018</option>");
                           } else if (cust_tel_no[0].equals("019")) {
                        	         out.print("<option selected value=\"019\">019</option>");
                                 } else {
                                	    out.print("<option selected value=\"\">서비스구분</option>");
  }
 %>
       </select>-
       <input type="text" name="tel_no_guk" size="5" maxlength="4" value="<%=cust_tel_no[1]%>" style="ime-mode:disabled" required>-
       <input type="text" name="tel_no_seq" size="5" maxlength="4" value="<%=cust_tel_no[2]%>" style="ime-mode:disabled" required></td>
  </tr>
  <tr>
   <th><span class="msg_red">*</span> 주 &nbsp; 소 &nbsp; &nbsp;</th>
   <td><input type="text" name="cust_addr" size="50" maxlength="50" value="<%=cust_addr%>" style="ime-mode:active" required></td>
  </tr>
  <tr>
   <th>성 &nbsp; 별 &nbsp; </th>
   <td>
 <%
  if (cust_gender == null) {
     out.print("<input type=\"radio\" name=\"cust_gender\" value=\"M\">남자 &nbsp");
     out.print("<input type=\"radio\" name=\"cust_gender\" value=\"F\">여자");
  } else if (cust_gender.equals("M")) {
            out.print("<input type=\"radio\" name=\"cust_gender\" value=\"M\" checked>남자 &nbsp");
            out.print("<input type=\"radio\" name=\"cust_gender\" value=\"F\">여자");
        } else {
               out.print("<input type=\"radio\" name=\"cust_gender\" value=\"M\">남자 &nbsp");
               out.print("<input type=\"radio\" name=\"cust_gender\" value=\"F\" checked>여자");
  }
 %>
   </td>
  </tr>
  <tr>
   <th>이 메 일</th>
 <%   
   String array_email[], cust_email_1, cust_email_2;
 
   if (cust_email.isEmpty()) {
      cust_email_1 = "";
      cust_email_2 = "";
   } else {
	   array_email = cust_email.split("@", 2);
      cust_email_1 = array_email[0];
      cust_email_2 = array_email[1];	   
   }
 %>  
   <td><input type="text" name="cust_email_1" size="15" maxlength="10" value="<%=cust_email_1%>" style="ime-mode:disabled">@
       <input type="text" name="cust_email_2" size="20" maxlength="20" value="<%=cust_email_2%>" style="ime-mode:disabled"></td>
  </tr>
  <tr>
   <th>가 입 일</th>
   <td><input type="text" name="cust_join_date" size="10" value="<%=cust_join_date%>" readonly></td>
  </tr>
  <tr>
   <td colspan="2" style="text-align:center;">
       <input type="submit" value="갱신하시겠습니까?">
       <input type="button" value="갱신 취소" onClick="location.href = './customer_maintenance.jsp';"></td>
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
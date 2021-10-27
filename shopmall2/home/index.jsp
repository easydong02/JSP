<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <title>홈 페이지 디자인(index.jsp)</title>
 <link rel="stylesheet" href="../common/CSS/home.css">
</head>
<body>
  <!-- 세션 객체의 속성 확인 -->
  <%@ include file="../common/include/home_ses_check.inc"%>
  
 <!-- 가장자리_box -->
 <div id="out_box">

  <div id="header">
   <b>header</b>
  </div>

  <!-- body_left -->
  <div id="body_left">
   <form name="login_form" method="POST" action="./login_ses_create.jsp">
   <table>
    <tr>
     <th>아 이 디</th>
      <td><input type="text" name="cust_id" size="10" maxlength="10" required autofocus></td>
    </tr>
    <tr>
     <th>비밀번호</th>
     <td><input type="password" name="cust_pw" size="11" maxlength="10" required></td>
    </tr>
    <tr>
     <td colspan="2" style="text-align:center;">
     <%
     if (login) {  // 로그인 경우 버튼 상태
        out.print("<input type='submit' value='로그 인' disabled>"
	            + "<input type='button' value='회원 가입' disabled</td>");
     } else {	    // 로그아웃 경우 버튼 상태
        out.print("<input type='submit' value='로그 인'>"
                + "<input type='button' value='회원 가입'"
	            + "onClick=location.href='../DML/customer/"
	            + "customer_insert_form.jsp'></td>");
     }
     %>
     </tr>
    </table>
   </form>
  </div>

  <!-- body_middle -->
  <div id="body_middle">
   <ul id="menu_ul">
   <%
   if (login) {  // 로그인 경우 메뉴
      out.print("<li><a href='../DML/customer/customer_update_form.jsp'"
    		               + "target='_parent'>회원정보 갱신</a></li>");
   } else {      // 로그아웃 경우 메뉴
      out.print("<li><a href='../DML/customer/customer_insert_form.jsp'"
    		               + "target='_parent'>회원가입</a></li>");
   }
   %>
    <li><a href="../DML/order_sale/.jsp" target="_blank">상품검색</a></li>
    <li><a href="../DML/board_auto/.jsp" target="_blank">게시판</a></li>
    <li><a href="../DML/notice/.jsp" target="_blank">공지사항</a></li>
   </ul>
  </div>

  <!-- body_right -->
  <div id="body_right">
   <%
    if (login) {  // 로그인 경우
        out.print("(" + cust_name + ")님 로그인 중"
                + "<input type='button' value='로그아웃'"         
                + "onClick=location.href='./logout_ses_delete.jsp'>");
    } else {	  // 로그아웃 경우
       out.print("로그인 하십시요!");
    }
   %>     
  </div>

  <!-- footer -->
  <div id="footer">
   <b>footer</b>
  </div>
 
</body>
</html>
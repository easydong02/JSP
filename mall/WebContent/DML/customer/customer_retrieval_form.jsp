<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
 <title>개인 회원정보 검색(customer_retrieval_form.jsp)</title>
 <meta charset="UTF-8">
 <link rel="stylesheet" href="../../common/CSS/common.css">
</head>

<body>
<form name="customer_form" method="post" action="customer_retrieval_db.jsp">
 <table>
  <caption>개인 회원정보 검색</caption>
  <tr style="border-style:hidden hidden solid hidden;">
   <td colspan="2" style="background-color:white; text-align:right;">
       <span class="msg_red"> * 부분은 필수입력 항목입니다!</span></td>
  </tr>
  
  <%@ include file="../../common/include/html_input1_irud.inc"%>
  
  <tr>
   <td colspan="2" style="text-align:center;">
       <input type="submit" value="회원정보 검색">
       <a href="./customer_maintenance.jsp">[ 고객정보 관리 ]</a></td>
  </tr>  
 </table>
</form>

</body>
</html>
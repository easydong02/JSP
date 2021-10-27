<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="customer_find" method ="post" action="customer_retrieval_db.jsp">
<table>
<caption>개인 회원 정보 검색</caption>
<%@ include file= "../common/html_input1.inc" %>
<tr>
<td colspan ="2">
	<input type="submit" value="회원정보 검색">
</td>
</tr>


</table>
</form>
</body>
</html>
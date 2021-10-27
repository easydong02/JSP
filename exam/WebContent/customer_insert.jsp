<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 입력</title>
</head>
<body>
	<form name="customer_form" method="post"
		action="customer_insert_db.jsp">
		<table>
			<caption>회원 정보 입력</caption>
			<%@ include file="../common/html_input1.inc"%>

			<%@ include file="../common/html_input2.inc"%>
			
			<tr>
				<td colspan="2" style = "text-align:center"><input  type = "submit" value = "회원가입"></td>
			</tr>
		</table>
	</form>
</body>
</html>
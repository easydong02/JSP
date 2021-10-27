<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 정보 수정</title>
</head>
<body>
	<form name="customer_form" method="post" action="customer_update_db.jsp">
		<table>
			<caption>고객 정보 수정</caption>
				<%@ include file= "../common/html_input1.inc" %>
			<tr>
				<td colspan="2" style="text-align: center">
				<input type="submit" value="고객 정보 수정"></td>
			</tr>
		</table>
	</form>
</body>
</html>
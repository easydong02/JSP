<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% request.setCharacterEncoding("UTF-8"); %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name = "form" method ="post" action="join_redirect.jsp">
		<table>
			<caption>redirect</caption>
			<tr>
				<th><span class="msg_red">*</span>아이디</th>
				<td><input type="text" name="id" size="10" maxlength="10" required></td>
			</tr>
			<tr>
				<th><span class="msg_red">*</span>비밀번호</th>
				<td><input type="password" name="pw" size="11" maxlength="10" required></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center;">
					<input type="submit" value="전송">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 폼</title>
</head>
<body>
<!-- 
	브라우저에서 서버로 정보를 전송하는 방식에는 get 방식과 post방식이 있다.
	get은 url뒤에 문자열로 헤더에 포함되어 전송. 주소에 보이게 전송, 보안 취약(노출 가능성)
	post는 몸체에 포함되어 전송된다. 보이지 않게 전송, 부안 우수, 한글 깨짐 현상

 -->
	<form name = "customer_form" method ="post" action="join.jsp">
		<table>
			<caption>회원 가입</caption>
			<tr>
				<th><span class="msg_red">*</span>아이디</th>
				<td><input type="text" name="id" size="10" maxlength="10" required></td>
			</tr>
			<tr>
				<th><span class="msg_red">*</span>비밀번호</th>
				<td><input type="password" name="pw" size="11" maxlength="10" required></td>
			</tr>
			<tr>
				<th><span class="msg_red">*</span>이름</th>
				<td><input type="text" name="name" size="11" maxlength="10" required></td>
			</tr>
			<tr>
				<th><span class="msg_red">*</span>성별</th>
				<td><input type="radio" name="gender" value="M">남자&nbsp;
				<input type="radio" name="gender" value="F">여자
				</td>
			</tr>
			<tr>
				<th><span class="msg_red">*</span>취미</th>
				<td><input type="checkbox" name="hobby" value="등산">등산&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="hobby" value="독서">독서&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="hobby" value="음악듣기">음악듣기&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="hobby" value="영화보기">영화보기</td>
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
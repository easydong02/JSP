<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>이 파일은 first.jsp</h3>
		<jsp:forward page="second.jsp" />
	<p>===first.jsp페이지===</p>
	
요청한 url인 first.jsp 파일의 내용은 없고 second.jsp 내용만 있다.
first.jsp 실행되다가 forward를 만나면 지금까지 저장된 출력을 삭제하고 프로그램 제어를 second로 이동한다. 포워딩
forward 태그가 선언된 지점 이전까지 생성된 코드들은 손실된다. 신중할 필요가 있다.


</body>
</html>
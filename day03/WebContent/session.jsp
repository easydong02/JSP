<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
세션도 쿠키처럼 비연결 비 상태유지 특성에 대한 문제점을 해결하기 위한 방법
쿠키와 차이점은 클라이언트와 웹서버와의 관계 정보를 클라이언트가 아닌 서버 상에 저장 관리된다.

클라이언트가 브라우저를 통해 웹서버에 서비스를 요청하면 웹서버는 하나의 웹브라우저에 대해 하나의 고유한 세션 아이디(Jsessionid)와 session 내장객체를 자동으로 생성하고
클라이언트에 대한 그 세션 정보를 서버에 저장한다. 생성된 세션 아이디는 암호화된 문자열로 클라이언트에 전송된다.

일반적으로는 JSP프로그램에서는 세션아이디를 사용하는 쿠키보다는 session 내장 객체에 세션 속성을 설정하는 방법을 사용한다.
</body>
</html>
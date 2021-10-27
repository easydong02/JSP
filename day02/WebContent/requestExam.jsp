<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
request 내장 객체
내장 객체(implicit object)는 개발자가 객체를 생성하지 않고 바로 사용할 수 있는 객체로 내부 객체 또는 기본 객체
자동으로 객체가 생서된다. 간단하게 쉽게 활용할 수 있다.
대표적인 내장 객체 - response, session, config, page, exception.....

request가 JSP에서 가장 많이 사용되는 내장객체, 웹 브라우저에서 서버로 연결한 후에 요청 정보를 전달한다.

getRemoteAddr() 클라이언트 IP주소
getRemoteHost() 클라이언트 이름 리턴
getRemotePort() 클라이언트 포트 리턴
getRemoteUser() 클라이언트 사용자 리턴
<br><br>


<h1>request 내장 객체</h1>

getRemoteAddr() 클라이언트 IP주소: <%=request.getRemoteAddr() %><br>
getRemoteHost() 클라이언트 이름 리턴: <%=request.getRemoteHost() %><br>
getRemotePort() 클라이언트 포트 리턴: <%=request.getRemotePort() %><br>
getRemoteUser() 클라이언트 사용자 리턴:<%=request.getRemoteUser() %><br>


쿠키: <%=request.getCookies() %><br>
세션 아이디: <%=request.getRequestedSessionId() %><br>
세션 정보: <%=request.getSession() %><br>

<br><br>
전달하는 모든 정보는 이름key-값value로 구성된 데이터 구조이다. (Map구조)

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%@ include file ="./include/inc_header.jsp" %>

쿠키

쿠키는 비연결 비상태유지에 대한 문제점을 해결하는 방법 중 하나이다.
쿠키를 사용하여 클라이언트의 정보를 웹서버로 전송할 수 있다.
웹서버는 전송받은 정보를 확인해서 이전과 동일인인지 여부를 확인할 수 있다.
생성된 쿠키는 클라이언트에 저장되어 삭제되기 전 또는 브라우저를 종료하더라도 유효시간 이전에는 계속해서 전송된다.
<br><br>

<%
	Cookie cookie = new Cookie("id","pass");
	cookie.setMaxAge(300); //초단위(5분)
	response.addCookie(cookie);
	
	
	out.print("쿠키 생성 성공");


%>

쿠키 이름: <%=cookie.getName() %><br>
쿠키 값: <%=cookie.getValue() %><br>
유효시간: <%=cookie.getMaxAge() %> 초<br>




클라이언트가 서버에 서비스를 요청 시 쿠키 정보를 메시지의 헤더에 포함하여 전달한다.
서버가 getCookies() 메소드를 호출하여 쿠키 정보를 확인한다.



<p><a href ="cookieDelete.jsp">[쿠키 삭제]</a>

<%@ include file ="./include/inc_bottom.jsp" %>
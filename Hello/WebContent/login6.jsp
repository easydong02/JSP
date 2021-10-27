<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.Date" %>

선언문은 <%! %> 로 정의하며 함수나 변수의 선언이 가능하다. 날짜를 가져오는 함수 형태로 만들어 스크립트릿에서 호출할 수 있다.
<%!
	String getDate(){
		return (new Date()).toString();
	
	
	
	}
%>

<%	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("id");
	String res="<h3>사용자 아이디: " + uid + "</h3>";
	res += "<br>로그인 시간: " +getDate();
	out.print(res);


%>
선언문 내에 정의되는 코드는 서블릿 클래스의 멤버 함수나 멤버 변수로 변환된다.
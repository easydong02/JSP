<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<!-- page 지시어의 import 속성값을 java.util.Date로 지정하여
날짜 관련 함수들을사용할 수 있도록 한다. --> 
<%
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("id");
	String res = "<h3>사용자 아이디 : " + uid + "</h3>";
	res += "<br>로그인 시간 : " + (new Date()).toString();
	// new Date()를 통해서 Date 객체를 생성한다.
	//date객체는 현재 날짜 정보를 가지고 있다. 
	out.print(res);
%>

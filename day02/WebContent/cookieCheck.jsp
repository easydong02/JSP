<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%@ include file ="./include/inc_header.jsp" %>

<%
	Cookie[] cookies=request.getCookies();

	if(cookies != null){
		for( int i =0; i<cookies.length; i++){
			String name = cookies[i].getName();
			String value = cookies[i].getValue();
			
			out.print("쿠키 이름: " + name + "<br>");
			out.print("쿠키 밸류: " + value + "<br>");
		}
	}
	else{
		out.print("설정된 쿠키 정보가 없습니다.");
	}




%>
<p><a href ="cookieDelete.jsp">[쿠키 삭제]</a>

<%@ include file ="./include/inc_bottom.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%@ include file ="./include/inc_header.jsp" %>

<%
	Cookie[] cookies=request.getCookies();

	if(cookies != null){
		for( int i =0; i<cookies.length; i++){
			cookies[i].setMaxAge(0);
			response.addCookie(cookies[i]);
			out.print("쿠키 정보가 삭제되었습니다.");
		}
	}
	else{
		out.print("설정된 쿠키 정보가 없습니다.");
	}




%>
<p><a href ="cookieCheck.jsp">[쿠키 확인]</a>

<%@ include file ="./include/inc_bottom.jsp" %>
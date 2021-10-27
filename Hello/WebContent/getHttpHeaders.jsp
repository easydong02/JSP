<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %> <!-- 리스트 자료구조와 유사하게 사용한다.  -->

<% request.setCharacterEncoding("utf-8");
	Enumeration<String> en = request.getHeaderNames(); //HTTP요청 메시지의 헤더에 포함된 모든 속성들의 이름을 가져온다.
	while(en.hasMoreElements()){ //요소가 남아 있는 경우 true
		String name=(String)en.nextElement(); //미처리된 요소를 반환한다.
		String value = request.getHeader(name);
		out.print(name + ": " + value+ "<br>");
	}




%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uid = (String) session.getAttribute("id");
	if (uid==null){
		out.print("로그인 정보가 없습니다.");
		
	}else{
		out.print("메인 페이지입니다.");
		session.setAttribute("id", uid);
		//메인이 호출될때마다 세션 시간을 초기화하여 연장함으로 불필요한 로그인 과정을 줄일 수 있다.
	}





%>
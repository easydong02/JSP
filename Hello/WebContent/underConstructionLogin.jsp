<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.Date"%>
<!-- 날짜 생성 -->
<%@ page import ="java.text.SimpleDateFormat" %>
<!-- 날짜 형태 설정-->
<% request.setCharacterEncoding("utf-8");

	Date now = new Date();
	SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd"); // 소문자 m은 분
	String date = df.format(now);
	
	if(date.endsWith("25")){ //날짜가 12일이면 공사중으로 이동
		response.sendRedirect("underCheck.jsp");
		return;
	}
	
	String uid= request.getParameter("id");
	String res = "<h3>사용자 아이디: " + uid + "</h3>";
	res +="<br>로그인 시간: " + now.toString();
	out.print(res);



%>
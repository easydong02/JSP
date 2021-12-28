<%@page import="com.koreait.project1207.domain.Notice"%>
<%@page import="com.koreait.project1207.notice.model.NoticeDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%!
	NoticeDAO noticeDAO = new NoticeDAO(); //DAO는 하나만 있으면 되니까 멤버변수로
%>

<%
	//파라미터를 받아, mysql insert() 상투적인 코드!!

	
	request.setCharacterEncoding("utf-8");
	String title = request.getParameter("title");
	String writer =request.getParameter("writer");
	String content =request.getParameter("content");
	
	//로직
	//클라이언트가 전송한 파라미터를 DTO에 담아서 전달!
	Notice notice = new Notice(); //DTO 인스턴스 생성 empty상태..
	notice.setWriter(writer);
	notice.setTitle(title);
	notice.setContent(content);
	
	int result = noticeDAO.insert(notice);
	
	
	
		out.print("<script>");
	if(result ==1){
		out.print("alert('등록성공');");
		out.print("location.href='notice/list.jsp';");
	}else{
		out.print("alert('등록실패');");
		out.print("history.back();");
	}
		out.print("</script>");
	
	
	

%>
<%@page import="com.koreait.project1214.model.repository.MybatisCommentsDAO"%>
<%@page import="com.koreait.project1214.domain.Comments"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	//넘겨받은 파라미터를 이용하여 댓글등록
	request.setCharacterEncoding("utf-8");
	
	String msg = request.getParameter("msg");
	String author= request.getParameter("author");
	int news_id = Integer.parseInt(request.getParameter("news_id"));
	
	Comments comments = new Comments();
	MybatisCommentsDAO mybatiscommentsDAO = new MybatisCommentsDAO();
	
	comments.setNews_id(news_id);
	comments.setMsg(msg);
	comments.setAuthor(author);
	
	int result = mybatiscommentsDAO.insert(comments);
	
	out.println(result);
%>
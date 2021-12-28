<%@page import="com.google.gson.Gson"%>
<%@page import="com.koreait.project1214.domain.Comments"%>
<%@page import="java.util.List"%>
<%@page import="com.koreait.project1214.model.repository.MybatisCommentsDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%! MybatisCommentsDAO mybatisCommentsDAO = new MybatisCommentsDAO();  %>
<%
	int news_id = Integer.parseInt(request.getParameter("news_id"));

	List<Comments> list = mybatisCommentsDAO.selectAll(news_id);
	
	//java의 List를 json 배열로 자동변환해줄 수 있다면..
	
	Gson gson = new Gson();
	out.print(gson.toJson(list));
%>
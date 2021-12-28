<%@page import="com.koreait.project1214.model.repository.MybatisNewsDAO"%>
<%@page import="com.koreait.project1214.model.repository.JdbcNewsDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="news" class="com.koreait.project1214.domain.News"/>
<jsp:setProperty property="*" name="news"/>
<%! JdbcNewsDAO jdbcNewsDAO = new JdbcNewsDAO(); %>
<%! MybatisNewsDAO mybatisNewsDAO = new MybatisNewsDAO();  %>
<%
	//파라미터가 채워졌으므로,  jdbc기반의 DAO에게 일 시키자!!
	int result = mybatisNewsDAO.insert(news);
	out.print(result);
	


%>
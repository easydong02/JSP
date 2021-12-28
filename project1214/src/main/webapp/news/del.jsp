<%@page import="com.koreait.project1214.model.repository.MybatisNewsDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%! MybatisNewsDAO mybatisNewsDAO = new MybatisNewsDAO(); %>
<%
	int news_id = Integer.parseInt(request.getParameter("news_id"));
	out.print(news_id);
	
	int result = mybatisNewsDAO.delete(news_id);

	out.print("<script>");
	if(result !=0){
		out.print("alert('삭제성공!');");
		out.print("location.href='/news/list.jsp'");
	}else{
		out.print("alert('삭제실패!');");
		out.print("history.back();");
		
	}

		out.print("</script>");
%>
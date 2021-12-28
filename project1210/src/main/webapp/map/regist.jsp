<%@page import="com.koreait.project1210.model.repository.MapDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%! MapDAO mapDAO =new MapDAO(); %>
<% request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="map" class="com.koreait.project1210.domain.Map"/>
<jsp:setProperty property ="*" name ="map" />


<%
	int result = mapDAO.insert(map);
	out.print(result);
	
%>
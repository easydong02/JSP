<%@page import="com.koreait.mvc.domain.Dept"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%
	List<Dept> list = (List)request.getAttribute("list");
	
	
	
	Gson gson = new Gson();
	String jsonStr= gson.toJson(list);
	out.print(jsonStr);
%>

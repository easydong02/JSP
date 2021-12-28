<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.koreait.project1210.domain.Map"%>
<%@page import="com.koreait.project1210.model.repository.MapDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%!  MapDAO mapDAO = new MapDAO();%>

<% //방금 요청한 클라이언트의 데이터 가져오기!
	int map_id = Integer.parseInt(request.getParameter("map_id"));

	Map map =mapDAO.select(map_id);
	
	
	JsonObject json = new JsonObject();
	json.addProperty("map_id",map.getMap_id());
	json.addProperty("title",map.getTitle());
	json.addProperty("lati",map.getLati());
	json.addProperty("longi",map.getLongi());
	json.addProperty("filename",map.getFilename());
	
	
	Gson gson = new Gson();
	String jsonStr = gson.toJson(json);
	
	out.print(jsonStr);
	
%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.koreait.project1207.store.model.StoreDAO"%>
<%@page import="com.koreait.project1207.domain.Store"%>
<%@ page contentType="application/json;charset=UTF-8"%>
<%! StoreDAO storeDAO = new StoreDAO(); %>
<%
	//클라이언트가 비동기 요청을 시도하므로, 페이지 전체를 보낼 필요가 없다!! 순수 데이터만 보내자!!
	//json or xml 형태로 보내자!!
	//select * from store where store_id=?
	String store_id = request.getParameter("store_id");
	
	Store store = storeDAO.select(Integer.parseInt(store_id));
	
	//데이터 전송을 위해서 자바의 객체를 json문자열로 전송해야 하는데, 이 json문자열로 변환하는 작업이 너무 효율성이 떨어짐..
	//따라서 외부 라이브러리에 의존해서 효율성을 높여보자!!
	
	//문자열이 아닌 json 객체를 자동으로 생성하기!!
	JsonObject json = new JsonObject(); // "{}"만들어졌다
	json.addProperty("store_id", store.getStore_id());
	json.addProperty("title", store.getTitle());
	json.addProperty("sido", store.getSido());
	json.addProperty("score", store.getScore());
	
	Gson gson = new Gson(); //객체와 문자열 간 자동변환을 담당!!
	String jsonStr = gson.toJson(json); //객체를 ->문자열로
	
	out.print(json);
	System.out.println(json);
%>
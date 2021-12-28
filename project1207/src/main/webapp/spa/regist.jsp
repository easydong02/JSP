<%@page import="com.koreait.project1207.store.model.StoreDAO"%>
<%@page import="com.koreait.project1207.domain.Store"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	//파라미터를 넘겨받아, db에 넣기!!
	request.setCharacterEncoding("utf-8");//파라미터 인코딩
	String title = request.getParameter("title");
	String sido = request.getParameter("sido");
	int score = Integer.parseInt(request.getParameter("score"));
	
	Store store= new Store();
	store.setTitle(title);
	store.setSido(sido);
	store.setScore(score);
	StoreDAO storeDAO=new StoreDAO();
	
	int result = storeDAO.insert(store);
	
	out.print(result);
	
%>
<%@page import="com.koreait.project1207.domain.Store"%>
<%@page import="com.koreait.project1207.store.model.StoreDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%!StoreDAO storeDAO = new StoreDAO();%>
<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="store" class="com.koreait.project1207.domain.Store" />
<jsp:setProperty property="*" name="store" />
<%
	//입력한 파라미터 값들을 받아, db에 수정처리
	//update store set title=?,sido=?,score=? where sotre_id=?
	
	int result = storeDAO.update(store);
	out.print(result);
%>
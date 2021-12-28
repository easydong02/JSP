<%@page import="com.koreait.project1207.store.model.StoreDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%! StoreDAO storeDAO = new StoreDAO(); %>
<%
	int store_id = Integer.parseInt(request.getParameter("store_id"));
	
	int result = storeDAO.delete(store_id);
	out.print(result);
%>
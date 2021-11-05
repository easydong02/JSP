<%@page import="dao.ProductObj"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITEMS</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<jsp:include page = "../header.jsp" />
	
	<%
		ArrayList<ProductObj> products = (new ProductDAO()).getList();
	%>
	
		<div class = "container">
			<h1 class = "display-3">상품 목록</h1>
		</div>
		<div>
			<div class = "container">
				<div class = "row" align = "center">
					<%
						for (ProductObj product : products){
							
					%>
				<div class = "col-md-4">
					<h3><%=product.getPname() %></h3>
					<p><%=product.getPdescription() %>
					<p><%=product.getPprice() %>원
					<p><img src="/photos/<%=product.getPfilename() %>" alt="" width="200" height="200"/>
					<p><a href = "" class = "btn btn-secondary" role = "button">상세정보</a>
				</div>
				<% } %>
			</div>
			<hr>
		</div>
	</div>
	
	<jsp:include page = "../footer.jsp" />
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>
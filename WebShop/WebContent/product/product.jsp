<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="dao.*" %>
<%@ page import ="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<jsp:include page = "../_header.jsp"/>

<%
	ArrayList<ProductObj> products = (new ProductDAO()).getList();

%>
		<div class= "container">
			<h1 class="dispaly-3">상품 목록</h1>
		</div>
		<div class= "container">
			<div class = "row" align="center">
			<%
				for (ProductObj product : products){
			%>
			<div class="col-md-4">
				<h3><%= product.getPname() %></h3>
				<p><%= product.getPdescription() %></p>
				<p><%= product.getPprice() %>원</p>
				<p><a href= "" class="btn btn-secondary" role="button">상세정보</a>
			</div>
			<%} %>
			
			</div>
		</div>
		<hr>

<jsp:include page ="../_footer.jsp"/>
</body>
</html>
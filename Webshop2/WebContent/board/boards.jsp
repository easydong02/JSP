<%@page import="dao.BoardObj"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.BoardDAO"%>
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
		ArrayList<BoardObj> boards = (new BoardDAO()).getList();
	%>
	
		<div class = "container">
			<h1 class = "display-3">글 목록</h1>
		</div>
		<div>
			<div class = "container">
				<div class = "row" align = "center">
					<%
						for (BoardObj board : boards){
							
					%>
				<div class = "col-md-4">
					<h3><%=board.getBtitle() %></h3>
					<p>작성자: <%=board.getBmember() %>
					<p>내용: <%=board.getBcontent() %>
					<p>작성시간: <%=board.getBdate() %>
					<p><img src="/photos/<%=board.getBfilename() %>" alt="" width="200" height="200"/>
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
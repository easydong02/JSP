<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="util.*"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">할일</th>
				<th scope="col">작성시간</th>
				<th scope="col">완료</th>
			
			</tr>
		</thead>


		<tbody>
			<%
				ArrayList<TodoObj> feeds = (new TodoDAO()).getList();

			for (TodoObj feed : feeds) {
			%>


			<tr>
				<th scope="row">1</th>
				<td><%=feed.getTodo()%></td>
				<td><%=feed.getTs()%></td>
				<td>완료</td>
			</tr>


			<%
				}
			%>
		</tbody>
	</table>

</body>
</html>
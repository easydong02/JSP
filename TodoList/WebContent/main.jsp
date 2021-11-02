<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="util.*"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css">
<title>TodoList</title>

<!-- Custom styles for this template -->
<link href="./css/navbar.css" rel="stylesheet">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 512px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExample08" aria-controls="navbarsExample08"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-md-center"
			id="navbarsExample08">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">할일
						목록 <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="./todoAdd.html">할일 등록</a></li>
				<li class="nav-item"><a class="nav-link" href="./delList.jsp">완료 목록</a></li>
				
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown08"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">회원관리</a>
					<div class="dropdown-menu" aria-labelledby="dropdown08">
						<a class="dropdown-item" href="#">회원탈퇴</a> <a
							class="dropdown-item" href="./logout.jsp">로그아웃</a>
					</div>
					<li class="nav-item"><a class="nav-link disabled" href="#">관리자</a>
				</li>
				</li>
			</ul>
		</div>
	</nav>






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
			int i = feeds.size();
			for (TodoObj feed : feeds) {
			%>


			<tr>
				<th scope="row"><%=i%></th>
				<td><%=feed.getTodo()%></td>
				<td><%=feed.getTs()%></td>
				<td><a href="deltodo.jsp?no=<%=feed.getNo()%>">완료</a></td>
			</tr>


			<%
				i--;
			}
			%>
		</tbody>
	</table>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="./js/jquery-slim.min.js"><\/script>')
	</script>
	<script src="./js/bootstrap.bundle.min.js"
		integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
		crossorigin="anonymous"></script>
</body>
</html>
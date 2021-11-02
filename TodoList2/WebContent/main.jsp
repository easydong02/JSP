<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="_head.jsp"%>
  </head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample08" aria-controls="navbarsExample08" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample08">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">할일목록앱 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./todoAdd.html">할일등록</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./dellist.jsp">완료목록</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown08" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">회원관리</a>
        <div class="dropdown-menu" aria-labelledby="dropdown08">
          <a class="dropdown-item" href="#">회원탈퇴</a>
          <a class="dropdown-item" href="./logout.jsp">로그아웃</a>
        </div>
      </li>
        <li class="nav-item">
        <a class="nav-link disabled" href="#">관리자</a>
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
      <th scope="row"><%=i %></th>
      <td><%=feed.getTodo() %></td>
      <td><%=feed.getTs() %></td>
      <td><a href = "deltodo.jsp?no=<%=feed.getNo() %>">완료</a></td>
    </tr>

<% 
	i--;
	}
%>

  </tbody>
</table>

<%@ include file="_footer.jsp"%>
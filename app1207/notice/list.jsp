<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.lang.Math"%>
<%
	int totalRecord = 107;//전제조건,db에 따라 언제든지 바뀜.. 그래서 변수화 시킴(바뀌니까)
	int pageSize=10;//페이지당 보여질 레코드 수
	int totalPage=(int)Math.ceil((double)totalRecord/pageSize);
	int blockSize=10; //블럭당 보여질 페이지 수 (pageSize가 레코드수를 묶은 단위였다면, blockSize는 page들을 묶은 단위
	int currentPage=0;
	if(request.getParameter("currentPage")==null){
		currentPage=1;//현재 페이지
	}else{
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int firstPage; //블락 시작페이지 번호
	for(int i =1;;i+=blockSize){
		if(currentPage -i <0){
			firstPage = i-blockSize;
			break;
		}
	}
	int lastPage=firstPage+blockSize-1;//블락 마지막페이지 번호

	int num= totalRecord - ((currentPage-1)*pageSize); //페이지당 시작번호
%>

<%= "totalRecord= "+totalRecord%><br>
<%= "pageSize= "+pageSize%><br>
<%= "totalPage= "+totalPage%><br>
<%= "currentPage= "+currentPage%><br>
<%= "firstPage= "+firstPage%><br>
<%= "lastPage= "+lastPage%><br>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
  .pageStyle{
	font-weight:bold;
	font-size:15px;
	color:purple;
  }

  </style>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
      
<table class="table table-dark">
	<thead>
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
	<%for(int i =0;i<pageSize;i++){%>
	<%if(num<1){break;}%>
		<tr>
			<td><%=num--%></td>
			<td>해윙</td>
			<td>뱉맨</td>
			<td>2021-12-03</td>
			<td>32</td>
		</tr>
	<%}%>
	<tr>
		<td colspan="5" align="center">
		<%if(firstPage-1>0){%><a href="/notice/list.jsp?currentPage=<%=firstPage-1%>">이전페이지</a><%}else{%><a href="javascript:alert('이전없음');">이전페이지</a><%}%>
			<%for(int i =firstPage;i<=lastPage;i++){%>
				<%if(i>totalPage){break;}%>
				<a href="/notice/list.jsp?currentPage=<%=i%>" <%if(i==currentPage){%>class="pageStyle"<%}%>><%=i%></a>
			<%}%>
			<%if(lastPage+1<=totalPage){%>
		<a href="/notice/list.jsp?currentPage=<%=lastPage+1%>">다음페이지</a>
			<%}else{%>
		<a href="javascript:alert('다음없음');">다음페이지</a>
		<%}%>
		</td>
	</tr>
	</tbody>
</table>
</div>

</body>
</html>


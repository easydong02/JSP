<%@page import="com.koreait.project1207.domain.Notice"%>
<%@page import="com.koreait.project1207.notice.model.NoticeDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%! NoticeDAO noticeDAO= new NoticeDAO(); %>
<%
	int notice_id=Integer.parseInt(request.getParameter("notice_id"));
	
	Notice notice = noticeDAO.select(notice_id);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	//j쿼리는 css 선택자 기반이라 css 선택자 그대로 써도 됨!!
	$($("input[type=button]")[0]).click(function(){
		if(confirm("수정하시겠어요?")){
		$("form").attr("action","/notice/edit");//action지정
		$("form").attr("method","post");// method지정
		$("form").submit(); 
		}
	});
	$($("input[type=button]")[1]).click(function(){
		if(confirm("삭제하시겠어요?")){
		$("form").attr("action","/notice/delete.jsp");//action지정
		$("form").attr("method","post");// method지정
		$("form").submit(); 
		}
	});
	$($("input[type=button]")[2]).click(function(){
			location.href="/notice/list.jsp";
	});
});
</script>
<title>Insert title here</title>
</head>
<body>
<h3>Contact Form</h3>

<div class="container">
  <form>
  	
    <input type="hidden" id="fname" name="notice_id" value="<%=notice.getNoitce_id()%>">
    
    <input type="text" id="fname" name="title" value="<%=notice.getTitle()%>">

    <input type="text" id="lname" name="writer" value="<%=notice.getWriter()%>">

    <textarea id="subject" name="content" placeholder="Content" style="height:200px"><%=notice.getContent()%></textarea>

    <input type="button" value="수정">
    <input type="button" value="삭제">
    <input type="button" value="목록">
  </form>
</div>
</body>
</html>
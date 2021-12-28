<%@page import="com.koreait.project1214.domain.News"%>
<%@page import="com.koreait.project1214.model.repository.MybatisNewsDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%! MybatisNewsDAO mybatisNewsDAO = new MybatisNewsDAO(); %>
<%
	int news_id= Integer.parseInt(request.getParameter("news_id"));

	News news = mybatisNewsDAO.select(news_id);
%>
<!DOCTYPE html>
<html>
<head>
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
	//제이쿼리의 문법구조 = 무엇(선택자)을 . 어떻게(함수) ~~
	$("#bt_edit").click(function(){
		//폼을 제이쿼리로 전송
		if(confirm("수정하시겠어요?")){
			$($("form")[0]).attr({
				"action" : "/news/edit.jsp",
				"method": "post"
			});
			$($("form")[0]).submit();
		}
	});
	$("#bt_del").click(function(){
		//폼을 제이쿼리로 전송
		if(confirm("삭제하시겠어요?")){
			var news_id = $("input[name='news_id']").val();
			location.href="/news/del.jsp?news_id="+news_id;
		}
	});
	
	$("#bt_list").click(function(){
		location.href="/news/list.jsp";
		
	});
	
	$("#bt_comment").click(function(){
		 //비동기 요청을 시도할 때, XMLHttpRequest를 직접 사용하면 코드량이 너무 많다.. 따라서 j쿼리가 지원하는 jquery ajax 사용!
		 $.ajax({
			 "url":"/comments/regist.jsp",
			 type:"post",
			 //주의: 이것은 기존의 form을 이용하는게 아니라 ,자체적인 파라미터명을 지정해서 전송하는 방법
			 data:{
				 "news_id":<%=news.getNews_id()%>,
				 "msg" : $("input[name='msg']").val(),
				 "author": $("input[name='author']").val()
			 },
			 success: function(result,status,xhr){ // xhr은 XMLHttpReqeuest
				 console.log(result);
			 
			 	if(result !=0){
			 		getCommentsList();
			 		
			 	}
			 	//입력 폼 초기화
				$("input[name='msg']").val("");
				$("input[name='author']").val("");
			 },
			 error:function(xhr,status,error){
				 
			 }
		 });
	});
	getCommentsList();
});

//댓글의 목록을 동적으로 출력
function getCommentsList(){
	
	//비동기방식으로 댓글 목록 가져오기
	$.ajax({
		url:"/comments/list.jsp?news_id="+<%=news.getNews_id()%>,
		type:"get",
		success:function(result,status,xhttp){
			//console.log(result); //현재로서는 json이 아닌 String .. 따라서 parsing 필요
			var json =JSON.parse(result); //문자열을 json 객체로 변환
			console.log("총 댓글 게시물 수는 : " + json.length);
			
			//테이블 출력
			printTable(json);
		}
		
	});
}

function printTable(json){
	//누구를, 어떻게?
	var tag = "<table width='100%'>";
	for(var i=0;i<json.length;i++){
		var obj = json[i]; //json 배열에서 객체를 1개 꺼낸다.
		tag+="<tr>";
		tag +="<td>"+obj.msg+"</td>";
		tag +="<td>"+obj.author+"</td>";
		tag +="<td>"+obj.writedate+"</td>";
		tag+="</tr>";
	}
	tag += "</table>";
	
	$("#comments_list").html(tag);
}
</script>
</head>
<body>

<h3>상세보기</h3>

<div class="container">
  <form >
    <input type="hidden" name="news_id" placeholder="Your name.." value= "<%=news.getNews_id()%>">
    <input type="text" name="title" placeholder="Your name.." value= "<%=news.getTitle()%>">

    <input type="text" name="writer" placeholder="Your last name.." value= "<%=news.getWriter()%>">

    <textarea name="content" placeholder="Write something.." style="height:200px"><%=news.getContent()%></textarea>

    <input type="button" value="수정" id ="bt_edit">
    <input type="button" value="삭제" id ="bt_del">
    <input type="button" value="목록" id ="bt_list">
  </form>
</div>
<div>
	<form>
	<input type="hidden" name="news_id" placeholder="Your name.." value= "<%=news.getNews_id()%>">
	<input type="text" placeholder="댓글제목입력" style="width:70%" name ="msg">
	<input type="text" placeholder="작성자"  style="width:20%" name = "author">
	<input type="button" value="댓글등록"  id ="bt_comment" >
	</form>
</div>
<div id = "comments_list"></div>
</body>
</html>
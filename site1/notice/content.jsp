<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=utf-8"%>
<%!
	//JDBC 3총사
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

%>

<%
	String url="jdbc:mysql://localhost:3306/jsp";
	String notice_id = request.getParameter("notice_id");
	String sql ="select * from notice where notice_id="+notice_id;
	

	Class.forName("com.mysql.jdbc.Driver"); //드라이버 로드
	con = DriverManager.getConnection(url,"root","1234");//접속
	

	pstmt = con.prepareStatement(sql);//쿼리 객체 생성
	rs= pstmt.executeQuery(); //쿼리실행
	rs.next(); //커서 한칸 이동

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
<script src="https://cdn.ckeditor.com/4.17.1/standard/ckeditor.js"></script>
<script>

//문서내의 content라는 이름을 가진 요소에 편집기를 이용
function init(){
CKEDITOR.replace('content');

//문서내에 있는 삭제버튼을 누르면..
var bt_del=document.getElementById("bt_del");
console.log("메모리에 올라온 버튼 돔은 ",bt_del);

bt_del.addEventListener("click",function(){
		if(confirm("삭제하실래요?")){
			location.href="/notice/del.jsp?notice_id=<%=notice_id%>";
		}
	});
}

function edit(){
	if(confirm("수정하시겠어요?")){
		//수정시도
		var form2= document.getElementById("form2");
		form2.method="post";
		form2.action="/notice/edit.jsp"; //수정을 담당하는 페이지 요청
		form2.submit();//전송메서드
	}
}





</script>

</head>
<body onload="init();">

<h3>글 상세보기</h3>

<div class="container">
  <form id="form2">
    <input type="hidden" id="fname" name="notice_id" value="<%=rs.getString("notice_id")%>">

    <label for="fname">Title</label>
    <input type="text" id="fname" name="title" value="<%=rs.getString("title")%>">

    <label for="lname">Writer</label>
    <input type="text" id="lname" name="writer" value="<%=rs.getString("writer")%>">

    <label for="subject">Subject</label>
    <textarea id="subject" name="content" style="height:200px"><%=rs.getString("content")%></textarea>
	
    <input type="button" value="수정하기" onclick="edit()">
	<input type="button" value="삭제하기" id= "bt_del">
	<input type="button" value="목록보기" onclick="location.href='/notice/list.jsp';">
  </form>
</div>

</body>
</html>
<%
	if(rs!=null){
		rs.close();
	}
	if(pstmt!=null){
		pstmt.close();
	}
	if(con!=null){
		con.close();
	}


%>
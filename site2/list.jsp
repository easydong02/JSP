<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*"%>

<%!
	String url="jdbc:mysql://localhost:3306/jsp";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

%>

<%
	Class.forName("com.mysql.jdbc.Driver");//드라이버 로드
	con= DriverManager.getConnection(url,"root","1234");//접속시도
	pstmt= con.prepareStatement("select * from gallery order by gallery_id desc");//내림차순 정렬로 가져오기
	rs=pstmt.executeQuery();//select문 수행
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
<script>
	addEventListener("load",function(){
		document.querySelector("button").addEventListener("click",function(){
			location.href="/send.jsp";
		});
	
	});

</script>
</head>
<body>

<h2>갤러리 리스트</h2>

<table>
  <tr>
    <th>이미지</th>
    <th>제목</th>
  </tr>
	<% while(rs.next()){ %>
  <tr>
    <td><img src="/data/<%=rs.getString("filename")%>" width="120px"></td>
    <td><%=rs.getString("title")%></td>
  </tr>
	<%}%>
	<tr>
		<td colspan="2">
			<button>게시물 등록</button>
		</td>
	</tr>
</table>

</body>
</html>

<%
	rs.close();
	pstmt.close();
	con.close();

%>

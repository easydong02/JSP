
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%!
	String url="jdbc:mysql://localhost:3306/jsp?characterEncoding=utf8";
	String id="root";
	String pass="1234";
	
	Connection con; //접속정보 객체
	PreparedStatement pstmt;//쿼리수행 객체
	ResultSet rs; //레코드 결과집합 다루는 객체

%>
<% 
//mysql 데이터 가져오기
Class.forName("com.mysql.jdbc.Driver");
con= DriverManager.getConnection(url,id,pass);
pstmt= con.prepareStatement("select * from notice");//쿼리객체 생성
rs= pstmt.executeQuery();//select 문 수행!!


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
/*프로그래밍 영역
	js에서 개발자가 정의한 함수를 가리켜 사용자 정의 함수라 한다.또한 이 때 사용하는 키워드가
	바로 function 키워드
*/
function getList(){
	//alert("나 눌렀어?");
	location.href="/notice/write.jsp";
}
</script>
</head>
<body>

<h2>게시판 목록</h2>


<table>
  <tr>
    <th>No</th>
    <th>Title</th>
    <th>Writer</th>
	<th>Content</th>
	<th>Date</th>
	<th>Hits</th>
  </tr>

<% while(rs.next()){%>
  <tr>
    <td><%=rs.getInt("notice_id")%></td>
    <td><a href="/notice/content.jsp?notice_id=<%=rs.getInt("notice_id")%>"><%=rs.getString("title")%></a></td>
    <td><%=rs.getString("writer")%></td>
	<td><%=rs.getString("content")%></td>
	<td><%=rs.getString("regdate")%></td>
	<td><%=rs.getInt("hit")%></td>
  </tr>
<% }%>
	<tr>
		<td colspan="5">
			<button onClick="getList()">글등록</button>
		</td>
	</tr>

</table>

</body>
</html>
<%
	if(rs !=null){
		rs.close();
	}
	if(pstmt !=null){
		pstmt.close();
	}
	if(con !=null){
		con.close();
	}

%>

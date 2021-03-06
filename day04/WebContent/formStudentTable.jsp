<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<%

Connection conn =null;			//커넥션
PreparedStatement pstmt =null;	//입력
ResultSet rset=null;			//출력

String driverClass = "org.mariadb.jdbc.Driver";

try{
	Class.forName(driverClass);
}catch(ClassNotFoundException e){
	out.print("JDBC 드라이버 연결 실패");
	
}

String url = "jdbc:mariadb://localhost:3307/univ2";
String id="root";
String pw="1234";

try{
	conn = DriverManager.getConnection(url,id,pw);
	
	
	//SQL..
	String sql = "SELECT * FROM student";
	pstmt =conn.prepareStatement(sql);
	rset=pstmt.executeQuery();
%>

<table class="table table-dark table-striped">
	<caption>학생 정보 검색</caption>
	<tr>
	<th>학번</th>
	<th>이름</th>
	<th>학년</th>
	<th>전공</th>
	<th>주소</th>
	</tr>
	





<% 
	while(rset.next()){
		String studentNo =rset.getString("studentNo");
		String name =rset.getString("name");
		String year =rset.getString("year");
		String dept =rset.getString("dept");
		String addr =rset.getString("addr");
		
%>
		<tr>
		<td><%= studentNo%></td>
		<td><%= name%></td>
		<td><%= year%></td>
		<td><%= dept%></td>
		<td><%= addr%></td>
		</tr>

<%
	}
}catch(Exception e){
	out.print("Maria DB 실패");
}finally{
	//데이터 베이스 연결 종료
	if(pstmt != null){
		try{
			pstmt.close();
		}catch(Exception conerr){
			conerr.printStackTrace();
		}
	}
	if(conn != null){
		try{
			conn.close();
		}catch(Exception conerr){
			conerr.printStackTrace();
		}
	}
}



%>
</table>
</body>
</html>
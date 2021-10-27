<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int cust_studentNo= Integer.parseInt(request.getParameter("studentNo"));
String cust_name= request.getParameter("name");
int cust_year= Integer.parseInt(request.getParameter("year"));
String cust_dept= request.getParameter("dept");
String cust_addr= request.getParameter("addr");


String driverClass = "org.mariadb.jdbc.Driver";


try{
	Class.forName(driverClass);
	out.println("JDBC 드라이버 로딩 성공"+"<br>");
}
catch(ClassNotFoundException e){
	out.print("JDBC드라이버 로딩 실패"+"<br>");
	
}

String url = "jdbc:mariadb://localhost:3307/univ2";
String id = "root";
String pw = "1234";

Connection conn = null;
PreparedStatement pstmt = null;

try{
	conn = DriverManager.getConnection(url,id,pw);
	out.print("MariaDB 서버 연결 성공"+"<br>");
	
	//SQL 처리
	String sql ="INSERT INTO student(studentNo,name,year,dept,addr) VALUES(?,?,?,?,?)";
	
	
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1,cust_studentNo);
	pstmt.setString(2,cust_name);
	pstmt.setInt(3,cust_year);
	pstmt.setString(4,cust_dept);
	pstmt.setString(5,cust_addr);
	
	
	pstmt.executeUpdate();
	out.print("행삽입 성공"+"<br>");
}
catch(SQLException e){
	out.print("MariaDB  실패."+"<br>");
}
finally{
	//데이터 베이스 연결 종료
	if(pstmt != null){
		try{
			pstmt.close();
			out.print("pstmt 연결 종료" +"<br>");
		}catch(Exception conerr){
			conerr.printStackTrace();
		}
	}
	if(conn != null){
		try{
			conn.close();
			out.print("MariaDB 서버 연결 종료" +"<br>");
		}catch(Exception conerr){
			conerr.printStackTrace();
		}
	}
}








%>








</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "java.sql.*" %>

<%@ page import ="dbconnclose.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블 생성</title>
</head>
<body>

<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	
	conn = DbConnClose.getConnection(); //메소드로 연결
	
	
	try{
		String sql = "CREATE TABLE customer("
				+"cust_id varchar(10) NOT NULL,"
				+"cust_pw varchar(10),"
				+ "cust_name varchar(15),"
				+"cust_tel_no varchar(13),"
				+"cust_addr varchar(100),"
				+"cust_gender char(1),"
				+"cust_email varchar(30),"
				+"cust_join_date date,"
				+"primary key(cust_id))";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
			
		
	}catch(SQLException sqlerr){
		out.print("SQL 질의 처리 오류");
	}finally{
		DbConnClose.resourceClose( pstmt, conn);
	}
	
%>



</body>
</html>
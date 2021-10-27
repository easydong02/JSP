<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.time.*" %>

<%@ page import = "java.sql.*" %>
<%@ page import = "dbconnclose.*" %>
<% request.setCharacterEncoding("UTF-8"); %>


   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../common/jsp_sql_dbset.inc" %>
<%
	Connection conn =null;			//연결
	PreparedStatement pstmt =null; 	//sql 전송
	ResultSet rset = null;			//sql 결과
	
conn = DbConnClose.getConnection();

	String sql="INSERT INTO customer VALUES(?,?,?,?,?,?,?,?)";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,cust_id);
	pstmt.setString(2,cust_pw);
	pstmt.setString(3,cust_name);
	pstmt.setString(4,cust_tel_no);
	pstmt.setString(5,cust_addr);
	pstmt.setString(6,cust_gender);
	pstmt.setString(7,cust_email);
	pstmt.setString(8,LocalDate.now().toString());
	
	pstmt.executeUpdate();
	
	DbConnClose.resourceClose(rset, pstmt, conn);
%>


</body>
</html>
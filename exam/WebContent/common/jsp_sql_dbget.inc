
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% //고객 테이블 검색
	
	String sql = "SELECT * FROM customer WHERE (cust_id =?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,cust_id);
	rset = pstmt.executeQuery();
	
	
	//첫번째 레코드로 이동
	rset.next();
	
	cust_id = rest.getString("cust_id");
	String cust_pw= rset.getString("cust_pw");
	String cust_name= rset.getString("cust_name");
	String cust_tel_no= rset.getString("cust_tel_no");
	String cust_addr= rset.getString("cust_addr");
	String cust_gender= rset.getString("cust_gender");
	String cust_email= rset.getString("cust_email");
	String cust_join_date= rset.getString("cust_join_date");
	
%>
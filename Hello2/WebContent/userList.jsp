<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>

<%@page import= "java.sql.*" %>
<%@page import= "util.ConnectionPool" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
/* 	Class.forName("com.mysql.jdbc.Driver"); //Mysql 드라이버를 메모리에 올린다. */
	
/* 	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysns","root","1234"); */
	//conn 객체 생성
	
	Connection conn = ConnectionPool.get();
	
	Statement stmt= conn.createStatement();
	//Statement 객체 생성
	
	ResultSet rs = stmt.executeQuery("SELECT id, name FROM user");
	//SQL을 실행하고 그 실행 결과를 객체로 받는다.
	
	String str="";
	while(rs.next()){
		str +=rs.getString("id") + ", " + rs.getString("name") + "<br>";
	
	}//결과를 한줄한줄 반복해서 목록 생성, ResultSet클래스의 주요 메서드들 - next()반환 boolean 다음레코드가 존재하면 true, first() 반환 boolean 첫번째 레코드로 이동
	
	out.print(str); //목록 출력
	
	rs.close();
	stmt.close();
	conn.close();//객체 모두 닫기




%>
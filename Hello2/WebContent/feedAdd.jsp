<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<%
	request.setCharacterEncoding("utf-8");
String uid = request.getParameter("id");
String ucon = request.getParameter("content");

/* String sql = "INSERT INTO feed(ID,CONTENT) VALUES";
sql += "('" + uid + "','" + ucon + "')";
*/

String sql = "INSERT INTO feed(ID,CONTENT) VALUES(?,?)";

Class.forName("com.mysql.jdbc.Driver"); //Mysql 드라이버를 메모리에 올린다.

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysns", "root", "1234");
//conn 객체 생성

/* Statement stmt = conn.createStatement();
*/
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, uid);
pstmt.setString(2, ucon);


//Statement 객체 생성

int count = pstmt.executeUpdate();
if (count == 1) {
	out.print("글 작성 완료");
} else {
	out.print("글 작성 실패");
}
pstmt.close();
conn.close();//객체 모두 닫기
%>
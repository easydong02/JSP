<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import ="dao.UserDAO" %>
<%-- <%@ page import="java.sql.*"%> --%>
<%
	request.setCharacterEncoding("utf-8");

String uid = request.getParameter("id");
String upass = request.getParameter("pw");
String uname = request.getParameter("name");

/* String sql = "INSERT INTO USER(ID,PASSWORD,NAME) VALUES";
sql += "('" + uid + "','" + upass + "','" + uname + "')";

Class.forName("com.mysql.jdbc.Driver"); //Mysql 드라이버를 메모리에 올린다.

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysns", "root", "1234");
//conn 객체 생성

Statement stmt = conn.createStatement();
//Statement 객체 생성

int count = stmt.executeUpdate(sql); */

UserDAO dao = new UserDAO();

if(dao.exists(uid)){
	out.print("이미 존재하는 아이디입니다.");
	return;
}




boolean count =dao.insert(uid, upass, uname);
if (count == true) {
	out.print("회원 가입 완료");
} else {
	out.print("회원 가입 실패");
}
/* stmt.close();
conn.close();//객체 모두 닫기 */
%>
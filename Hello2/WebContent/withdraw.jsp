<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import ="java.sql.*"%> --%>

<%@ page import ="dao.UserDAO" %>

<%
request.setCharacterEncoding("utf-8");


String uid= request.getParameter("id");


/* String sql = "DELETE FROM USER WHERE ID = ? ";

Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysns","root","1234");
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, uid);


int count = pstmt.executeUpdate(); */


UserDAO dao = new UserDAO();

if(dao.exists(uid)==false){
	out.print("회원정보를 찾을 수 없습니다.");
	return;
}



boolean count =dao.delete(uid);
if (count == true) {
	out.print("회원삭제 완료");
} else {
	out.print("회원삭제 삭제");
}
/* pstmt.close();
conn.close();//객체 모두 닫기 */



%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%!
	String url="jdbc:mysql://localhost:3306/jsp?characterEncoding=utf8";
	String id="root";
	String pass="1234";
	
	Connection con; //접속정보 객체
	PreparedStatement pstmt;//쿼리수행 객체

%>

<%
	Class.forName("com.mysql.jdbc.Driver");

	con = DriverManager.getConnection(url,id,pass);
	//레코드 1건 삭제
	int notice_id = Integer.parseInt(request.getParameter("notice_id"));

	String sql ="delete from notice where notice_id="+notice_id;
	pstmt= con.prepareStatement(sql);
	int result=	pstmt.executeUpdate();
	if(result <=1){
		out.print("삭제성공");
		response.sendRedirect("/notice/list.jsp");
	}else{
		out.print("삭제실패");
	}

	if(pstmt !=null){
		pstmt.close();
	}
	if(con !=null){
		con.close();
	}

%>
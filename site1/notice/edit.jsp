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
	//클라이언트가 전송한 파라미터들을 넘겨받아 db에 반영
	request.setCharacterEncoding("utf-8");
	
	String notice_id = request.getParameter("notice_id");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");

	Class.forName("com.mysql.jdbc.Driver");

	con = DriverManager.getConnection(url,id,pass);

	String sql = "UPDATE notice set title=?,writer=?,content=? where notice_id=?";

	pstmt=con.prepareStatement(sql); //쿼리수행 객체 생성, 아직 쿼리 수행은 하지 않음
		pstmt.setString(1,title);
		pstmt.setString(2,writer);
		pstmt.setString(3,content);
		pstmt.setInt(4,Integer.parseInt(notice_id));
		int result= pstmt.executeUpdate();//쿼리수행 (DML=insert,update,delete)
		if(result==0){
			out.print("쿼리수행 실패<br>");
		}else{
			out.print("글 수정 성공<br>");
			//notice/list.jsp를 새롭게 요청 jsp로 구현
			//response.sendRedirect("/notice/content.jsp?notice_id="+notice_id); 
			
			
			//a태그의 기능을 자바스크립트로 구현
			out.print("<script>");
			out.print("alert('수정완료');");
			out.print("location.href='/notice/content.jsp?notice_id="+notice_id+"';");
			out.print("</script>");
		}
	if(pstmt !=null){
		pstmt.close();
	}
	if(con !=null){
		con.close();
	}

%>
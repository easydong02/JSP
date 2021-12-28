<%	/*
	jsp 파일의 작성영역
	1) 지시영역 @: 현재 페이지의 종류, 인코딩 등을 지정..
	2) 선언부 : 멤버영역, 변수와 메서드를 작성할 수 있다..
	3) 스크립틀릿 : jsp의 로직을 작성하는 영역
	4) 표현식
	*/
%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>

<%@ page contentType="text/html;charset=utf-8"%>
<%!
	String url="jdbc:mysql://localhost:3306/jsp?characterEncoding=utf8";
	String id="root";
	String pass="1234";
	
	Connection con; //접속정보 객체
	PreparedStatement pstmt;//쿼리수행 객체

%>
<%
	//클라이언트가 전송한 전송파라미터들을 받아 보자!!
	
	request.setCharacterEncoding("utf-8");//파라미터에 대한 한글이 깨지지 않도록 인코딩 처리
	

	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content= request.getParameter("content");

	out.print("제목:" +title+"<br>");
	out.print("작성자:" +writer+"<br>");
	out.print("내용:" +content+"<br>");
	
	//넘겨 받은 파라미터들을 이용하여 db에 insert

	/* jdbc 연동 코드 작성 4단계
		1)드라이버 로드
		2)접속
		3)쿼리수행
		4)접속해제
	*/
	Class.forName("com.mysql.jdbc.Driver"); //1)드라이버 로드
	
	out.print("로드성공");
	
	con = DriverManager.getConnection(url,id,pass);
	if(con !=null){
		out.print("접속 성공 <br>");
		
		String sql ="insert into notice(title,writer,content) values(?,?,?)";
		pstmt=con.prepareStatement(sql); //쿼리수행 객체 생성, 아직 쿼리 수행은 하지 않음
		pstmt.setString(1,title);
		pstmt.setString(2,writer);
		pstmt.setString(3,content);
		int result= pstmt.executeUpdate();//쿼리수행 (DML=insert,update,delete)
		if(result==0){
			out.print("쿼리수행 실패<br>");
		}else{
			out.print("글 등록 성공<br>");
			//notice/list.jsp를 새롭게 요청
			response.sendRedirect("/notice/list.jsp");
		}

	}else{
		out.print("접속 실패 <br>");
	}
	
	if(pstmt !=null){
		pstmt.close();
	}
	if(con !=null){
		con.close();
	}
%>




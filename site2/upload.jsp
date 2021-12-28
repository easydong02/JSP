<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.io.File"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.koreait.util.FileManager"%>
<%!
	String url ="jdbc:mysql://localhost:3306/jsp?characterEncoding=utf8";
	Connection con;
	PreparedStatement pstmt;
	FileManager fileManager = new FileManager();
%>
<%
	int maxSize= 1*1024*1024;
	MultipartRequest multi= null;
	//클라이언트가 전송한 바이너리 파일 폼의 데이터를 넘겨 받아 서버에 저장한다.
	try{
	multi= new MultipartRequest(request,"D:/bigData/jsp_workspace/site2/data",maxSize,"utf-8");
	
	//업로드된 이미지명 추출
	String filename= multi.getOriginalFileName("photo");//html의 파일컴포넌트 이름
	out.print("당신이 업로드한 원래 파일명은:"+filename+"<br>");

	//장차 파일명으로 써먹을 시간 구해오기!!
	long time=System.currentTimeMillis(); //밀리세컨드까지 구함
	out.print(time);

	//외부 라이브러리를 이용하여 확장자 구하기
	String ext= fileManager.getExt(filename);
	out.print(ext);

	//최종 저장할 파일명
	String finalName= time+"."+ext;

	//물리적으로 저장된 파일의 이름도, 새로운 이름으로 변경하자!
	File savedFile = multi.getFile("photo"); //현재 서버에 저장된 실제파일..
	savedFile.renameTo(new File("D:/bigData/jsp_workspace/site2/data/"+finalName));
	


	//제목 출력
	String title = multi.getParameter("title");//파라미터 마저도, 업로드 컴포넌트 이용!
	out.print(title);

	//mysql insert
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection(url,"root","1234");

	String sql = "insert into gallery(filename,title) values(?,?) ";
	pstmt = con. prepareStatement(sql);
	pstmt.setString(1,finalName);
	pstmt.setString(2,title);

	int result= pstmt.executeUpdate();
	out.print("<script>");
	if(result==0){
		out.print("alert('등록실패');");
		out.print("history.back();");
	}else{
		out.print("alert('등록성공');");
		out.print("location.href='list.jsp';");
	}
	
	out.print("</script>");

	}catch(IOException e){
		out.print("사진 용량 준수해주세요.");
	
	}
	
	
%>

<script>
alert("업로드 완료");
//location.href="list.jsp";
</script>
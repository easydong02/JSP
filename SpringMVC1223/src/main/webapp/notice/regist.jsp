<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//글쓰기 요청을 처리하는  jsp 
	NoticeDAO noticeDAO = new NoticeDAO();
	int result = noticeDAO.insert();
	
	out.print("<script>");
	if(result==0){
		
	}else{ //성공
		//out.print("location.href='/notice/list.jsp';");
		RequestDispatcher dis  = request.getRequestDispatcher();
		dis.forward(request, response);
	}
	
	response.sendRedirect("/notice/list.jsp"); //지정한 url로 재접속을 유도한다..
	
	out.print("</script>");
%>

<%@page import="com.koreait.project1207.notice.model.NoticeDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%! NoticeDAO noticeDAO = new NoticeDAO(); %>

<%
	
int notice_id = Integer.parseInt(request.getParameter("notice_id"));

	int result=	noticeDAO.delete(notice_id);
	
	if(result ==0){
%>

<script>
alert('삭제실패');
history.back();
</script>

<%}else{%>

<script>
alert('삭제성공');
location.href="/notice/list.jsp";
</script>
<%}%>
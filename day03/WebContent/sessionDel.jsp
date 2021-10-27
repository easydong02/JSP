<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
클라이언트가 브라우저를 종료하면 자동으로 삭제된다.
브라우저 종료를 하지 않더라도 주기적으로 세션의 상태를 확인하여 특정 시간동안 (기본30분)
클라이언트로부터 어떤 요청도 발생하지 않으면 세션을 삭제한다.

<br><br>
세션 속성(id)		: <%=session.getAttribute("id")%><br>
세션 속성(name)	: <%=session.getAttribute("name")%><br>
<br><br>
<%
out.print("세션 생성= " +session.getCreationTime() + "초<br>");
out.print("클라이언트의 해당 세션 마지막 접근 시간= " +session.getLastAccessedTime() + "초<br>");
out.print("클라이언트의  세션 유지 시간= " +(session.getLastAccessedTime()-session.getCreationTime()) + "초<br>");
out.print("세션 유효시간= " +session.getMaxInactiveInterval() + "초<br>");

//세션 객체의 속성 삭제

session.removeAttribute("id");
session.removeAttribute("name");

out.print("세션 객체의 속성을 삭제하였습니다.");
%>
<br><br>
세션 속성(id)		: <%=session.getAttribute("id")%><br>
세션 속성(name)	: <%=session.getAttribute("name")%><br>
<br><br>

<%
	session.invalidate();
	out.print("모든 세션 정보를 삭제하였습니다. <br>");

%>

	<p><a href="sessionCheck.jsp">[세션 정보 확인]</a></p>

</body>
</html>
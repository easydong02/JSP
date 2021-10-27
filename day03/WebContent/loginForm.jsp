<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	String cust_id =(String)session.getAttribute("cust_id");
 	String cust_name =(String)session.getAttribute("cust_name");
 	Boolean login = false;
 	
 	if(cust_id !=null && cust_name !=null){
 		login = true; //로그인 상태
 	}
 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="loginform" method="POST" action="loginCheck.jsp">

	<table>
		<caption>로그인 폼</caption>
			<tr>
			<th>아이디</th>
			<td><input type="text" name="cust_id" size ="10" maxlength="10" required></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="cust_pw" size ="10" maxlength="10" required></td>
			</tr>
			
			<tr>
				<td colspan ="2" style ="text-align:center;">
				
<%
	if(login){ //로그인 상태
		out.print("<input type ='submit' value='로그인' disabled>" + 
					"<input type = 'button' value='(" + cust_name + ")님 로그아웃' " +
					"onClick=location.href='./logout.jsp'></td>");
	}
	else{
		out.print("<input type='submit' value ='로그인'>" + "<input type='button' value='로그아웃' disabled></td>");
	}

%>
			</tr>
	</table>


</form>


</body>
</html>
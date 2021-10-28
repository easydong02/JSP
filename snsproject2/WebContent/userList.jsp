<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="dao.*" %> 
<%@ page import ="java.util.*" %>


<%
	ArrayList<UserObj> list = (new UserDAO()).getList();
	
	String str = "<table align = center>";
	str += "<tr><th colspan =3>가입자 리스트</th></tr>";
	str+= "<tr><td>아이디</td><td>이름</td><td>가입일자</td></tr>";
	for( UserObj user : list){
		str += "<tr><td colspan=3><hr></td>";
		str += "<tr><td>" + user.getId() +"</td>";
		str += "<td>" + user.getName() +"</td>";
		str += "<td>" + user.getTs() +"</td></tr>";
	}
	str+="</table>";
	out.print(str);




%>
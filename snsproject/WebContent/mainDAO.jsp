<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import ="dao.*" %>
<%@ page import = "java.sql.*"%>
<%@ page import = "java.util.ArrayList" %>
<%-- <%@ page import = "util.ConnectionPool"%>
 --%>
<%

String uid =(String) session.getAttribute("id");
if(uid ==null){
	response.sendRedirect("login.html");
	return;
}
session.setAttribute("id", uid); //세션 유효시간 초기화

String str = "<table align=center>";
str += "<tr height=40><td><b>작성글 리스트</b></td>";
str += "<td align =right>";
str += "<a href = 'feedAdd.html'><button>글쓰기</button></a>";
str += "</td></tr>";


/* String sql = "SELECT * FROM FEED ORDER BY TS DESC"; */

/* Connection conn = ConnectionPool.get();
PreparedStatement pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery(); */

/* ResultSet rs = (new FeedDAO()).getList(); */

ArrayList <FeedObj> feeds= (new FeedDAO()).getList();
str += "<tr><th colspan=2> 작성글 리스트 </th></tr>";


for (FeedObj feed : feeds){
	String img = feed.getImages(), imgstr="";
	if(img != null){
		imgstr="<img src='images/"+img +"'width=240>";
	}
	str +="<tr><td colspan=2><hr></td></tr>";
	str +="<tr>";
	str +="<td><small>" + feed.getId()+"</small></td>";
	str +="<td><small>(" + feed.getTs()+")</small></td>";
	str +="</tr>";
	str +="<tr><td colspan =2>" +imgstr+ "</td></tr>";
	str += "<tr><td colspan=2>" + feed.getContent()+"</td></tr>";
	
}


str += "</table>";
out.print(str);

/* rs.close(); */
/* pstmt.close();
conn.close(); */





%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import ="dao.*" %>
<%@ page import = "java.sql.*"%>
<%@ page import = "java.util.ArrayList" %>
<%-- <%@ page import = "util.ConnectionPool"%>
 --%>
<%
/* String sql = "SELECT * FROM FEED ORDER BY TS DESC"; */

/* Connection conn = ConnectionPool.get();
PreparedStatement pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery(); */

/* ResultSet rs = (new FeedDAO()).getList(); */


String str = "<table align = center>";
str += "<tr><th colspan=2> 작성글 리스트 </th></tr>";
ArrayList <FeedObj> feeds= (new FeedDAO()).getList();

for (FeedObj feed : feeds){
	str +="<tr><td colspan=2><hr></td></tr>";
	str +="<tr>";
	str +="<td><small>" + feed.getId()+"</small></td>";
	str +="<td><small>(" + feed.getTs()+")</small></td>";
	str +="</tr>";
	str += "<tr><td colspan=2>" + feed.getContent()+"</td></tr>";
	
}


str += "</table>";
out.print(str);

/* rs.close(); */
/* pstmt.close();
conn.close(); */





%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>
<%@ page import = "util.ConnectionPool"%>

<%

String sql = "SELECT * FROM FEED ORDER BY TS DESC";

Connection conn = ConnectionPool.get();
PreparedStatement pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();

String str = "<table align = center>";
str += "<tr><th colspan=2> 작성글 리스트 </th></tr>";

while (rs.next()){
	str +="<tr><td colspan=2><hr></td></tr>";
	str +="<tr>";
	str +="<td><small>" + rs.getString("id")+"</small></td>";
	str +="<td><small>(" + rs.getString("ts")+")</small></td>";
	str +="</tr>";
	str += "<tr><td colspan=2>" + rs.getString("content")+"</td></tr>";
	
}


str += "</table>";
out.print(str);

rs.close();
pstmt.close();
conn.close();





%>
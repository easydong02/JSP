<%@page import="dao.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITEMS</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
  <jsp:include page = "../header.jsp" />
   
   <%
      ArrayList<MemberObj> members = (new MemberDAO()).getList();
   %>
   
      <div class = "container">
         <h1 class = "display-3">고객 목록</h1>
      </div>
      
      <div>
         <div class = "container">
            <div class = "row" align = "center">
               <%
                  for (MemberObj member : members) {
                     
               %>

               <%=member.getCid() %>
               <%=member.getCname() %>
               <%=member.getCemail() %>
               <%=member.getCphone() %>
               
               <p><a href = "" class = "btn btn-secondary" role = "button">상세정보</a>

            <% } %>
</p>
</div>
</div>
   
   <jsp:include page = "../footer.jsp" />
   
   
   
</body>
</html>
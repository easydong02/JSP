<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page = "_header.jsp" />

<%! String greeting = "쇼핑몰 방문을 환영합니다." ;
   String tagline = "Welcome to Web Shop !!";
%>
   <div class="jumbotron">
      <div class ="container">
      
      <h1 class="display-3">
         <%=greeting %>
      </h1>
      </div>
   </div>
   
   <div class="container">
      <div class = "text-center">
      <h2>
         <%=tagline %>
      </h2>

   <%
      response.setIntHeader("Refresh", 5);
      Date day = new java.util.Date();
      String am_pm;
      int hour = day.getHours();
      int minute = day.getMinutes();
      int second = day.getSeconds();
      
      if (hour / 12 < 1) {
         am_pm = "AM";
      } else {
         am_pm = "PM";
         hour = hour - 12;
      }
      String CT = hour + ":" + minute + ":" + second + " " + am_pm;
      out.print("현재 접속 시각 : " + CT + "\n");
   %>
      </div>

   <hr>

   </div>

<jsp:include page = "_footer.jsp" />

</body>
</html>
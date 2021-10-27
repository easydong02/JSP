<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="calc" class="cal.Calculator" />     <!-- 객체 생성 -->
<jsp:setProperty name ="calc" property="*"/>		<!-- 세터호출 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>계산 결과 - Bean</h2>
<hr>
결과: <%=calc.calc() %>



</body>
</html>
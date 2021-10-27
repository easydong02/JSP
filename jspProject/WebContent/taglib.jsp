<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
taglib 태그는 현재 jsp 페이지에 JSTL, 사용자 정의 태그 등을 설정하는 태그


JSTL 유용한 jsp 모음 자주 사용되는 기능들을 제공한다.
반복문, 조건문, XML 문서조작, 국제화, SQL
<br><br>



<c: out value="JSTL Core 태그 라이브러리" />
<br><br>

<c:forEach var="k" begin="1" end="10" step="1">
	<c:out value="$(k)"/>
</c:forEach>


</body>
</html>
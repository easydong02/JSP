<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Java Bean : class(*) / object
JSP 에서는 HTML과 Java 코드를 분리하기 위해 사용한다.
프로그램의 중복을 줄이고 원활하게 유지 보수 가능

JSP에서 선언하는 방법
<jsp:useBean id="mybean" class="MyBean"></jsp:useBean>
id bean의 인스턴스로 사용할 변수  이름


(자바에서)
MyBean mybean = (Mybean)requset.getAttribute("mybean");

JSP Beans를 선언하면 setProperty getProperty 액션을 통해서 값을 설정하고 가져올 수 있다.

<jsp:setProperty property="mybean" name="userid"/>
<jsp:setProperty property="mybean" name="userpasswd"/>




</body>
</html>
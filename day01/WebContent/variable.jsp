<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지역변수와 전역변수</title>
</head>
<body>
<%!
	//전역 변수 선언
	int globalvar=0;



%>

<%

	int localvar=0;
	out.print("global var = "+ globalvar++ + "<br>");
	out.print("local var = "+ localvar++ + "<br>");
/*
변수 variable 데이터를 저장하기 위한 장소를 가리키는 이름을 말한다.
데이터형 변수명 String a = "변수";

데이터 형
	int 숫자
	double 실수
	String 문자열(***) 기본형이 아니어서 원래는 객체를 생성하고 사용을 해야하지만 그냥 사용 가능
	String a = "문자열";

상수 constatnt는 항상 일정한 수, 값이 변하지 않는다. 관례적으로 대문자를 사용한다.
	int MAX_SIZE = 10;
	String ID = "root";
	boolean FLAG = True;
*/

%>
</body>
</html>
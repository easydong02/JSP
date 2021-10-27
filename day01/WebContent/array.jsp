<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
배열은 여러 개의 데이터를 하나의 이름으로 저장하고 사용하는 데이터 구조
여러 개의 변수명을 가각 사용하는 불편함을 해소하고 반복처리를 용이하게 쓸 수 있다.


데이터형 [] 배열명;
배열명 = new 데이터형[원소수]; //한번 생성한 배열의 원소 갯수는 변경할 수 없다.

데이터형[] 배열명 = new 데이터형[원소수];

<%
	int[] jumsu;
	jumsu = new int[3];
	
	jumsu[0] = 89;
	jumsu[1] = 90;
	jumsu[2] = 100;

	int total = jumsu[0]+jumsu[1]+jumsu[2];
	double avg = total/3.0;

%>

<br><%=jumsu[0] %><br>
<%=jumsu[1] %><br>
<%=jumsu[2] %><br>
total =<%=total %><br>
avg =<%=avg %><br>


</body>
</html>
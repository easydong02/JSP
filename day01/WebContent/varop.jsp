<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
	int su1 = 10;
	int su2 = 1;
	//2개의 정수를 비교해서 su1이 su2보다  크거나 같으면 덧셈을 아니면 2개의 정수를 교환해서 큰수에서 작은 수 빼기

	%>
	
<%
	int result = 0;
	int temp = 0;

	if(su1>=su2)
	{
		result = su1 + su2;
	}else
	{
		temp = su1;
		su1 = su2;
		su2 = temp;
		result = su2 - su1;
	}
	
%>

연산 결과: <%= result %>


</body>
</html>
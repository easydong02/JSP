<%@ include file = "./include/inc_header.jsp" %>




<!-- forward액션태그는 include와 동작방식은 동일하지만 약간 차이가 있다.
	현재 웹페이지에서 다른 페이지로 이동할 때 주로 사용된다. 

	forward와 redirect의 차이점 - 
	forward 이동되는 url 주소로 변경되지만 브라우저 주소창은 변하지 않는다.뒤에 오는 jsp코드도 실행되지 않는다.
	redirect 브라우저의 주소창이 바뀐다. jsp코드도 실행된다.
	

-->

<% String msg = "forward 액션태그 테스트"; %>

<jsp:forward page="./include/sum.jsp"/>

<%=msg %>





<%@ include file = "./include/inc_bottom.jsp" %>
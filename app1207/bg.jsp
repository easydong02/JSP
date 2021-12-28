<%@ page contentType="text/html;charset=utf-8"%>
<%
	String color=request.getParameter("color");


%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<script>
/*
window.addEventListener("load",function(){
	var bt1= document.getElementById("bt1");
	bt1.addEventListener("click",function(){
		//js로 처리할 경우
		//document.body.style.background="skyblue";

		//jsp를 요청해서 할 경우(즉 서버상의 jsp를 요청하여 배경색 바꾸기)
		location.href="/bg.jsp?color=green";
	});
});
*/

function setBg(c){
	location.href="/bg.jsp?color="+c;
}

</script>

</head>
<body bgcolor="<%=color%>">
	<button id="bt1" onClick="setBg('red')">RED</button>
	<button id="bt2" onClick="setBg('orange')">Orange</button>
	<button id="bt3" onClick="setBg('yellow')">Yellow</button>
	<button id="bt4" onClick="setBg('green')">Green</button>
	<button id="bt5" onClick="setBg('blue')">Blue</button>
	<button id="bt6" onClick="setBg('navy')">Navy</button>
	<button id="bt7" onClick="setBg('purple')">Purple</button>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<% 


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function send(){
	var form1 = document.getElementById("form1");
	form1.action="/blood.do";
	form1.method="post";
	form1.submit();
}
</script>
</head>
<body>

	<form id ="form1">
		<select name ="blood">
			<option>혈액형을 선택하세요</option>
			<option value="A">A</option>
			<option value="B">B</option>
			<option value="AB">AB</option>
			<option value="O">O</option>
		</select>
	</form>
	<br>
	<button onclick="send()">전송</button>

</body>
</html>
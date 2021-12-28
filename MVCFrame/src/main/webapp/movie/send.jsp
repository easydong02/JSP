<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function send(){
	var form1 =document.getElementById("form1");
	form1.action="/movie.do";
	form1.method="post";
	form1.submit();
}

</script>
</head>
<body>
	<form id ="form1">
		<select name = "movie">
			<option value ="매트릭스">매트릭스</option>
			<option value ="어바웃타임">어바웃타임</option>
			<option value ="다크나이트">다크나이트</option>
			<option value ="건축학개론">건축학개론</option>
		</select>
		<input type ="button" onclick="send()" value ="선택">
	</form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
function regist(){
	//폼을 서버로 전송한다!!
	form1.action="upload.jsp";
	form1.method="post";
	form1.encoding="multipart/form-data"
	form1.submit();
}
</script>
</head>
<body>
	<form name ="form1">
		<input type="file" name = "filename">
		<button type ="button" onclick="regist()">엑셀파일 등록</button>
	</form>
</body>
</html>
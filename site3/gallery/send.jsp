<%@ page contentType="text/html;charset=utf-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<style>
input{
	width:300px;
	border:1px solid blue;
}
</style>
<script>
addEventListener("load",function(){
	//메모리에 올라온 문서 내의 돔 중 버튼을 제어하자
	document.querySelector("button").addEventListener("click",function(){
		//업로드 요청 시도
		regist();
	});
});

//http 메서드 중 poset 방식으로 요청을 시도해야 한다.. 이유? 바이너리 파일이 포함되어 있고,
//데이터양이 많기 때문
function regist(){
	//전송준비
	var form = document.querySelector("form");
	form.method="post";
	form.action="/gallery/regist";
	form.submit();
}
</script>
</head>
<body>
	<form enctype="multipart/form-data">
		<div>
			<input type="text" name ="title">
			<br>
			<input type="file" name = "photo">
			<p>
			<button type="button">업로드</button>
			</p>
		</div>
	</form>
</body>
</html>

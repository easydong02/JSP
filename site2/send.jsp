<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

.input-container {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  width: 100%;
  margin-bottom: 15px;
}

.icon {
  padding: 10px;
  background: dodgerblue;
  color: white;
  min-width: 50px;
  text-align: center;
}

.input-field {
  width: 100%;
  padding: 10px;
  outline: none;
}

.input-field:focus {
  border: 2px solid dodgerblue;
}

/* Set a style for the submit button */
.btn {
  background-color: dodgerblue;
  color: white;
  padding: 15px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}
</style>
<script>
window.addEventListener("load",function(){
	var bt= document.querySelector("button");
	bt.addEventListener("click",function(){
		send();
	});
});

//업로드(클라이언트가 선택한 이미지 및 입력폼 데이터를 서버로 전송하자!!)
function send(){
	var form=document.querySelector("form");//dom을 접근하는 또 다른 방법..
	form.action="/upload.jsp";//요청주소
	form.method="post";//전송메서드
	form.encoding="multipart/form-data";//폼태그를 이용하여 서버에 데이터 전송시, 입력폼 뿐만 아니라 바이너리 파일이 포함되어 있다면, 복합적인 인코딩 방식을 채택해야 한다.(필수)
	form.submit();//전송
}

</script>
</head>
<body>

<form style="max-width:500px;margin:auto">
  <h2>이미지 업로드 폼</h2>
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <input class="input-field" type="text" placeholder="이미지 제목" name="title">
  </div>

  
  <div class="input-container">
    <i class="fa fa-key icon"></i>
    <input type="file" name="photo">
  </div>

  <button class="btn">업로드</button>
</form>

</body>
</html>

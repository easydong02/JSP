<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	//j쿼리는 css 선택자 기반이라 css 선택자 그대로 써도 됨!!
	$("input[type=button]").click(function(){
		$("form").attr("action","/notice/regist.jsp");//action지정
		$("form").attr("method","post");// method지정
		$("form").submit(); //전송
	});
});
</script>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form>
  
    <input type="text" id="fname" name="title" placeholder="Title">

    <input type="text" id="lname" name="writer" placeholder="Writer">

    <textarea id="subject" name="content" placeholder="Content" style="height:200px"></textarea>

    <input type="button" value="글 등록">
  </form>
</div>

</body>
</html>

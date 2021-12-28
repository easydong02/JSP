<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], input[type=number],select, textarea {
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
var json;
$(function(){
	//getDeptList();
	
	//셀렉트 상자에 이벤트 연결
	/* $("select").on("change",function(){
		var index= this.selectedIndex-1;
		$("input[name='dname']").val(json[index].dname);
		$("input[name='loc']").val(json[index].loc);
	}); */
});

function getDeptList(){
	$.ajax({
		url:"/dept/list.do",
		type:"get",
		success:function(result,status,xhr){
			console.log(result);
			
			json = JSON.parse(result);
			
			for(var i =0;i<json.length;i++){
				var dept = json[i]; //부서하나 꺼내기
				$("select").append($("<option></option>").attr("value",dept.deptno).text(dept.dname));
			}
		}
	});
}

//입력폼을 서버로 전송한다.
function regist(){
	form1.action="/emp/regist.do";
	form1.method="post";
	form1.submit();
}
</script>
</head>
<body>

<h3>사원 등록</h3>

<div class="container">
  <form name ="form1">
  <!-- 부서정보  -->
  <!--
  	<select name="deptno" >
  		<option>부서선택</option>
  		
  		  -->
  		
  	
  	</select>
    <input type="text"  name="deptno" 	placeholder="Your deptno..">
    <input type="text"  name="dname" 	placeholder="Your dname..">
    <input type="text"  name="loc" 		placeholder="Your loc..">
    
    <!-- 사원정보 -->
    <input type="number"  name="empno" placeholder="Your no..">
    <input type="text"  name="ename" placeholder="Your name..">
    <input type="text"  name="job" placeholder="Your job..">
    <input type="text"  name="sal" placeholder="Your sal..">
    
    <!-- 프로필 사진 -->
    <input type = "file" name ="photo">
    
    
    <input type="button" value="Submit" onClick="regist()">
  </form>
</div>

</body>
</html>

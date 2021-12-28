<%@ page contentType="text/html;charset=UTF-8"%>
<%
String[] sido = {"서울", "인천", "대전", "대구", "울산", "부산"};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Single Page Application</title>
<style>
body {
	margin: 0px;
}

.wrapper {
	background: yellow;
	width: 1000px;
	height: 700px;
	overflow: hidden;
	margin: auto;
}

.input_area {
	width: 200px;
	height: 100%;
	background: pink;
	float: left;
}

#list_area {
	width: 600px;
	height: 100%;
	float: left;
}

.detail_area {
	width: 200px;
	height: 100%;
	float: left;
	background: orange;
}
</style>
<script>
	addEventListener("load", function() {
		var bt_regist = document.getElementById("bt_regist");
		bt_regist.addEventListener("click", function() {
			registAsync();
		});
		bt_edit.addEventListener("click", function() {
			if(confirm("수정하시겠어요?")){
				editAsync();
			}
		});
		bt_del.addEventListener("click", function() {
			if(confirm("삭제하시겠어요?")){
				delAsync();
			}
		});

		getList(); //문서가 로드되면, 곧바로 비동기로 데이터 가져오기!!
	});
	
	//비동기 삭제요청
	function delAsync(){
		//게시물을 선택하지 않고, 삭제를 누르면 경고!
		if(form2.store_id.value.length==0){
			alert("게시물을 선택해주세요");
			return;
		}
		
		
		var xhttp = new XMLHttpRequest(); //형님 실행부대신 비동기 통신 가능한 객체...
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				//alert("서버로부터 받은 데이터는" + this.responseText);
				if (this.responseText == 1) {
					//서버에게 목록을 요청한다!!(비동기... 데이터만 가져올거라)
					getList();

				} else {
					alert("삭제실패");
				}
			}
		};
		xhttp.open("get", "/spa/del.jsp?store_id="+form2.store_id.value);
		xhttp.send();
	}
	
	//비동기 수정요청
	function editAsync(){
		var xhttp = new XMLHttpRequest(); //형님 실행부대신 비동기 통신 가능한 객체...
		xhttp.open("post", "/spa/edit.jsp");
		xhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded"); //포스트 방식으로 데이터 전송 
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				//alert("서버로부터 받은 데이터는" + this.responseText);
				if (this.responseText == 1) {
					//서버에게 목록을 요청한다!!(비동기... 데이터만 가져올거라)
					getList();

				} else {
					alert("수정실패");
				}
			}
		};
		var store_id = form2.store_id.value;
		var title = document.getElementById("title2").value;
		var sido = document.getElementById("sido2").value;
		var score = document.getElementById("score2").value;

		xhttp.send("store_id="+store_id+ "&title=" + title + "&sido=" + sido + "&score=" + score);//요청 시작!
	}

	//기존의 전송방식대로 처리해보자!!(서버의 요청을)
	function registSync() {
		var form1 = document.getElementById("form1");
		form1.action = "/spa/regist.jsp";
		form1.method = "post";
		form1.submit();
	}

	//비동기 방식으로 요청을 시도하여, 페이지 전부를 갱신하지 말고, 서버로부터 가져온 데이터를 이용한
	//일부 페이지의 갱신만 시도해보겠다 = without reloading

	function registAsync() {

		var xhttp = new XMLHttpRequest(); //형님 실행부대신 비동기 통신 가능한 객체...
		xhttp.open("post", "/spa/regist.jsp");
		xhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				//alert("서버로부터 받은 데이터는" + this.responseText);
				if (this.responseText == 1) {
					//서버에게 목록을 요청한다!!(비동기... 데이터만 가져올거라)
					getList();

				} else {
					alert("등록실패");
				}
			}
		};
		var title = document.getElementById("title").value;
		var sido = document.getElementById("sido").value;
		var score = document.getElementById("score").value;

		xhttp.send("title=" + title + "&sido=" + sido + "&score=" + score);//요청 시작!
	}

	//비동기 방식으로 리스트 요청하기
	function getList() {
		var xhttp = new XMLHttpRequest(); //비동기 객체 생성
		xhttp.open("post", "/spa/list.jsp");//요청 주소 및 요청 메서드 지정

		xhttp.onreadystatechange = function() { //이벤트 핸들링
			if (this.readyState == 4 && this.status == 200) {//서버의 응답이 성공적으로 도달
				//현재 시점에서는 responseText 자체는 문자열 이었다.. 따라서 json이 보유한 storeList 라는 속성을 이해할 수 없다!
				//console.log(this.responseText);
				var json = JSON.parse(this.responseText);//제이슨표기로 작성된 문자열을 실제 json객체로변환해주는 메서드!	
				//console.log(json);

				//화면 일부 출력
				printTable(json);
			}
		}
		xhttp.send();
	}

	//리스트에 테이블을 출력한다!!
	function printTable(data) {
		console.log("매개변수로 전달된 객체는", data);
		var list = document.getElementById("list_area");
		var tag = "<table border='1px' width ='100%'>"
		tag += "<tr>";
		tag += "<td width='70%'> 제목</td>";
		tag += "<td width='20%'> 지역</td>";
		tag += "<td width='10%'> 평점</td>";
		tag += "</tr>";
		//반복할 대상
		for (var i = 0; i < data.storeList.length; i++) {
			var obj = data.storeList[i]; //{store_id: 1, title: '일산맛집', sido: '인천', score: 3}

			tag += "<tr>";
			tag += "<td><a href=\"javascript:getDetail("+obj.store_id+");\">" + obj.title
					+ "</a></td>";
			tag += "<td>" + obj.sido + "</td>";
			tag += "<td>" + obj.score + "</td>";
			tag += "</tr>";
		}
		tag += "</table>";

		list.innerHTML = tag;
	}

	function getDetail(store_id) {
		//데이터 한건을 가져오기 위한 비동기 요청을 시도하자!!(js자체에서 해결하지 않는 이유 - 또한번 공부하려고..)
		
		var xhttp = new XMLHttpRequest();
		xhttp.open("get","/spa/content.jsp?store_id="+store_id);
		xhttp.onreadystatechange= function(){
			if(this.readyState ==4 && this.status ==200){
				//화면에 반영...
				console.log(this.responseText);
				//결론.. this.responseText로 받은 데이터는 json 객체는 아니고, json표기법을 지킨 그냥 문자열
				//해결: 객체화되지 않았으므로, .찍고 접근불가 따라서 문자열을 json 객체로변환
				var json = JSON.parse(this.responseText);
				//console.log(json.title);
				
				//화면에 출력
				printDetail(json);
			}
		}
		xhttp.send();
		
		//pk값을 히든에 보관해두자! (추후 수정 또는 삭제시 사용)
		form2.store_id.value= store_id;
	}
	
	function printDetail(data){
		var title2= document.getElementById("title2");
		var sido2= document.getElementById("sido2");
		var score2= document.getElementById("score2");
		
		title2.value=data.title;
		sido2.value=data.sido;
		score2.value=data.score;
	}
</script>
</head>
<body>
	<!-- 모든 html 태그는 다른 태그요소와의 배치문제에 있어서 block(동일 라인에 공존을 허용X), inline중 하나 -->
	<div class="wrapper">
		<div class="input_area">
			<form id="form1">
				<input type="text" placeholder="제목" id="title"> <br> <select
					id="sido">
					<%
					for (int i = 0; i < sido.length; i++) {
					%>
					<option value="<%=sido[i]%>"><%=sido[i]%></option>
					<%
					}
					%>
				</select> <select id="score">
					<%
					for (int i = 1; i <= 5; i++) {
					%>
					<option value="<%=i%>"><%=i%></option>
					<%
					}
					%>
				</select>
				<button type="button" id="bt_regist" onclick="this.innerText='나버튼'">등록</button>
			</form>
		</div>
		<div id="list_area">목록</div>
		<div class="detail_area">
			<form id="form2" name ="form2">
			<input type="hidden" id = "store_id" name = "store_id">
				<input type="text" placeholder="제목" id="title2" name ="title2"> <br> <select
					id="sido2">
					<%
					for (int i = 0; i < sido.length; i++) {
					%>
					<option value="<%=sido[i]%>"><%=sido[i]%></option>
					<%
					}
					%>
				</select> <select id="score2">
					<%
					for (int i = 1; i <= 5; i++) {
					%>
					<option value="<%=i%>"><%=i%></option>
					<%
					}
					%>
				</select>
				<button type="button" id="bt_edit" >수정</button>
				<button type="button" id="bt_del" >삭제</button>
			</form>
		</div>
	</div>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPA기반 구글맵</title>
<style>
.wrapper{
	width:1200px;
	height:800px;
	background:yellow;
	margin:auto;
	overflow:hidden;
}

.regist_area{
	width:200px;
	height:100%;
	background:pink;
	float:left;
}

#map_area{
	width:1000px;
	height:100%;
	background:dodgerblue;
	float:left;
}
</style>
<script>
var map;

addEventListener("load",function(){
	var bt = document.querySelector("button");
	var buffer = document.querySelector("#buffer");
	var lati = document.querySelector("#lati");
	var longi = document.querySelector("#longi");
	bt.addEventListener("click",function(){
		registAsync();
	});
	
	//버퍼 창에 블러이벤트 적용
	buffer.addEventListener("blur",function(){
		var str = this.value.split(",");
		lati.value = str[0].trim();  //위도
		longi.value = str[1].trim();  //경도 + 공백 제거
	});
});

//서버에 비동기 요청
function registAsync(){
	var xhttp = new XMLHttpRequest();
	xhttp.open("post","/map/regist.jsp");
	xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	
	var title = document.getElementById("title").value;
	var lati = document.getElementById("lati").value;
	var longi = document.getElementById("longi").value;
	var filename = document.getElementById("filename").value;
	
	xhttp.send("title="+title+"&lati="+lati+"&longi="+longi+"&filename=" +filename );
	
	xhttp.onreadystatechange = function(){
		if(this.readyState==4 && this.status ==200){
			//alert(this.responseText);
			
			if(this.responseText > 0){
				//마커 생성 및 데이터 출력
				
				getDetail(this.responseText);
			}else{
				console.log("등록실패");
				
			}
		}
	}
}

//방금 들어간 정보를 가져오기!!
function getDetail(map_id){
	var xhttp = new XMLHttpRequest();
	xhttp.open("get","/map/content.jsp?map_id=" + map_id);
	xhttp.onreadystatechange = function(){
		if(this.readyState ==4 && this.status ==200){
			var json = JSON.parse(this.responseText);
			console.log(json.title); 
			
			//제이슨 파싱
			showIcon(json);
		}
	}
	xhttp.send();
}

function initMap(){
	//구글맵 객체 생성
	var mapProp= {
	  center:new google.maps.LatLng(37.496049042480465, 126.89696579292306),
	  zoom:18
	};
	map = new google.maps.Map(document.getElementById("map_area"),mapProp);
}

function showIcon(json){
	var marker = new google.maps.Marker({position: new google.maps.LatLng(json.lati ,json.longi )
	,animation:google.maps.Animation.BOUNCE });

	marker.setMap(map);
}

</script>
</head>
<body>

	<div class="wrapper">
		<div class="regist_area">
		<input type="text" placeholder="제목" id='title'><br>
		<input type="text" placeholder="위도 및 경도" id ="buffer" style= "background:yellow"><br>
		<input type="text" placeholder="위도" id ="lati"><br>
		<input type="text" placeholder="경도" id = "longi"><br>
		<select id ="filename">
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
		
		
		</select>
		<button type="button">등록</button>
		</div>
		<div id ="map_area"></div>
	</div>

</body>
</html>



<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCiq5_Pqy-8IUCQqE5--GLky2wdZypQkEs&callback=initMap"></script>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<body>

<h1>My First Google Map</h1>

<div id="googleMap" style="width:100%;height:800px;"></div>

<script>
function initMap() {
var mapProp= {
  center:new google.maps.LatLng(37.496049042480465, 126.89696579292306),
  zoom:15,
};
var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

//마커 적용하기
var marker = new google.maps.Marker({position: mapProp.center,
	animation:google.maps.Animation.BOUNCE,
	icon: {url:'/images/luck.png',
			scaledSize: new google.maps.Size(50,50)}});
marker.setMap(map);

//메시지 창 띄우기
var infowindow = new google.maps.InfoWindow({
	  content:"우리집"
	});

	infowindow.open(map,marker);
}


</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCiq5_Pqy-8IUCQqE5--GLky2wdZypQkEs&callback=initMap"></script>

</body>
</html>
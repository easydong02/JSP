<%@page import="com.google.gson.Gson"%>
<%@page import="com.koreait.project1210.domain.Map"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.util.List"%>
<%@page import="com.koreait.project1210.model.repository.MybatisMapDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%! MybatisMapDAO mapDAO= new MybatisMapDAO(); %>
<%

List<Map> list = mapDAO.selectAll();



//제이슨으로 출력하자!!
//그리고 이 서버측의 코드를 접근하는 클라이언트는 제한이 없는 것이다..(착각: 브라우저만 웹서버에 접근할 수 있는 게 아니다!!)
//따라서, Restful 하면서 다양한 디바이스를 위한 서버라면 가급적 응답데이터로써 HTML에만 한정짓지 말고, 중립적인 데이터를 제공하는게 요즘 추세
//이때 선택할 수 있는 중립적 데이터 타입이라면(즉 이기종간 데이터 교환을 위한 데이터 타입) JSON, XML
//


JsonObject json = new JsonObject();

for(Map map : list ){
json.addProperty("map_id", map.getMap_id());
json.addProperty("title", map.getTitle());
json.addProperty("lati", map.getLati());
json.addProperty("longi", map.getLongi());
json.addProperty("filename", map.getFilename());
}

Gson gson = new Gson();
String result = gson.toJson(json);

out.print(result);

%>
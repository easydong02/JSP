<%@page import="java.io.InputStreamReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="dao.*"%>
<%@ page import ="java.io.*"%>


<%
	String str = "", line="";

	str +="Content type:" + request.getContentType() +"<br>";
	str +="Content length:" + request.getContentLength() +"<br>";
	str +="<hr>";
	str +="ID: " + request.getParameter("id") +"<br>";
	str +="Content: " + request.getParameter("content") +"<br>";
	str +="Image: " + request.getParameter("image") +"<br>";
	str +="<hr>";
	
	
	InputStreamReader isr = new InputStreamReader(request.getInputStream(), "UTF-8");//request.getInputStream() 를 이용해서 stream 형태로 읽을 수 있게 객체를 생성,한글처리 포함
	BufferedReader br = new BufferedReader(isr); //메세지 스트림을 버퍼에 저장하기 위해 객체 생성(->라인 단위로 읽어오기 위해 필요)
	while((line=br.readLine()) != null){ //readLine()를 이용해서 스트림을 라인단위로 읽어서 str로 저장한다.
		str +=line;
	}
	
	out.print(str);
%>
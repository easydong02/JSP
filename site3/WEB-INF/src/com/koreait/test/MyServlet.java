package com.koreait.test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;

public class MyServlet extends HttpServlet{
	//클라이언트가 get방식으로 요청을 시도하면 동작할 메서드 재정의!!!
	//즉, 메서드명을 우리가 정하는 것이 아니라, sun의 javaEE api중 서블릿이라는 클래스의 메서드를
	//재정의 해야한다.

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//클라이언트의 웹브라우저에 응답정보를 생성하자
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("my first servlet!!<br>");
		out.print("success");
		out.print("<button>나버튼</button>");
	} //클라이언트의 요청처리를 완료
}

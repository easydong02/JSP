package com.koreait.test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;

public class MyServlet extends HttpServlet{
	//Ŭ���̾�Ʈ�� get������� ��û�� �õ��ϸ� ������ �޼��� ������!!!
	//��, �޼������ �츮�� ���ϴ� ���� �ƴ϶�, sun�� javaEE api�� �����̶�� Ŭ������ �޼��带
	//������ �ؾ��Ѵ�.

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//Ŭ���̾�Ʈ�� ���������� ���������� ��������
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("my first servlet!!<br>");
		out.print("success");
		out.print("<button>����ư</button>");
	} //Ŭ���̾�Ʈ�� ��ûó���� �Ϸ�
}

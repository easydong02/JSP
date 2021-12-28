package com.koreait.project1216.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.project1216.domain.Member;
import com.koreait.project1216.member.repository.MemberDAO;
import com.koreait.project1216.secure.HashCreator;


//�α��� ��û�� ó���ϴ� ����
public class MemberLogin extends HttpServlet{
	MemberDAO memberDAO;
	
	public void init() throws ServletException {
		memberDAO = new MemberDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id= request.getParameter("id");
		String pass= HashCreator.getHash(request.getParameter("pass"));
		
		Member member = new Member();
		member.setId(id);
		member.setPass(pass);
		
		//�α��� ó��
		Member result = memberDAO.loginCheck(member);
		if(result !=null) {
			out.print("�α��� ����!");
			
			//���� ��ü�� ȸ�������� ����!!
			HttpSession session = request.getSession(); //���� ��û�� ������ ���� ���!!
			session.setAttribute("member",result );//������ Map�̴�! ���� Ű�� ����� ����
			response.sendRedirect("/admin/main");
			out.print("aaa");
			
		}else {
			out.print("�α��� ����!");
			
		}
	}
}

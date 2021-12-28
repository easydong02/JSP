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


//로그인 요청을 처리하는 서블릿
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
		
		//로그인 처리
		Member result = memberDAO.loginCheck(member);
		if(result !=null) {
			out.print("로그인 성공!");
			
			//세션 객체에 회원정보를 담자!!
			HttpSession session = request.getSession(); //현재 요청과 연관된 세션 얻기!!
			session.setAttribute("member",result );//세션은 Map이다! 따라서 키와 밸류로 관리
			response.sendRedirect("/admin/main");
			out.print("aaa");
			
		}else {
			out.print("로그인 실패!");
			
		}
	}
}

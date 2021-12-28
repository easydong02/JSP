package com.koreait.project1216.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.project1216.domain.Member;
import com.koreait.project1216.mail.MailSender;
import com.koreait.project1216.member.repository.MemberDAO;
import com.koreait.project1216.secure.HashCreator;

//jsp 대신, 회원가입 요청을 
public class MemberRegist extends HttpServlet {
	private MemberDAO memberDAO;
	private MailSender mailSender;

	public void init() throws ServletException {
	      memberDAO = new MemberDAO();
	      mailSender = new MailSender();
	   }

	
	//post 요청시 호출되는 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		
		//파라미터 인코딩
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String email= request.getParameter("email");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("id="+id+"<br>");
		out.print("pass="+pass+"<br>");
		out.print("name="+name+"<br>");
		out.print("email="+email+"<br>");
		
		//파라미터 DTO에 담기
		Member member = new Member();
		member.setId(id);
		member.setPass(HashCreator.getHash(pass));
		member.setName(name);
		member.setEmail(email);
		
		//DAO일 시키고, 이메일 발송..
		int result = memberDAO.insert(member);
		out.print(result);
		
		out.print("<script>");
		if(result !=0) {
			//mailSender.send(email);
			out.print("alert('회원가입을 축하드립니다!';");
			out.print("location.href='/member/login.jsp';");
		}else {
			
		}
		out.print("</script>");
	}
	
	
	
}

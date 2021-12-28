package com.koreait.project1207.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.project1207.domain.Notice;
import com.koreait.project1207.notice.model.NoticeDAO;



public class EditServlet  extends HttpServlet{
	NoticeDAO noticeDAO;
	
	//init�� ������ �ƴ�, ������ �� ��Ĺ���κ��� �������μ� �ʿ��� ������ �Ѱܹ��� �� �ִ� �ʱ�ȭ �޼���!
	public void init() throws ServletException {
		noticeDAO= new NoticeDAO();
	}
	
	
	//Ŭ���̾�Ʈ ��û �� post ����� ��û�� ó��
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�Ķ���� �ޱ�!!
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int notice_id = Integer.parseInt(request.getParameter("notice_id"));
		String title = (request.getParameter("title"));
		String writer = (request.getParameter("writer"));
		String content = (request.getParameter("content"));
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setNoitce_id(notice_id);
		notice.setContent(content);
		
		PrintWriter out  = response.getWriter();
		
		int result = noticeDAO.update(notice);
		
		out.print("<script>");
		if(result ==0) {
			out.print("alert('��������');");
			out.print("history.back();");
		}else {
			out.print("alert('��������');");
			out.print("location.href='/notice/content.jsp?notice_id="+notice_id+"';"); //�󼼺��� ������ ���û!
			
		}
		out.print("</script>");
		
	}
}

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
	
	//init은 생성자 아님, 생성한 후 톰캣으로부터 서블릿으로서 필요한 정보를 넘겨받을 수 있는 초기화 메서드!
	public void init() throws ServletException {
		noticeDAO= new NoticeDAO();
	}
	
	
	//클라이언트 요청 중 post 방식의 요청을 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기!!
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
			out.print("alert('수정실패');");
			out.print("history.back();");
		}else {
			out.print("alert('수정성공');");
			out.print("location.href='/notice/content.jsp?notice_id="+notice_id+"';"); //상세보기 페이지 재요청!
			
		}
		out.print("</script>");
		
	}
}

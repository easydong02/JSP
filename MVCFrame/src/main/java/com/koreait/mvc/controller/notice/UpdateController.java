package com.koreait.mvc.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvc.controller.Controller;
import com.koreait.mvc.domain.Notice;
import com.koreait.mvc.model.repository.notice.NoticeDAO;

public class UpdateController implements Controller {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Notice notice = new Notice();
		notice.setNotice_id(Integer.parseInt(request.getParameter("notice_id")));
		notice.setTitle(request.getParameter("title"));
		notice.setWriter(request.getParameter("writer"));
		notice.setContent(request.getParameter("content"));
		
		NoticeDAO noticeDAO = new NoticeDAO();
		noticeDAO.update(notice);
		 
		request.setAttribute("notice", notice);
	}

	public String getViewName() {
		return "/result/notice/update";
	}

	public boolean isForward() {
		return true;
	}
	
}

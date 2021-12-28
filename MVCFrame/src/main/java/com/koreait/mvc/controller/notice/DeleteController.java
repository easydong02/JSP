package com.koreait.mvc.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvc.controller.Controller;
import com.koreait.mvc.model.repository.notice.NoticeDAO;

public class DeleteController  implements Controller{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO noticeDAO = new NoticeDAO();
		int notice_id= Integer.parseInt(request.getParameter("notice_id"));
		
		noticeDAO.delete(notice_id);
		
		
	}

	public String getViewName() {
		return "/result/notice/delete";
	}

	public boolean isForward() {
		return false;
	}

}

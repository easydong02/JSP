package com.koreait.mvc.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvc.controller.Controller;
import com.koreait.mvc.domain.Notice;
import com.koreait.mvc.model.repository.notice.NoticeDAO;

//상세보기 요청을 처리하는 하위 컨트롤러
public class DetailController implements Controller{
	private NoticeDAO noticeDAO = new NoticeDAO();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3단계: 일시키기(한 건 가져오기)
		Notice notice = noticeDAO.select(Integer.parseInt(request.getParameter("notice_id")));
		
		//4단계: 저장할 것이 있음
		request.setAttribute("notice", notice);
	}

	public String getViewName() {
		return "/result/notice/detail";
	}

	public boolean isForward() {
		return true;
	}

}

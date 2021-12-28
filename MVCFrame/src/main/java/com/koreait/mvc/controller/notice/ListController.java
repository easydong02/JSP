package com.koreait.mvc.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvc.controller.Controller;
import com.koreait.mvc.model.repository.notice.NoticeDAO;

//리스트 요청에 대해 3,4단계를 수행하는 하위 컨트롤러
public class ListController implements Controller {
	NoticeDAO noticeDAO= new NoticeDAO();
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3단계 : 일시키기
		List noticeList = noticeDAO.selectAll();
		
		//4단계: 결과가 있다면 결과저장
		request.setAttribute("noticeList", noticeList);
		
	}

	public String getViewName() {
		return "/result/notice";
	}

	public boolean isForward() {
		return true;
	}
	
}

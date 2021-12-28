package com.koreait.springmvc1223.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc1223.domain.Notice;
import com.koreait.springmvc1223.model.service.notice.NoticeService;

public class DetailController implements Controller{
	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int notice_id=Integer.parseInt(request.getParameter("notice_id"));
		Notice notice =noticeService.select(notice_id);
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("notice",notice);
		mav.setViewName("notice/detail");
		
		return mav;
	}

}

package com.koreait.springmvc1223.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc1223.model.service.notice.NoticeService;
import com.koreait.springmvc1223.util.Pager;

//목록 요청을 처리하는 하위 컨트롤러 
public class ListController implements Controller{
	private NoticeService noticeService;
	private Pager pager;
	
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계: 일시키기 
		List noticeList=noticeService.selectAll();
		
		//4단계: 저장할것이 있기 때문에 저장  
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeList", noticeList);
		mav.addObject("pager", pager);
		
		mav.setViewName("notice/list");    
		
		return mav;
	}
	
}





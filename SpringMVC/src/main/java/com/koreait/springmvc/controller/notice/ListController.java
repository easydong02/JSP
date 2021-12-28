package com.koreait.springmvc.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc.model.service.notice.NoticeService;
import com.koreait.springmvc.util.Pager;

//紐⑸줉 �슂泥��쓣 泥섎━�븯�뒗 �븯�쐞 而⑦듃濡ㅻ윭 
public class ListController implements Controller{
	private NoticeService noticeService;
	private Pager pager;
	
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List noticeList=noticeService.selectAll();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeList", noticeList);
		mav.addObject("noticeList", pager);
		
		mav.setViewName("notice/list");    
		
		return mav;
	}
	
}





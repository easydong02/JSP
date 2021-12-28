package com.koreait.springmvc1223.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc1223.domain.Notice;
import com.koreait.springmvc1223.model.service.notice.NoticeService;

//글쓰기 요청을 처리하는 하위 컨트롤러
public class RegistController implements Controller{
	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//게시물 등록 일시키기!!
		request.setCharacterEncoding("utf-8"); //속상?? 안속상?
		
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		Notice notice = new Notice();
		notice.set(title);
		notice.setWriter(writer);
		notice.setContent(content);
		
		int result = noticeService.insert(notice);
		System.out.println("등록결과 "+result);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/notice/list");
		
		return mav;
	}
	
}

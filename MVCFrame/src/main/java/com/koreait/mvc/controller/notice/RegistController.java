package com.koreait.mvc.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvc.controller.Controller;
import com.koreait.mvc.domain.Notice;
import com.koreait.mvc.model.repository.notice.NoticeDAO;

//�۾��� ��û�� ó���ϴ� ���� ��Ʈ�ѷ� 3�ܰ�: �Ͻ�Ų��, 4�ܰ�: ����� �ִٸ� ��� ����
public class RegistController implements Controller {
	private NoticeDAO noticeDAO =new NoticeDAO();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3�ܰ�: �� ��Ų��
		Notice notice =new Notice();
		notice.setTitle(request.getParameter("title"));
		notice.setWriter(request.getParameter("writer"));
		notice.setContent(request.getParameter("content"));
		
		int result = noticeDAO.insert(notice);
	}

	public String getViewName() {
		return "/result/notice/regist";
	}

	public boolean isForward() {
		return false;
	}

}

package com.koreait.mvc.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvc.controller.Controller;
import com.koreait.mvc.domain.Notice;
import com.koreait.mvc.model.repository.notice.NoticeDAO;

//�󼼺��� ��û�� ó���ϴ� ���� ��Ʈ�ѷ�
public class DetailController implements Controller{
	private NoticeDAO noticeDAO = new NoticeDAO();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3�ܰ�: �Ͻ�Ű��(�� �� ��������)
		Notice notice = noticeDAO.select(Integer.parseInt(request.getParameter("notice_id")));
		
		//4�ܰ�: ������ ���� ����
		request.setAttribute("notice", notice);
	}

	public String getViewName() {
		return "/result/notice/detail";
	}

	public boolean isForward() {
		return true;
	}

}

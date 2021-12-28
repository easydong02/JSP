package com.koreait.mvc.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvc.controller.Controller;
import com.koreait.mvc.model.repository.notice.NoticeDAO;

//����Ʈ ��û�� ���� 3,4�ܰ踦 �����ϴ� ���� ��Ʈ�ѷ�
public class ListController implements Controller {
	NoticeDAO noticeDAO= new NoticeDAO();
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3�ܰ� : �Ͻ�Ű��
		List noticeList = noticeDAO.selectAll();
		
		//4�ܰ�: ����� �ִٸ� �������
		request.setAttribute("noticeList", noticeList);
		
	}

	public String getViewName() {
		return "/result/notice";
	}

	public boolean isForward() {
		return true;
	}
	
}

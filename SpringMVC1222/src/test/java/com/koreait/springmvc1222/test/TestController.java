package com.koreait.springmvc1222.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//�׽�Ʈ ��û�� ó���ϴ� ��Ʈ�ѷ�
public class TestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3�ܰ�: �Ͻ�Ų��
		
		//����Ʈ�� forward
		
		//Model: ��������͸� ��� ��ü, View: ����������� ������ ������ü
		ModelAndView mav= new ModelAndView();
		mav.addObject("msg","���������� ���� ����");//4�ܰ�: ����� �ִٸ� �������
		mav.setViewName("main/result");
		
		return mav;
	}
	

}

package com.koreait.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException ;
	
	
	//�� ��û�� ���� ��������� �������� �̸�
	public String getViewName();
	
	//�� ��û�� �������ؾ� ���� ���� ��ȯ
	public boolean isForward();
}

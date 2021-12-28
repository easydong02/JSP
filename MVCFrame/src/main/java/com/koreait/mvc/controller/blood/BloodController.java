package com.koreait.mvc.controller.blood;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvc.controller.Controller;
import com.koreait.mvc.model.blood.BloodManager;

//javaEE���� ��Ʈ�ѷ� ������ ������ Ŭ���� ����
//�� �������� ���� �ϳ�? ���� �� ����.. �׸��� ������ ��û�� ���� �� �ִ� �ɷ��� �־�� �ϹǷ�...

public class BloodController  implements Controller{
	private BloodManager bloodManager;
	
	public BloodController() {
		bloodManager = new BloodManager();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blood = request.getParameter("blood");
		
		//3�ܰ�) �˸��� ��ü�� �Ͻ�Ű��
		String msg = bloodManager.getAdvice(blood);
		
		//��Ʈ�ѷ��� ��� ��ü�� �����ִ� ������ �ϴ� ���� view�� �Ǿ����..
		//���� ���� ������ ���⼭ �����ؾ� �ϹǷ� ������ html�ڵ带 �ۼ��ؾ���
		
		//��û, ���� ��ü�� ������ �ϱ��������� ���� ������� �����ǰ� �ִ�..
		//�̶�, �����ڴ� �ڽ��� ���ϴ� ������ ���� �̿��ϵ� ���� �� �ִ�..
		
		//4�ܰ�)���� ��Ʈ�ѷ��� ������ �� �ֵ��� ��� ����(�޸� ��򰡿�)
		request.setAttribute("result", msg);
		
	}
	
	public String getViewName() {
		return "/result/blood";
	}
	
	//�޼����ϳ� �����Ͽ� ������ �ۿ������ �������� ������ ���Կ��� �δ� ����
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

package com.koreait.mvc.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvc.controller.blood.BloodController;
import com.koreait.mvc.controller.movie.MovieController;

/*�츮�� ���� MVC������ ������ ���α׷��� ����µ� ������ �ߴ�..
 *��� Ŭ���̾�Ʈ�� �� ��û���� 1:1 �����ϴ� ������ �ɸ�, ������������ �������Ƿ�
 *���� �ý����� �ݼ���ó��, ��û�� ���� �ο� ���� ��Ʈ�ѷ��� �ΰ�, ��� ��û�� �� �ϳ��� ��Ʈ�ѷ����� ó���ؼ�, ���� ��Ʈ�ѷ��� �����غ���!
 * 
 * 1)��û�ޱ�(����)
 * 2)��û �м�(����)
 * 3)�˸��� ��ü(��)�� �� ��Ų��(����)
 * 4)��� ������ ����� ����
 * 5)����� �����ش�
 * 
 * */
public class DispatcherServlet_back extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Ŭ���̾�Ʈ�� ��û�� ����");
		
		// 2)��û�� �м��Ͽ� �˸��� ��Ʈ�ѷ����� ��û ����(��������)
		//�ٵ�.. ���� ��û�� ���� ���� ����?
		
		//��ü url = localhost:9999 /movie.do
		String uri = request.getRequestURI();
		System.out.println("Ŭ���̾�Ʈ�� ���ϴ� ��û�� " +uri);
		
		
//		try {
//			Class controllerClass = Class.forName("com.koreait.mvc.controller.blood.BloodController");//����ÿ� ���ڿ��� ������ Ŭ������ ���� Ŭ���� �ڵ带 ��� ���
//			Object obj = controllerClass.newInstance();
//			BloodController c = (BloodController)obj;
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} 
		Controller controller=null;
		
		try {
			Class obj = Class.forName("com.koreait.mvc.controller.blood.BloodController");
			controller = (Controller)obj.newInstance();
			controller.doPost(request, response);
			RequestDispatcher dis = request.getRequestDispatcher("/blood/result.jsp"); //������ ��ü
			dis.forward(request, response); //�������� request,response �Ű������� ����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(uri.equals("/blood.do")) {
//			//�޸𸮿� �ν��Ͻ��� �����ϰ� ���� ��� Ŭ������ �� ��θ� �̿��Ͽ�, �ش� Ŭ������ class���� ��ȯ�ϴ� �޼��带 ����ؼ�
//			//�������� ��Ʈ�ѷ��� �ν��Ͻ��� �����غ���!!
//			
//			//5)����� �����ش�
//			//�������� �ڿ��� ��û�غ��� �� ������ ó���غ���!! (�����ƴ� ���⼭ �ٷ� �������ִ� ��)
//			
//			
//		}else if (uri.equals("/movie.do")) {
//			//5)����� �����ش�
//			//�������� �ڿ��� ��û�غ��� �� ������ ó���غ���!! (�����ƴ� ���⼭ �ٷ� �������ִ� ��)
//			RequestDispatcher dis = request.getRequestDispatcher("/movie/result.jsp"); //������ ��ü
//			dis.forward(request, response); //�������� request,response �Ű������� ����
//			controller.doPost(request, response); //�������� ����� �ѱ�
//		}
		
		
		
		
		
	}
	
	
	
}

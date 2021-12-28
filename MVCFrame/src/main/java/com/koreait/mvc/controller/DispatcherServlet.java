package com.koreait.mvc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
public class DispatcherServlet extends HttpServlet {
	FileInputStream fis; //��Ʈ�ѷ� ���� ���������� ����ִ� ������ �б����� ��Ʈ��
	Properties props;
	
	
	//�� ������ �ν��Ͻ��� �����ǰ� �� ����, ��Ĺ�� ���� ���� �ʱ�ȭ�� �߻�, �̶� ȣ��Ǵ� �޼��尡 �ٷ� init()
	public void init(ServletConfig config) throws ServletException {
		String mapptingPath = config.getInitParameter("mappingPath");
		
		ServletContext application = config.getServletContext();
		String realPath = application.getRealPath(mapptingPath);
		try {
			fis = new FileInputStream(realPath);
			System.out.println(realPath);
			props= new Properties(); //�ڹ��� �÷��� �����ӿ��� ���� �ڽ��� ������Ƽ���� key-value�� ������ �� �����͸� ����
			props.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		//��û�� �м��Ѵ�
		String uri = request.getRequestURI();
		// http://localhost:9999		/blood.do
		System.out.println("Ŭ���̾�Ʈ�� ���ϴ� ��û�� " +uri);
		Controller controller=null;
		
		try {
			String controllerName = props.getProperty(uri);
			System.out.println("���� uri�� " +uri+ "�� ��û�� ������ ��Ʈ�ѷ��� "+controllerName);
			Class obj = Class.forName(controllerName);
			controller = (Controller)obj.newInstance();
			controller.doPost(request, response);
			
			//3,4�ܰ�� ������ ����!!
			
			String viewName= props.getProperty(controller.getViewName()) ; //������ �ٽ� �ѹ� �˻��� ���� ���� ���� ����
			
			
			//������ �ϴٺ��� ��û�� ������ ���� �ְ�(��û����), ������ �ʿ䰡 ���� ���� �ִ�..(��û����)
			if(controller.isForward()) {//�������� ���
				RequestDispatcher dis = request.getRequestDispatcher(viewName); //������ ��ü
				dis.forward(request, response); //�������� request,response �Ű������� ����
			}else {
				//�����̷�Ʈ(Ŭ���̾�Ʈ�� ������ ȯ�ڷ�..) ������ URL�� �������� ����
				response.sendRedirect(viewName);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	//�� ������ �Ҹ��� �� ȣ��Ǵ� �޼���
	public void destroy() {
		if(fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}

package com.koreait.mvc.controller.movie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvc.controller.Controller;
import com.koreait.mvc.model.movie.MovieManager;

/*
 * ��� ���α׷��� MVC�� ������ �����ϴ�
 * �̶� ��� ��Ʈ�ѷ� ��Ʈ�� �ݵ�� �Ʒ��� �ܰ�� ������ �����Ѵ�..
 * 1.��û�� �޽��ϴ�.
 * 2.��û�� �м��Ѵ�
 * 3.�˸´� ����Ͻ� ��ü�� �� ��Ų��
 * 4.������ü�� �� ��Ų �� ����Ʈ�� ������ �ܷΰ��� �ִٸ� ����� �����ؾ� �Ѵ�..
 * 5.����� �����ش�(Ŭ���̾�Ʈ���� ���Ե� ȭ��)
 * */


//3�ܰ�) �˸��� ���� ��ü�� �Ͻ�Ų��
//4�ܰ�) ��� ������ ���� �ִٸ� ����� ����!
public class MovieController implements Controller {
											//MovieController is a Controller
	private MovieManager movieManager;
	
		public MovieController() {
			movieManager = new MovieManager();
		}
		
	public String getViewName() {
		return"/result/movie";
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String movie = request.getParameter("movie");
		
		//�Ͻ�Ŵ
		String msg = movieManager.getMsg(movie);
		
		//������ ������ ���� ����
		request.setAttribute("result", msg);
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}
}

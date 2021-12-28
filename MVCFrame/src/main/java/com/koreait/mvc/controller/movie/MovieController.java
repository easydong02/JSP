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
 * 모든 프로그램은 MVC로 제작이 가능하다
 * 이때 모든 컨트롤러 파트는 반드시 아래의 단계로 업무를 수행한다..
 * 1.요청을 받습니다.
 * 2.요청을 분석한다
 * 3.알맞는 비즈니스 객체에 일 시킨다
 * 4.로직객체에 일 시킨 후 뷰파트로 가져갈 겨로가가 있다면 결과를 저장해야 한다..
 * 5.결과를 보여준다(클라이언트들이 보게될 화면)
 * */


//3단계) 알맞은 로직 객체에 일시킨다
//4단계) 뷰로 가져갈 것이 있다면 결과를 저장!
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
		
		//일시킴
		String msg = movieManager.getMsg(movie);
		
		//데이터 전달을 위한 저장
		request.setAttribute("result", msg);
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}
}

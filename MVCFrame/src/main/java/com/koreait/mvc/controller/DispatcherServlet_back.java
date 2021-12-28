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

/*우리는 현재 MVC패턴을 적용한 프로그램을 만드는데 성공은 했다..
 *모든 클라이언트의 매 요청마다 1:1 대응하는 매핑을 걸면, 유지보수성이 떨어지므로
 *대기업 시스템의 콜센터처럼, 요청의 진입 부에 전담 컨트롤러를 두고, 모든 요청을 이 하나의 컨트롤러에서 처리해서, 하위 컨트롤러에 전달해보자!
 * 
 * 1)요청받기(형님)
 * 2)요청 분석(형님)
 * 3)알맞은 객체(모델)에 일 시킨다(동생)
 * 4)뷰로 가져갈 결과를 저장
 * 5)결과를 보여준다
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
		
		System.out.println("클라이언트의 요청을 받음");
		
		// 2)요청을 분석하여 알맞은 컨트롤러에게 요청 전달(동생선택)
		//근데.. 들어온 요청이 뭔지 어케 알지?
		
		//전체 url = localhost:9999 /movie.do
		String uri = request.getRequestURI();
		System.out.println("클라이언트가 원하는 요청은 " +uri);
		
		
//		try {
//			Class controllerClass = Class.forName("com.koreait.mvc.controller.blood.BloodController");//실행시에 문자열로 지정한 클래스의 실제 클래스 코드를 얻는 방법
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
			RequestDispatcher dis = request.getRequestDispatcher("/blood/result.jsp"); //포워딩 객체
			dis.forward(request, response); //포워딩시 request,response 매개변수로 전달
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(uri.equals("/blood.do")) {
//			//메모리에 인스턴스를 생성하고 싶은 대상 클래스명 및 경로를 이용하여, 해당 클래스의 class형을 반환하는 메서드를 사용해서
//			//동적으로 컨트롤러의 인스턴스를 생성해보자!!
//			
//			//5)결과를 보여준다
//			//서버상의 자원을 요청해보자 즉 포워딩 처리해보자!! (재접아님 여기서 바로 연결해주는 것)
//			
//			
//		}else if (uri.equals("/movie.do")) {
//			//5)결과를 보여준다
//			//서버상의 자원을 요청해보자 즉 포워딩 처리해보자!! (재접아님 여기서 바로 연결해주는 것)
//			RequestDispatcher dis = request.getRequestDispatcher("/movie/result.jsp"); //포워딩 객체
//			dis.forward(request, response); //포워딩시 request,response 매개변수로 전달
//			controller.doPost(request, response); //동생에게 제어권 넘김
//		}
		
		
		
		
		
	}
	
	
	
}

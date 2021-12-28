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
public class DispatcherServlet extends HttpServlet {
	FileInputStream fis; //컨트롤러 등의 맵핑정보가 들어있는 파일을 읽기위한 스트림
	Properties props;
	
	
	//이 서블릿의 인스턴스가 생성되고 난 직후, 톰캣에 의해 서블릿 초기화가 발생, 이때 호출되는 메서드가 바로 init()
	public void init(ServletConfig config) throws ServletException {
		String mapptingPath = config.getInitParameter("mappingPath");
		
		ServletContext application = config.getServletContext();
		String realPath = application.getRealPath(mapptingPath);
		try {
			fis = new FileInputStream(realPath);
			System.out.println(realPath);
			props= new Properties(); //자바의 컬렉션 프레임웍의 맵의 자식인 프로퍼티스는 key-value의 쌍으로 된 데이터만 이해
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
		
		
		//요청을 분석한다
		String uri = request.getRequestURI();
		// http://localhost:9999		/blood.do
		System.out.println("클라이언트가 원하는 요청은 " +uri);
		Controller controller=null;
		
		try {
			String controllerName = props.getProperty(uri);
			System.out.println("현재 uri인 " +uri+ "의 요청을 수행할 컨트롤러는 "+controllerName);
			Class obj = Class.forName(controllerName);
			controller = (Controller)obj.newInstance();
			controller.doPost(request, response);
			
			//3,4단계는 동생이 수행!!
			
			String viewName= props.getProperty(controller.getViewName()) ; //형님이 다시 한번 검색을 통해 실제 파일 접근
			
			
			//개발을 하다보면 요청을 유지할 때가 있고(요청유지), 유지할 필요가 없을 때가 있다..(요청끊기)
			if(controller.isForward()) {//포워딩의 경우
				RequestDispatcher dis = request.getRequestDispatcher(viewName); //포워딩 객체
				dis.forward(request, response); //포워딩시 request,response 매개변수로 전달
			}else {
				//리다이렉트(클라이언트를 몽유병 환자로..) 지정한 URL로 재접속을 유도
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
	
	//이 서블릿이 소멸할 때 호출되는 메서드
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

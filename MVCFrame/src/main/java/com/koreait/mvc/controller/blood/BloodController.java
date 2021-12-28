package com.koreait.mvc.controller.blood;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvc.controller.Controller;
import com.koreait.mvc.model.blood.BloodManager;

//javaEE에서 컨트롤러 역할을 수행할 클래스 정의
//왜 서블릿으로 가야 하나? 남은 게 없다.. 그리고 웺상의 요청을 받을 수 있는 능력이 있어야 하므로...

public class BloodController  implements Controller{
	private BloodManager bloodManager;
	
	public BloodController() {
		bloodManager = new BloodManager();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blood = request.getParameter("blood");
		
		//3단계) 알맞은 객체에 일시키기
		String msg = bloodManager.getAdvice(blood);
		
		//컨트롤러를 결과 자체를 보여주는 역할을 하는 순간 view가 되어버림..
		//따라서 뷰의 역할을 여기서 수행해야 하므로 수많은 html코드를 작성해야함
		
		//요청, 응답 객체는 응답을 하기전까지는 아직 생명력이 유지되고 있다..
		//이때, 개발자는 자신이 원하는 정보를 맵을 이용하듯 심을 수 있다..
		
		//4단계)형님 컨트롤러가 가져갈 수 있도록 결과 저장(메모리 어딘가에)
		request.setAttribute("result", msg);
		
	}
	
	public String getViewName() {
		return "/result/blood";
	}
	
	//메서드하나 정의하여 형님이 붜여줘야할 뷰페이지 정보를 형님에게 부담 ㄴㄴ
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

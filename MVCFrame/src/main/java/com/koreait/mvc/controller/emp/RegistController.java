package com.koreait.mvc.controller.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvc.controller.Controller;
import com.koreait.mvc.domain.Dept;
import com.koreait.mvc.domain.Emp;
import com.koreait.mvc.model.service.EmpService;

public class RegistController  implements Controller{
	private EmpService empService;
	
	public RegistController() {
		empService= new EmpService();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		String sal = request.getParameter("sal");
		
		Emp emp = new Emp();
		Dept dept= new Dept();
		
		dept.setDeptno(Integer.parseInt(deptno));
		dept.setDname(dname);
		dept.setLoc(loc);
		
		emp.setEmpno(Integer.parseInt(empno));
		emp.setEname(ename);
		emp.setJob(job);
		emp.setSal(Integer.parseInt(sal));
		
		emp.setDept(dept);
		//파일업로드 처리..
		//3단계: 사원등록
		empService.regist(emp);
	}

	public String getViewName() {
		return null;
	}

	public boolean isForward() {
		return false;
	}

}

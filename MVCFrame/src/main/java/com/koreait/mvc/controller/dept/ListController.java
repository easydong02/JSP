package com.koreait.mvc.controller.dept;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvc.controller.Controller;
import com.koreait.mvc.model.repository.emp.DeptDAO;

public class ListController implements Controller {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3�ܰ�: �μ���ȸ
		DeptDAO deptDAO = new DeptDAO();
		List list = deptDAO.selectAll();
		//4�ܰ�: �������
		request.setAttribute("list", list);
	}

	public String getViewName() {
		return "/result/dept/list";
	}

	public boolean isForward() {
		return true;
	}
	
}

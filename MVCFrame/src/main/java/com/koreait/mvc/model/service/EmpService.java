package com.koreait.mvc.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.koreait.mvc.domain.Dept;
import com.koreait.mvc.domain.Emp;
import com.koreait.mvc.model.pool.PoolManager;
import com.koreait.mvc.model.repository.emp.DeptDAO;
import com.koreait.mvc.model.repository.emp.EmpDAO;

//�μ��� ������õ� ��Ʈ�ѷ� ���� ��û�� ����, ����Ͻ� �� ��Ʈ�� ������ ���������� ���� ��ü
//���� �� ��ü�� ���簡 ���� ���, Controller�� ������ ����ؾ� �ϹǷ�, MVC������ �����...
public class EmpService {
	PoolManager pool = PoolManager.getInstance();
	
	
	//������(�μ��Է�+����Է�)
	public int regist(Emp emp) {
		Connection con =pool.getConnection();//DAO�鿡�� ���� Connection�� �����ϱ� ���� ���⼭ Ŀ�ؼ��� ��´�!
		int result =0;
		try {
			con.setAutoCommit(false);  //Connection ��ü�� ����Ʈ�� Ŀ�� true
			DeptDAO deptDAO= new DeptDAO(con);
			EmpDAO empDAO= new EmpDAO(con);
			Dept dept= emp.getDept();
			
			deptDAO.insert(dept); //�μ��Է�
			result = empDAO.insert(emp); //����Է�
			if(result !=1) {
				con.rollback();
			}else {
				con.commit();
			}
			con.setAutoCommit(true); //���󺹱�
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con);
		}
		
		
		return result;
	}
}

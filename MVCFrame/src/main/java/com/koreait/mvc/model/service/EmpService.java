package com.koreait.mvc.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.koreait.mvc.domain.Dept;
import com.koreait.mvc.domain.Emp;
import com.koreait.mvc.model.pool.PoolManager;
import com.koreait.mvc.model.repository.emp.DeptDAO;
import com.koreait.mvc.model.repository.emp.EmpDAO;

//부서와 사원관련된 컨트롤러 측의 요청에 대해, 비즈니스 모델 파트의 업무를 진두지휘할 서비스 객체
//만일 이 객체의 존재가 없을 경우, Controller가 업무를 담당해야 하므로, MVC패턴의 위배됨...
public class EmpService {
	PoolManager pool = PoolManager.getInstance();
	
	
	//사원등록(부서입력+사원입력)
	public int regist(Emp emp) {
		Connection con =pool.getConnection();//DAO들에게 같은 Connection을 공유하기 위해 여기서 커넥션을 얻는다!
		int result =0;
		try {
			con.setAutoCommit(false);  //Connection 객체는 디폴트가 커밋 true
			DeptDAO deptDAO= new DeptDAO(con);
			EmpDAO empDAO= new EmpDAO(con);
			Dept dept= emp.getDept();
			
			deptDAO.insert(dept); //부서입력
			result = empDAO.insert(emp); //사원입력
			if(result !=1) {
				con.rollback();
			}else {
				con.commit();
			}
			con.setAutoCommit(true); //원상복귀
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con);
		}
		
		
		return result;
	}
}

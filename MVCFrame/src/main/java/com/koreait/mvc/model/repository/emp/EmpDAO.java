package com.koreait.mvc.model.repository.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.koreait.mvc.domain.Emp;
import com.koreait.mvc.model.pool.PoolManager;

public class EmpDAO {
	Connection con;
	public EmpDAO(Connection con) {
		this.con=con;
	}
	
	public int insert(Emp emp) {
		int result =0;
		String sql = "insert into emp(empno,ename,job,sal) values(?,?,?,?)";
		PreparedStatement pstmt= null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getSal());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return result;
	}
	
	
}

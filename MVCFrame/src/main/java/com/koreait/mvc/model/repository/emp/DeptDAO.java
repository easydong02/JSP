package com.koreait.mvc.model.repository.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mvc.domain.Dept;
import com.koreait.mvc.domain.Emp;
import com.koreait.mvc.model.pool.PoolManager;

public class DeptDAO {
	Connection con;
	
	public DeptDAO(Connection con) {
		this.con= con;
	}
	
	//모든 부서 가져오기
	public List selectAll() {
		
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List list =new ArrayList();
		
		String sql ="select * from dept";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				
				list.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public int insert(Dept dept) {
		int result =0;
		String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
		PreparedStatement pstmt= null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return result;
	}
	
}

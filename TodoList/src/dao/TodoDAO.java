package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import util.ConnectionPool;

public class TodoDAO {
	
	public ArrayList<TodoObj> getList() throws NamingException,SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try {
			String sql = "SELECT NO,ID ,TODO,DONE,TS FROM TODO WHERE ID = '111' AND DONE = 1 ORDER BY TS DESC ";
			
			conn = ConnectionPool.get();
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<TodoObj> todos = new ArrayList<TodoObj>();
			
			while(rs.next()) {
				todos.add(new TodoObj(rs.getString("no"),rs.getString("id"),rs.getString("todo"),rs.getString("done"),rs.getString("ts")));
			}
			
			return todos;
			
		}finally {

			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
	public boolean del(String no) throws NamingException,SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt =null;
		
		try {
			String sql = "UPDATE TODO SET DONE =0 WHERE NO =?";
			
			conn = ConnectionPool.get();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			int count =pstmt.executeUpdate();
			
			return (count==1)? true:false;
			
		}finally {
			
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	
	
	
}

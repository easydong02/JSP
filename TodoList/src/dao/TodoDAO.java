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
			String sql = "SELECT NO,ID ,TODO,TS FROM TODO WHERE ID = '111' ORDER BY TS DESC ";
			
			conn = ConnectionPool.get();
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<TodoObj> todos = new ArrayList<TodoObj>();
			
			while(rs.next()) {
				todos.add(new TodoObj(rs.getString("no"),rs.getString("id"),rs.getString("todo"),rs.getString("ts")));
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
	
	
	
	
}

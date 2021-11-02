package dao;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.NamingException;

import util.ConnectionPool;

public class TodoDAO {

	public ArrayList<TodoObj> getList() 
			throws NamingException, SQLException {
	
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT no, id, todo, done, ts FROM todo WHERE id='111' and done=1 ORDER BY ts DESC";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			ArrayList<TodoObj> feeds = new ArrayList<TodoObj>() ;
			
			while(rs.next()) {
				feeds.add(new TodoObj(rs.getString("no"),rs.getString("id"),
						rs.getString("todo"), rs.getString("done"), rs.getString("ts")));
			}
			return feeds;
		} finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		
	}
	
	public boolean del(String no) 
			throws NamingException, SQLException {
	
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			String sql = "UPDATE todo SET done=0 WHERE no =?";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
				stmt.setString(1, no);
			int count = stmt.executeUpdate();
			
			return (count == 1) ? true : false;

		} finally {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		
	}
	
	public boolean insert(String utodo) 
			throws NamingException, SQLException {
	
		Connection conn = null;
		PreparedStatement stmt = null;
		String uid = "111";
		String udone = "1";
		try {
			String sql = "INSERT INTO todo (id, todo, done) VALUES (?,?,?)";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
				stmt.setString(1, uid);
				stmt.setString(2, utodo);
				stmt.setString(3, udone);

			int count = stmt.executeUpdate();
			
			return (count == 1) ? true : false;

		} finally {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
	}
	
	
}

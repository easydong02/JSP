package dao;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.NamingException;

import util.ConnectionPool;

public class UserDAO {

	public boolean insert(String uid, String upass, String uname) 
			throws NamingException, SQLException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			String sql = "INSERT INTO user(id, password, name) VALUES(?,?,?)";
			
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
				stmt.setString(1, uid);
				stmt.setString(2, upass);
				stmt.setString(3, uname);
				
			int count = stmt.executeUpdate();
			return (count == 1) ? true : false;
			
		} finally {
			System.out.print("성공");
		}
	}
	
	public boolean exists(String uid) 
			throws NamingException, SQLException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT id FROM user WHERE id=?";
			
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
				stmt.setString(1, uid);
				
			rs = stmt.executeQuery();
			return rs.next();
			
		} finally {
			System.out.print("성공");
		}
	}
	
	public boolean delete(String uid) 
			throws NamingException, SQLException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			String sql = "DELETE FROM user WHERE id = ?";
			
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
				stmt.setString(1, uid);
				
			int count = stmt.executeUpdate();
			return (count == 1) ? true : false;
			
		} finally {
			System.out.print("성공");
		}
	}
	
	public int login(String uid, String upass) 
	throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT id, password FROM user WHERE id = ?";


			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
				stmt.setString(1, uid);
				
			rs = stmt.executeQuery();
			
			if (!rs.next()) return 1;
			if (!upass.equals(rs.getNString("password"))) return 2;
			
			return 0;
			
			
		} finally {
			System.out.print("성공");
		}
	}
		
		public ArrayList<UserObj> getList() throws
		NamingException, SQLException {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT * FROM user ORDER BY ts DESC";
				
				conn = ConnectionPool.get();
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
	
				ArrayList<UserObj> users = new ArrayList<UserObj>();
				while (rs.next()) {
					users.add(new UserObj(rs.getString("id"),
							rs.getString("name"), rs.getString("ts")));
				}
				return users;

			} finally {
				System.out.print("성공");
			}
		}
		
	
	
	}







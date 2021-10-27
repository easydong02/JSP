package dao;

import java.sql.*;

import javax.naming.NamingException;

import util.ConnectionPool;

public class UserDAO {

	public boolean checkId(String uid) throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT ID FROM USER WHERE ID =?";
			
			conn = ConnectionPool.get();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return false; // 아이디 존재 x
			}

			return true;
		} finally {
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
	
	public int login(String uid, String upass) throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT ID, PASSWORD FROM USER WHERE ID =?";

			conn = ConnectionPool.get();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return 1; // 아이디 존재 x
			}
			if (!upass.equals(rs.getString("password"))) {
				return 2; // 비번 일치 x
			}
			return 0;
		} finally {
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
	
	public boolean insert(String uid, String upass, String uname) throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO USER(ID,PASSWORD,NAME) VALUES(?,?,?)";
			
			conn = ConnectionPool.get();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, upass);
			pstmt.setString(3, uname);
			
			int count =pstmt.executeUpdate();
			return (count ==1)? true : false;
			
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
	
}

package dao;

import java.sql.*;
import javax.naming.NamingException;

import util.ConnectionPool;

import java.util.*;

public class UserDAO {

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

			int count = pstmt.executeUpdate();
			return (count > 0) ? true : false;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	public boolean delete(String uid) throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "DELETE FROM USER WHERE ID = ?";
			conn = ConnectionPool.get();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, uid);

			int count = pstmt.executeUpdate();
			return (count > 0) ? true : false;
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	public boolean exists(String uid) throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT ID FROM USER WHERE ID = ?";

			conn = ConnectionPool.get();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);

			rs = pstmt.executeQuery();
			return rs.next();
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
			String sql = "SELECT ID, PASSWORD FROM USER WHERE ID = ?";
			conn = ConnectionPool.get();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, uid);
			
			rs=pstmt.executeQuery();
			if (!rs.next()) { //?????????
				return 1;
			}
			if (!upass.contentEquals(rs.getNString("password"))) { //???????????? ??????
				return 2;
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
}

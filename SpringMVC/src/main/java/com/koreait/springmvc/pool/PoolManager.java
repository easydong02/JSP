package com.koreait.springmvc.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


// jndi의 DataSource를 이용하여 Connection을 반환하거나, 돌려보내기 위한 객체 정의 
public class PoolManager {
	private static PoolManager instance;
	InitialContext context;
	DataSource ds;
	
	private PoolManager() {
		try {
			context = new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//커넥션 빌려갈 수 있게...
	public Connection getConnection() {
		Connection con=null;
		try {
			con=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public void freeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void freeConnection(Connection con, PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static PoolManager getInstance() {
		if(instance ==null) {
			instance = new PoolManager();
		}
		return instance;
	}
}

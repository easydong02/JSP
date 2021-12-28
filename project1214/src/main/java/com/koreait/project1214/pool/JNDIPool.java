package com.koreait.project1214.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//이 객체가 DAO 대신, server.xml의 jndi를 검색해서 DataSource를 얻어온 후 필요한 con을 전달해준다.
public class JNDIPool {
	private JNDIPool() {
		try {
			context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//커넥션을 반환하도록..
	public Connection getConnection() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void freeConnection(Connection con ) {
		try {
			if(con !=null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void freeConnection(Connection con ,PreparedStatement pstmt) {
		try {
			if(pstmt !=null) {
				pstmt.close();
			}
			if(con !=null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void freeConnection(Connection con ,PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs !=null) {
				rs.close();
			}
			if(pstmt !=null) {
				pstmt.close();
			}
			if(con !=null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static JNDIPool instance = new JNDIPool(); //static은 처음 로드될 때 한번만 실행하기 때문
	
	public static JNDIPool getInstance() {
		return instance;
	}
	
	InitialContext context; //Jndi 검색객체
	DataSource ds;//커넥션풀을 구현한 객체(커넥션을 보유하고 있음) 따라서 이 객체로부터 얻어진 Connection을 close()하면 돌아감
	
}

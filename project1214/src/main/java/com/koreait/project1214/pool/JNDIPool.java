package com.koreait.project1214.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//�� ��ü�� DAO ���, server.xml�� jndi�� �˻��ؼ� DataSource�� ���� �� �ʿ��� con�� �������ش�.
public class JNDIPool {
	private JNDIPool() {
		try {
			context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//Ŀ�ؼ��� ��ȯ�ϵ���..
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
	
	private static JNDIPool instance = new JNDIPool(); //static�� ó�� �ε�� �� �ѹ��� �����ϱ� ����
	
	public static JNDIPool getInstance() {
		return instance;
	}
	
	InitialContext context; //Jndi �˻���ü
	DataSource ds;//Ŀ�ؼ�Ǯ�� ������ ��ü(Ŀ�ؼ��� �����ϰ� ����) ���� �� ��ü�κ��� ����� Connection�� close()�ϸ� ���ư�
	
}

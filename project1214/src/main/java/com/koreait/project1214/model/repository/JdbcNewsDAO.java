package com.koreait.project1214.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.koreait.project1214.domain.News;
import com.koreait.project1214.pool.JNDIPool;

////���� news�� ���� crud���� �����ϴ� dao��ü
public class JdbcNewsDAO {
	JNDIPool pool = JNDIPool.getInstance();
	
	
	public int insert(News news) {
		int result =0;
		Connection con =pool.getConnection();
		PreparedStatement pstmt =null;
		
		String sql = "insert into news(title,writer,content) values(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,news.getTitle());
			pstmt.setString(2,news.getWriter());
			pstmt.setString(3,news.getContent());
			
			result= pstmt.executeUpdate(); //��������
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
		return result;
	}
}

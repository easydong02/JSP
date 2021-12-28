package com.koreait.mvc.model.repository.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.mvc.domain.Notice;
import com.koreait.mvc.model.pool.PoolManager;

public class NoticeDAO {
	PoolManager pool = PoolManager.getInstance();
	
	
	//목록 가져오기
	public List selectAll() {
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List list = new ArrayList();
		
		String sql = "select * from notice order by notice_id desc";
		try {
			pstmt= con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Notice notice =new Notice();
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setWriter(rs.getString("writer"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));
				
				list.add(notice);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int insert(Notice notice) {
		Connection con = pool.getConnection();
		PreparedStatement pstmt = null;
		int result =0;
		
		String sql="insert into notice(title,writer,content) values(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getWriter());
			pstmt.setString(3, notice.getContent());
			result =pstmt.executeUpdate(); //DML수행
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
		
		
		return result;
	}
	
	//한건 가져오기
	public Notice select(int notice_id) {
		
		Connection con= pool.getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		Notice notice =null;
		
		String sql = "select * from notice where notice_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				notice= new Notice();
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setTitle(rs.getString("title"));
				notice.setWriter(rs.getString("writer"));
				notice.setContent(rs.getString("content"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return notice;
	}
	
	//글 한건 수정
	public int update(Notice notice) {
		int result =0;
		
		Connection con =pool.getConnection();
		PreparedStatement pstmt =null;
		String sql ="update notice set title=?,writer=?,content=? where notice_id =?";
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2,notice.getWriter());
			pstmt.setString(3, notice.getContent());
			pstmt.setInt(4, notice.getNotice_id());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
		
		return result;
	}
	
	public int delete(int notice_id) {
		int result= 0;
		Connection con =pool.getConnection();
		PreparedStatement pstmt =null;
		String sql ="delete from notice where notice_id =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_id);
			result = pstmt.executeUpdate();
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
		
		
		return result;
	}
	
}

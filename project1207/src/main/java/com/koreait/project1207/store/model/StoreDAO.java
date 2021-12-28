package com.koreait.project1207.store.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.project1207.domain.Store;

import pool.jndi.PoolManager;

//���� store���̺� ���� ����
public class StoreDAO {
	PoolManager pool  = PoolManager.getInstance();
	
	public StoreDAO() {
		
	}
	//���
	public int insert(Store store) {
		Connection con = pool.getConnection(); //�뿩
		PreparedStatement pstmt = null;
		int result =0;
		
		String sql="insert into store(title,sido,score) values(?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, store.getTitle());
			pstmt.setString(2, store.getSido());
			pstmt.setInt(3, store.getScore());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
		return result;
	}
	
	//��� ���ڵ� ��������
	public List selectAll() {
		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		List list= new ArrayList();
		con = pool.getConnection();
		String sql = "select * from store order by store_id asc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // ��������
			while(rs.next()) {
				Store store = new Store();
				store.setStore_id(rs.getInt("store_id"));
				store.setTitle(rs.getString("title"));
				store.setSido(rs.getString("sido"));
				store.setScore(rs.getInt("score"));
				
				//list�� ����
				list.add(store);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}
	
	//���ڵ� �Ѱ� ��������
	public Store select(int store_id) {
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		Store store= null;
		
		con= pool.getConnection();
		String sql = "select * from store where store_id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, store_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				store = new Store(); //empty DTO ����
				store.setStore_id(rs.getInt("store_id"));
				store.setTitle(rs.getString("title"));
				store.setSido(rs.getString("sido"));
				store.setScore(rs.getInt("score"));
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return store;
	}
	
	//���ڵ� �Ѱ� ����
	public int update(Store store) {
		Connection con =null;
		PreparedStatement pstmt = null;
		con = pool.getConnection();
		int result =0;
		
		String sql= "update store set title =?,sido=?,score=? where store_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(4, store.getStore_id());
			pstmt.setString(1, store.getTitle());
			pstmt.setString(2,store.getSido());
			pstmt.setInt(3, store.getScore());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
		return result;
	}
	
	//���ڵ� �Ѱ� ����
	public int delete(int store_id) {
		int result =0;
		Connection con = pool.getConnection();
		PreparedStatement pstmt= null;
		String sql = "delete from store where store_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,store_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
		return result;
	}
	
	
}

package com.koreait.project1210.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.koreait.project1210.domain.Map;

import pool.jndi.PoolManager;

public class MapDAO {
	private PoolManager pool = PoolManager.getInstance();
	
	//���
	public int insert(Map map) {
		int result = 0;
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		con = pool.getConnection();
		String sql = "insert into map(title,lati,longi,filename) values(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, map.getTitle());
			pstmt.setDouble(2, map.getLati());
			pstmt.setDouble(3, map.getLongi());
			pstmt.setString(4, map.getFilename());
			result = pstmt.executeUpdate();
			
			//��� ���� insert�� ����Ų �ֽ��� pk ��ȯ�ޱ�!
			pstmt = con.prepareStatement("select last_insert_id() as map_id");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt("map_id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt,rs);
		}
		return result;
	}
	
	public Map select(int map_id) {
		Map map = new Map();
		Connection con =pool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql = "select * from map where map_id =?"; //������.currval
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, map_id);
			rs = pstmt.executeQuery();
			rs.next();
			map.setTitle(rs.getString("title"));
			map.setLati(rs.getDouble("lati"));
			map.setLongi(rs.getDouble("longi"));
			map.setFilename(rs.getString("filename"));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return map;
	}
	
	//��� ���ڵ� ��������
	public List selectAll() {
		List list = null;
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		String sql ="select * from map";
		
		return list;
	}
}

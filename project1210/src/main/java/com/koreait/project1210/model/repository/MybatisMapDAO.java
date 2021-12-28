package com.koreait.project1210.model.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pool.mybatis.PoolManager;

public class MybatisMapDAO {
	
	PoolManager pool= PoolManager.getInstance();
	
	
	//��� ���ڵ� ��������
	public List selectAll() {
		List list=null;
		SqlSession sqlSession= null;
		
		//jdbc ���� �̿�x, mybatis �̿�
		try {
			System.out.println("before   --  pool = "+pool);
			//jdbc������ ������ ������ ���� Connection, PreparedStatement ���� �־�� ������, mybatis�� �� ���� �� ���ܳ��Ҵ�..
			//���� mybatis���� �����ϴ� SqlSession��ü�� �̿��Ͽ� �������� ȣ��
			sqlSession = pool.getSqlSession(); //������ ȣ�� ��ü
			System.out.println("sqlSession = "+sqlSession);
			list =(List)sqlSession.selectList("MapDTO.selectAll");	//select * from map;
		} finally {
			pool.closeSqlSession(sqlSession);
		}
		return list;
	}
}

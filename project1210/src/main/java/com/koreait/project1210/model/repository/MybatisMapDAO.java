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
	
	
	//모든 레코드 가져오기
	public List selectAll() {
		List list=null;
		SqlSession sqlSession= null;
		
		//jdbc 직접 이용x, mybatis 이용
		try {
			System.out.println("before   --  pool = "+pool);
			//jdbc에서는 쿼리문 수행을 위해 Connection, PreparedStatement 등이 있어야 하지만, mybatis는 이 모든걸 다 숨겨놓았다..
			//따라서 mybatis에서 제공하는 SqlSession객체를 이용하여 쿼리문을 호출
			sqlSession = pool.getSqlSession(); //쿼리문 호출 객체
			System.out.println("sqlSession = "+sqlSession);
			list =(List)sqlSession.selectList("MapDTO.selectAll");	//select * from map;
		} finally {
			pool.closeSqlSession(sqlSession);
		}
		return list;
	}
}

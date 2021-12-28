package com.koreait.project1214.model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.project1214.domain.Comments;
import com.koreait.project1214.mybatis.ConfigManager;

public class MybatisCommentsDAO {
	private ConfigManager configManager;
	
	public MybatisCommentsDAO() {
		configManager = ConfigManager.getInstance();
	}
	
	//��� �Ѱ� ����
	public int insert(Comments comments) {
		int result =0;
		SqlSession sqlSession = configManager.getSqlSession();
		
		result = sqlSession.insert("Comments.insert",comments);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		
		return result;
	}
	
	//�ش� ������翡 �ִ� ��� ��������
	
	public List<Comments> selectAll(int news_id) {
		List<Comments> list =null;
		
		SqlSession sqlSession = configManager.getSqlSession();
		
		list = sqlSession.selectList("Comments.selectAll",news_id);
		
		configManager.closeSession(sqlSession);
		return list;
	}
}

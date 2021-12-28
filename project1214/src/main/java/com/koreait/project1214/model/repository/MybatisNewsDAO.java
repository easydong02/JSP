package com.koreait.project1214.model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.project1214.domain.News;
import com.koreait.project1214.mybatis.ConfigManager;

public class MybatisNewsDAO {
	ConfigManager configManager =  ConfigManager.getInstance();
	
	//�۵��
	public int insert(News news) {
		int result =0;
		SqlSession sqlSession = configManager.getSqlSession();
		//���� ���������� �����ʰ�, xml�� ����� ������ ����...
		result = sqlSession.insert("com.koreait.project1214.domain.News.insert", news);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}
	
	//��� �� ��������
	public List selectAll() {
		SqlSession sqlSession = configManager.getSqlSession();//������ ���ఴü
		List list= sqlSession.selectList("com.koreait.project1214.domain.News.selectAll");
		configManager.closeSession(sqlSession);
		return list;
	}
	
	//�� �� �� ��������
	public News select(int news_id) {
		SqlSession sqlSession = configManager.getSqlSession();
		News news= sqlSession.selectOne("com.koreait.project1214.domain.News.select",news_id);
		
		configManager.closeSession(sqlSession);
		return news;
	}
	
	//�� �� �� �����ϱ�
	public int update(News news) {
		int result = 0;
		
		SqlSession sqlSession = configManager.getSqlSession();
		result = sqlSession.update("com.koreait.project1214.domain.News.update", news);
		sqlSession.commit();
		
		
		configManager.closeSession(sqlSession);
		return result;
	}
	
	//�� �� �� �����ϱ�
	public int delete(int news_id) {
		int result =0;
		
		SqlSession sqlSession = configManager.getSqlSession();
		
		//�ڽ� ���ڵ� ����� �θ� ���ڵ� �����
		result = sqlSession.delete("Comments.delete",news_id); //�� ������ �Ҽӵ� ��� �ڽ� ���� ��û
		
		if(result !=0) {
			result = sqlSession.delete("com.koreait.project1214.domain.News.delete", news_id);
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		configManager.closeSession(sqlSession);
		return result;
	}
	
}

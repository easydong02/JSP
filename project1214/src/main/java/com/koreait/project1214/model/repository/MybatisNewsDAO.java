package com.koreait.project1214.model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.project1214.domain.News;
import com.koreait.project1214.mybatis.ConfigManager;

public class MybatisNewsDAO {
	ConfigManager configManager =  ConfigManager.getInstance();
	
	//글등록
	public int insert(News news) {
		int result =0;
		SqlSession sqlSession = configManager.getSqlSession();
		//직접 쿼리실행을 하지않고, xml에 명시한 쿼리를 수행...
		result = sqlSession.insert("com.koreait.project1214.domain.News.insert", news);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}
	
	//모든 글 가져오기
	public List selectAll() {
		SqlSession sqlSession = configManager.getSqlSession();//쿼리문 수행객체
		List list= sqlSession.selectList("com.koreait.project1214.domain.News.selectAll");
		configManager.closeSession(sqlSession);
		return list;
	}
	
	//글 한 건 가져오기
	public News select(int news_id) {
		SqlSession sqlSession = configManager.getSqlSession();
		News news= sqlSession.selectOne("com.koreait.project1214.domain.News.select",news_id);
		
		configManager.closeSession(sqlSession);
		return news;
	}
	
	//글 한 건 수정하기
	public int update(News news) {
		int result = 0;
		
		SqlSession sqlSession = configManager.getSqlSession();
		result = sqlSession.update("com.koreait.project1214.domain.News.update", news);
		sqlSession.commit();
		
		
		configManager.closeSession(sqlSession);
		return result;
	}
	
	//글 한 건 삭제하기
	public int delete(int news_id) {
		int result =0;
		
		SqlSession sqlSession = configManager.getSqlSession();
		
		//자식 레코드 지우고 부모 레코드 지우기
		result = sqlSession.delete("Comments.delete",news_id); //이 뉴스에 소속된 모든 자식 삭제 요청
		
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

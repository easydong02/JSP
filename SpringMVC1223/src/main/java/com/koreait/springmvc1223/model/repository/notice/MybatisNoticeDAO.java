package com.koreait.springmvc1223.model.repository.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.springmvc1223.domain.Notice;
import com.koreait.springmvc1223.mybatis.MybatisConfig;

public class MybatisNoticeDAO implements NoticeDAO{
	private MybatisConfig mybatisConfig;
	
	public void setMybatisConfig(MybatisConfig mybatisConfig) {
		this.mybatisConfig = mybatisConfig;
	}
	
	public List selectAll() {
		SqlSession sqlSession=mybatisConfig.getSqlSession();
		List list=sqlSession.selectList("Notice.selectAll");
		mybatisConfig.closeSqlSession(sqlSession);//반납
		return list;
	}

	public int insert(Notice notice) {
		SqlSession sqlSession = mybatisConfig.getSqlSession();
		int result=0;
		result=sqlSession.insert("Notice.insert", notice);
		sqlSession.commit(); //commit
		mybatisConfig.closeSqlSession(sqlSession);// 반납 
		
		return result;
	}
	
	
	public Notice select(int notice_id) {
		SqlSession sqlSession= mybatisConfig.getSqlSession();
		Notice notice = sqlSession.selectOne("Notice.select",notice_id);
		mybatisConfig.closeSqlSession(sqlSession);;
		return notice;
	}

	public int update(Notice notice) {
		return 0;
	}

	@Override
	public int delete(int notice_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}

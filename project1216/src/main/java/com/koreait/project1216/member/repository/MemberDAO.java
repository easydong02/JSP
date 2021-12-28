package com.koreait.project1216.member.repository;

import org.apache.ibatis.session.SqlSession;

import com.koreait.project1216.domain.Member;
import com.koreait.project1216.mybatis.ConfigManager;

public class MemberDAO {
	private ConfigManager configManager = ConfigManager.getInstance();
	
	
	public MemberDAO() {
	}
	
	//ȸ������
	public int insert(Member member) {
		int result = 0;
		SqlSession sqlSession= configManager.getSqlSession();
		result =sqlSession.insert("Member.insert",member);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		
		return result;
	}
	
	//�α��� ó�� �޼���
	public Member loginCheck(Member member) {
		Member member2 =null;
		SqlSession sqlSession = configManager.getSqlSession();
		member2=sqlSession.selectOne("Member.loginCheck",member);
		configManager.closeSession(sqlSession);
		
		return member2;
	}
	
}

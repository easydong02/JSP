package com.koreait.project1214.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/* Mybatis 프레임웍 관련 설정이 끝나면, 이 xml 설정파일들을 읽어들여 해석한 후
 * 데이터 베이스 연동을 위한 객체를 생성해야 한다...
 * */
public class ConfigManager {
	private static ConfigManager instance = new ConfigManager();
	SqlSessionFactory sqlSessionFactory;
	
	
	private ConfigManager() {
		try {
			String resource = "com/koreait/project1214/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//DAO등이 쿼리문을 수행할 때 사용할 객체인 SqlSession을 가져갈 수 있도록 메서드를 제공해주자
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	//DAO가 쿼리문 수행 완료 후, 다시 반납하는 메서드 제공
	public void closeSession(SqlSession sqlSession) {
		sqlSession.close();
	}
	
	public static ConfigManager getInstance() {
		return instance;
	}
	
	
}

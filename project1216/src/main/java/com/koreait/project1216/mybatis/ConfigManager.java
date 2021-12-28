package com.koreait.project1216.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConfigManager {
	private static ConfigManager instance;
	SqlSessionFactory sqlSessionFactory;
	
	private ConfigManager() {
		try {
			String resource = "com/koreait/project1216/mybatis/config.xml";
			InputStream inputStream= Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ConfigManager getInstance() {
		if(instance == null) {
			instance = new ConfigManager();
		}
		return instance;
	}
	
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	public void closeSession(SqlSession sqlSession) {
		sqlSession.close();
	}
	
}

package com.koreait.project1214.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/* Mybatis �����ӿ� ���� ������ ������, �� xml �������ϵ��� �о�鿩 �ؼ��� ��
 * ������ ���̽� ������ ���� ��ü�� �����ؾ� �Ѵ�...
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
	
	//DAO���� �������� ������ �� ����� ��ü�� SqlSession�� ������ �� �ֵ��� �޼��带 ����������
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	//DAO�� ������ ���� �Ϸ� ��, �ٽ� �ݳ��ϴ� �޼��� ����
	public void closeSession(SqlSession sqlSession) {
		sqlSession.close();
	}
	
	public static ConfigManager getInstance() {
		return instance;
	}
	
	
}

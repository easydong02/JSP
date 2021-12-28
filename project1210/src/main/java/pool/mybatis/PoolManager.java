package pool.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//Mybatis에서 SQL문을 수행하는 객체는 SqlSession이고, 
//SQLSession sqlsessionfactory로 부터, 매 쓰레드(클라이언트의 요청시 서버에서 생성되는)마다 사용되는 일회성
//객체이므로, 아래의 PoolManager를 제작하여 쿼리문 수행시마다 SqlSession객체를 반환해주는 클래스를 정의하자!!
public class PoolManager {
	private static PoolManager instance;
	String resource = "com/koreait/mybatis/config.xml";
	SqlSessionFactory sqlSessionFactory;
	
	private PoolManager() {
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			//데이터베이스 접속정보를 가진 팩토리 객체
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static PoolManager getInstance() {
		if(instance == null) {
			instance = new PoolManager();
		}
		return instance;
		
	}
	
	//SqlSession을 가져갈 수 있도록 하자!!
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	public void closeSqlSession(SqlSession sqlSession) {
		sqlSession.close();
	}
	
	
	
	
}

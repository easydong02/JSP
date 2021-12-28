package pool.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//Mybatis���� SQL���� �����ϴ� ��ü�� SqlSession�̰�, 
//SQLSession sqlsessionfactory�� ����, �� ������(Ŭ���̾�Ʈ�� ��û�� �������� �����Ǵ�)���� ���Ǵ� ��ȸ��
//��ü�̹Ƿ�, �Ʒ��� PoolManager�� �����Ͽ� ������ ����ø��� SqlSession��ü�� ��ȯ���ִ� Ŭ������ ��������!!
public class PoolManager {
	private static PoolManager instance;
	String resource = "com/koreait/mybatis/config.xml";
	SqlSessionFactory sqlSessionFactory;
	
	private PoolManager() {
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			//�����ͺ��̽� ���������� ���� ���丮 ��ü
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
	
	//SqlSession�� ������ �� �ֵ��� ����!!
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	public void closeSqlSession(SqlSession sqlSession) {
		sqlSession.close();
	}
	
	
	
	
}

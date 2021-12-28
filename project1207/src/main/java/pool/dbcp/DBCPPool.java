package pool.dbcp;

import java.sql.DriverManager;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

//����ġ���� �����ϴ� DBCP ���̺귯���� �̿��ϱ�
public class DBCPPool {
	private static DBCPPool instance;
	private String driver = "com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/jsp?characterEncoding=utf8";
	private String user ="root";
	private String password="1234";
	
	private DBCPPool() throws Exception {
		init();
	}
	
	public void init() throws Exception {
		//���ο� Ŀ�ؼ� ������ �� ����
		Class.forName(driver);
		ConnectionFactory connFactory = new DriverManagerConnectionFactory(url, user, password);
		
		//Ŀ�ؼ��� Ǯ�� �����ϴ� ���Ҽ���(close �ϸ� db�� �ݴ°� �ƴ϶� Ǯ�� �ٽ� ��������)
		PoolableConnectionFactory poolableConnFactory= new PoolableConnectionFactory(connFactory, null);
		
		//Ŀ�ؼ�Ǯ�� ���������� ��� ��ü
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		poolConfig.setMinIdle(5); //�ּ� ���� Ŀ�ؼ� ����
		poolConfig.setMaxIdle(16); //�ִ� ���� Ŀ�ؼ� ����
		
		//Ŀ�ؼ�Ǯ ����
		GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<PoolableConnection>(poolableConnFactory, poolConfig) ;
		
		//Ŀ�ؼ�Ǯ�� ���丮 ����
		poolableConnFactory.setPool(connectionPool);
		
		//����̹� �ε�
		Class.forName("org.apache.commons.dbcp2.PoolingDriver");
		
		PoolingDriver poolingDriver= (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:mydbcp");
		poolingDriver.registerPool("mydbcp", connectionPool);
		
		
	}
	
	public static DBCPPool getInstance() throws Exception {
		if(instance ==null) {
			instance = new DBCPPool();
		}
		return instance;
	}
}

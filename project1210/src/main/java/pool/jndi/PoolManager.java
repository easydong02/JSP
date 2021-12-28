package pool.jndi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PoolManager {
	
	private static PoolManager instance;
	InitialContext context;
	DataSource ds;
	Connection con;
	
	private PoolManager() {
		//jndi�� �̿��Ͽ� �ڿ��� ������!! DataSource ���!
		//JNDI�� �ڿ��� �˻�
		try {
			context = new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //�ڿ��� ã�� ������!!
	}
	
	public static PoolManager getInstance()  {
		if(instance ==null) {
			instance = new PoolManager();
		}
		return instance;
	}
	
	//Ŀ�ؼ��� ���´�.
		public Connection getConnection() {
			try {
				con = ds.getConnection(); //Ǯ�κ��� Connection ��ü�� �ϳ� ��ȯ�ޱ�
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return con;
	}
		
		public void freeConnection(Connection con) {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public void freeConnection(Connection con,PreparedStatement pstmt) {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public void freeConnection(Connection con,PreparedStatement pstmt,ResultSet rs) {
			if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
}

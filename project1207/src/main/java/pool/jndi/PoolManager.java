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
		//jndi를 이용하여 자원을 얻어오기!! DataSource 얻기!
		//JNDI로 자원을 검색
		try {
			context = new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //자원을 찾아 나선다!!
	}
	
	public static PoolManager getInstance()  {
		if(instance ==null) {
			instance = new PoolManager();
		}
		return instance;
	}
	
	//커넥션을 얻어온다.
		public Connection getConnection() {
			try {
				con = ds.getConnection(); //풀로부터 Connection 객체를 하나 반환받기
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

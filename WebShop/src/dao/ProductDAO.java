package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import util.ConnectionPool;

public class ProductDAO {
	public ArrayList<ProductObj> getList() throws NamingException,SQLException{
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT PID,PNAME,PDESCRIPTION,PPRICE,PFILENAME FROM PRODUCT";
			conn = ConnectionPool.get();
			pstmt= conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			ArrayList<ProductObj> products = new ArrayList<ProductObj>();
			
			while(rs.next()) {
				products.add(new ProductObj(rs.getString("pid"),rs.getString("pname"),rs.getString("pdescription"),
						rs.getString("pprice"),rs.getString("pfilename")));
			}
			
			return products;
		}finally {
			if(rs !=null) {
				rs.close();
			}
			if(pstmt !=null) {
				pstmt.close();
			}
			if(conn !=null) {
				conn.close();
			}
		}
	}
	
	
	
	
}

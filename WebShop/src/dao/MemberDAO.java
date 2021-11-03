package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import util.ConnectionPool;

public class MemberDAO {

	public int login(String cid, String cpassword) throws NamingException,SQLException {
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT CID,CPASSWORD FROM MEMBER WHERE CID=?";
			conn = ConnectionPool.get();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			
			rs=pstmt.executeQuery();
			
			if(!rs.next()) {
				
				return 1;
			}if(!cpassword.equals(rs.getString("cpassword"))) {
				return 2;
			}else {
				return 0;
			}
			
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
	public boolean join(String cid, String cpassword, String cname, String cgender, String cbirth, String cemail, String cphone, String caddr) throws NamingException,SQLException {
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "INSERT INTO MEMBER(CID,CPASSWORD,CNAME,CGENDER,CBIRTH,CEMAIL,CPHONE,CADDRESS VALUES("
					+ "?,?,?,?,?,?,?,?)";
			conn = ConnectionPool.get();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			pstmt.setString(2, cpassword);
			pstmt.setString(3, cname);
			pstmt.setString(4, cgender);
			pstmt.setString(5, cbirth);
			pstmt.setString(6, cemail);
			pstmt.setString(7, cphone);
			pstmt.setString(8, caddr);
			
			int count = pstmt.executeUpdate();
			
			return (count ==1)? true : false;
			
		}finally {
			if(pstmt !=null) {
				pstmt.close();
			}
			if(conn !=null) {
				conn.close();
			}
		}
		
	}
	
	
	
	
	
}

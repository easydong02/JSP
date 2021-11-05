package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.naming.NamingException;

import util.ConnectionPool;

public class BoardDAO {
	public ArrayList<BoardObj> getList() throws NamingException,SQLException{
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT bid,btitle,bcontent,bmember,bfilename,bdate FROM BOARD";
			conn = ConnectionPool.get();
			pstmt= conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			ArrayList<BoardObj> boards = new ArrayList<BoardObj>();
			
			while(rs.next()) {
				boards.add(new BoardObj(rs.getString("bid"),rs.getString("btitle"),rs.getString("bcontent"),
						rs.getString("bmember"),rs.getString("bfilename"),rs.getString("bdate")));
			}
			
			return boards;
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
	
	public int join( String btitle, String bcontent, String bmember, String bfilename) throws NamingException, SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			String sql = "INSERT INTO board ( btitle, bcontent, bmember, bfilename)"
					+ " VALUES (?,?,?,?)";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, btitle);
			stmt.setString(2, bcontent);
			stmt.setString(3, bmember);
			stmt.setString(4, bfilename);
			
			int count = stmt.executeUpdate(); // return이 1이면 데이터 나온거 2이면 아무것도 안된거

			return (count == 1) ? 1 : 2;

		} finally {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
		}

	}
	
	
	
}

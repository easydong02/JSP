package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.naming.NamingException;

import util.ConnectionPool;

public class MemberDAO {

	public int login(String cid, String cpassword) throws NamingException, SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT cid, cpassword FROM member WHERE cid = ?";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cid);
			rs = stmt.executeQuery();
			if (!rs.next())
				return 1;
			if (!cpassword.equals(rs.getString("cpassword")))
				return 2;

			return 0;
		} finally {
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
		}

	}

	public int join(String , String cpass, String cname, String cgender, String cbirth, String cemail, String cphone,
			String caddress) throws NamingException, SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			String sql = "INSERT INTO member (cid, cpassword, cname, cgender, cbirth, cemail, cphone, caddress, cregiday)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";
			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cid);
			stmt.setString(2, cpass);
			stmt.setString(3, cname);
			stmt.setString(4, cgender);
			stmt.setString(5, cbirth);
			stmt.setString(6, cemail);
			stmt.setString(7, cphone);
			stmt.setString(8, caddress);
			stmt.setString(9, LocalDate.now().toString());
			int count = stmt.executeUpdate(); // return이 1이면 데이터 나온거 2이면 아무것도 안된거

			return (count == 1) ? 1 : 2;

		} finally {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
		}

	}

	public ArrayList<MemberObj> getList() throws NamingException, SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM member";

			conn = ConnectionPool.get();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			ArrayList<MemberObj> members = new ArrayList<MemberObj>();

			while (rs.next()) {
				members.add(new MemberObj(rs.getString("cid"), rs.getString("cpassword"), rs.getString("cname"),
						rs.getString("cgender"), rs.getString("cbirth"), rs.getString("cemail"), rs.getString("cphone"),
						rs.getString("caddress"), rs.getString("cregiday")));
			}
			return members;

		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}

}

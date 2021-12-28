package com.koreait.project1207.notice.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.koreait.project1207.domain.Notice;

/*
 * 오직 Notice에 대한 crud만을 수행하는 객체를 가리켜, 어플리케이션 설계분야에서는 
 * DAO(Data Access Object)
 * 
 * CRUD( create read update delete)
 * */
public class NoticeDAO {

	/*
	 * 1)드라이버 로드 2)접속 3)쿼리문 실행 4)접속해제
	 */
	public int insert(Notice notice) {
		String url = "jdbc:mysql://localhost:3306/jsp?characterEncoding=utf8";
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "1234");

			String sql = "insert into notice(title,writer,content) values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getWriter());
			pstmt.setString(3, notice.getContent());

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;

	}

}

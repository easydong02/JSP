package com.koreait.project1207.notice.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.project1207.domain.Notice;

/*
 * 오직 Notice에 대한 crud만을 수행하는 객체를 가리켜, 어플리케이션 설계분야에서는 
 * DAO(Data Access Object)
 * 
 * CRUD( create read update delete)
 * */
public class NoticeDAO2 {

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

	public List selectAll() {
		String url = "jdbc:mysql://localhost:3306/jsp";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Notice> list = null;

		try {
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버 로드
			con = DriverManager.getConnection(url, "root", "1234"); // 접속
			String sql = "select * from notice order by notice_id desc";
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // 쿼리 객체
																												// 생성
			rs = pstmt.executeQuery();// 쿼리수행 후 결과 레코드 받기!!

			// rs가 닫히기 전에, rs의 역할을 수행할 가장 근접한 기능을 보유한 객체로 대체해보자~~
			list = new ArrayList<Notice>(); // 배열과 같지만 대상이 오직 객체

			while (rs.next()) {
				Notice notice = new Notice();// 인스턴스 1개 생성

				notice.setNoitce_id(rs.getInt("notice_id"));
				notice.setTitle(rs.getString("title"));
				notice.setWriter(rs.getString("writer"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));

				list.add(notice);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	// 레코드 1건 가지고 오기
	public Notice select(int notice_id) {
		String url = "jdbc:mysql://localhost:3306/jsp?characterEncoding=utf8";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Notice notice =null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버 로드
			con = DriverManager.getConnection(url, "root", "1234"); // 접속 객체 얻기
			String sql = "select * from notice where notice_id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_id); // 바인드 변수값 지정

			//rs가 곧 죽기전에, 대체제를 고민해보자
			rs = pstmt.executeQuery(); // 쿼리실행
			rs.next();
			notice = new Notice();
			notice.setNoitce_id(rs.getInt("notice_id"));
			notice.setTitle(rs.getString("title"));
			notice.setWriter(rs.getString("writer"));
			notice.setContent(rs.getString("content"));
			notice.setRegdate(rs.getString("regdate"));
			notice.setHit(rs.getInt("hit"));
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return notice;
	}
	
	//글 한 건 수정하기
	public int update(Notice notice) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result= 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jsp?characterEncoding=utf8";
			con = DriverManager.getConnection(url,"root","1234");
			
			String sql = "update notice set title=?,writer=?,content=? where notice_id=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getWriter());
			pstmt.setString(3, notice.getContent());
			pstmt.setInt(4, notice.getNoitce_id());
			
			result = pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	//레코드 1건 삭제처리
	public int delete(int notice_id) {
		Connection con =null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			Class.forName("com.mysql.jdbc.Driver"); //드라이버 로드(db선택)
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","1234");
			String sql ="delete from notice where notice_id=?";
			pstmt=  con.prepareStatement(sql);
			pstmt.setInt(1, notice_id);
			
			result =pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}

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
 * ���� Notice�� ���� crud���� �����ϴ� ��ü�� ������, ���ø����̼� ����о߿����� 
 * DAO(Data Access Object)
 * 
 * CRUD( create read update delete)
 * */
public class NoticeDAO2 {

	/*
	 * 1)����̹� �ε� 2)���� 3)������ ���� 4)��������
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
			Class.forName("com.mysql.jdbc.Driver"); // ����̹� �ε�
			con = DriverManager.getConnection(url, "root", "1234"); // ����
			String sql = "select * from notice order by notice_id desc";
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // ���� ��ü
																												// ����
			rs = pstmt.executeQuery();// �������� �� ��� ���ڵ� �ޱ�!!

			// rs�� ������ ����, rs�� ������ ������ ���� ������ ����� ������ ��ü�� ��ü�غ���~~
			list = new ArrayList<Notice>(); // �迭�� ������ ����� ���� ��ü

			while (rs.next()) {
				Notice notice = new Notice();// �ν��Ͻ� 1�� ����

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

	// ���ڵ� 1�� ������ ����
	public Notice select(int notice_id) {
		String url = "jdbc:mysql://localhost:3306/jsp?characterEncoding=utf8";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Notice notice =null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ����̹� �ε�
			con = DriverManager.getConnection(url, "root", "1234"); // ���� ��ü ���
			String sql = "select * from notice where notice_id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_id); // ���ε� ������ ����

			//rs�� �� �ױ�����, ��ü���� ����غ���
			rs = pstmt.executeQuery(); // ��������
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
	
	//�� �� �� �����ϱ�
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
	
	//���ڵ� 1�� ����ó��
	public int delete(int notice_id) {
		Connection con =null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			Class.forName("com.mysql.jdbc.Driver"); //����̹� �ε�(db����)
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

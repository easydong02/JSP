package com.koreait.springmvc1223.model.repository.notice;

import java.util.List;

import com.koreait.springmvc1223.domain.Notice;

//모든 DAO구현할 상위 DAO정의
public interface NoticeDAO {
	public List selectAll();
	public int insert(Notice notice);
	public Notice select(int notice_id);
	public int update(Notice notice);
	public int delete(int notice_id);
}

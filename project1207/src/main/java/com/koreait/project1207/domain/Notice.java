package com.koreait.project1207.domain;


//������ �ƴ� �ܼ��� ���̺��� ���ڵ� �� ���� ���, Ŭ���̾�Ʈ�� ������ �� �����͸� ��� ���� �뵵�� ��ü
public class Notice {
	private int noitce_id;
	private String writer;
	private String title;
	private String content;
	private String regdate;
	private int hit;
	
	public int getNoitce_id() {
		return noitce_id;
	}
	public void setNoitce_id(int noitce_id) {
		this.noitce_id = noitce_id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}

	public Notice() {
	}
	
}

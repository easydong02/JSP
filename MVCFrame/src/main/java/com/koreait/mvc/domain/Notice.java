package com.koreait.mvc.domain;

import lombok.Data;

@Data
public class Notice {
	private int notice_id;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private int hit;
}

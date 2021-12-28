package com.koreait.mvc.domain;

import java.util.List;

import lombok.Data;

@Data
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	
	
	//나는 여러명의 부원을 갖는다.
	List<Emp> empList;
}

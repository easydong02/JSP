package com.koreait.mvc.domain;

import lombok.Data;

@Data
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int sal;
	
	
	//나는 한명의 부모를 갖는다
	private Dept dept;
}

package com.koreait.mvc.domain;

import lombok.Data;

@Data
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int sal;
	
	
	//���� �Ѹ��� �θ� ���´�
	private Dept dept;
}

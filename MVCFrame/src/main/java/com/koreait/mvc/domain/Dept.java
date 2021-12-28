package com.koreait.mvc.domain;

import java.util.List;

import lombok.Data;

@Data
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	
	
	//���� �������� �ο��� ���´�.
	List<Emp> empList;
}

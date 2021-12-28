package com.koreait.mvc.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.Getter;

//페이징 처리를 보다 효율적으로 개발하기 위해
@Getter
public class Pager {
	int totalRecord;
	int pageSize=10;
	int totalPage;
	int blockSize = 10;
	int currentPage =1;
	int firstPage;
	int lastPage;
	int curPos;
	int num;
	
	public void init(List list, HttpServletRequest request) {
		totalRecord = list.size();
		totalPage = (int)Math.ceil((float)totalRecord/pageSize);
		if(request.getParameter("currentPage") !=null){ //페이지 번호를 클릭해서 요청하는 경우라면..? currentPage=3
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		firstPage = currentPage-(currentPage-1)%blockSize;
		lastPage = firstPage +(blockSize -1);
		curPos= pageSize*(currentPage -1); //페이지 당 시작 커서의 위치(List내에서)
		num= totalRecord -curPos;
	}
}

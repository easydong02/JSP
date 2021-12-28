/*이 클래스의 정의 목적 자주 사용되는 코드 재사용*/
package com.koreait.util;

public class FileManager{
	
	//확장자만 추출하는 메서드 정의
	public String getExt(String filename){
		int lastIndex= filename.lastIndexOf(".");
		String ext=filename.substring(lastIndex+1,filename.length());
		return ext;
	}
}

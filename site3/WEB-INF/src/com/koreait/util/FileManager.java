/*�� Ŭ������ ���� ���� ���� ���Ǵ� �ڵ� ����*/
package com.koreait.util;

public class FileManager{
	
	//Ȯ���ڸ� �����ϴ� �޼��� ����
	public String getExt(String filename){
		int lastIndex= filename.lastIndexOf(".");
		String ext=filename.substring(lastIndex+1,filename.length());
		return ext;
	}
}

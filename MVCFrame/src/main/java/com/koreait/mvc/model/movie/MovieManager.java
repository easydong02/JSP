package com.koreait.mvc.model.movie;

public class MovieManager {
	
	public String getMsg(String movie) {
		String msg = null;
		
		if(movie.equals("��Ʈ����")) {
			msg = "��Ʈ������ ������ �����Դϴ�.";
		}else if (movie.equals("��ٿ�Ÿ��")) {
			msg="��ٿ�Ÿ���� ������ 4.45�Դϴ�";
		}else if (movie.equals("��ũ����Ʈ")) {
			msg="��ũ����Ʈ�� ������ �����Դϴ�.";
		}else if (movie.equals("�����а���")) {
			msg="�����а����� ������ 4.43�Դϴ�";
		}
		
		return msg;
	}
	
}

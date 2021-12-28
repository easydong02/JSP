package com.koreait.mvc.model.movie;

public class MovieManager {
	
	public String getMsg(String movie) {
		String msg = null;
		
		if(movie.equals("매트릭스")) {
			msg = "매트릭스의 평점은 만점입니다.";
		}else if (movie.equals("어바웃타임")) {
			msg="어바웃타임의 평점은 4.45입니다";
		}else if (movie.equals("다크나이트")) {
			msg="다크나이트의 평점은 만점입니다.";
		}else if (movie.equals("건축학개론")) {
			msg="건축학개론의 평점은 4.43입니다";
		}
		
		return msg;
	}
	
}

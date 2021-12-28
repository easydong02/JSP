package com.koreait.mvc.model.blood;

public class BloodManager {
	public String getAdvice(String blood) {
		String msg =null;
		
		if(blood.equals("A")){
			msg = "세심하고 책임감 강하다";
		}else if(blood.equals("B")){
			msg="남자: 고집이 세다, 여자: 4차원이다..";
		}else if(blood.equals("AB")){
			msg="여자: 시시각각 변한다";
		}else if (blood.equals("O")){
			msg="쓸데없이 오지랖이 넓다.";
		}
		return msg;
	}
	
	
}

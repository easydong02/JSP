package com.koreait.mvc.model.blood;

public class BloodManager {
	public String getAdvice(String blood) {
		String msg =null;
		
		if(blood.equals("A")){
			msg = "�����ϰ� å�Ӱ� ���ϴ�";
		}else if(blood.equals("B")){
			msg="����: ������ ����, ����: 4�����̴�..";
		}else if(blood.equals("AB")){
			msg="����: �ýð��� ���Ѵ�";
		}else if (blood.equals("O")){
			msg="�������� �������� �д�.";
		}
		return msg;
	}
	
	
}

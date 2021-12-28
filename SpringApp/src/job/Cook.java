package job;

import tool.Fripan;
import tool.Pan;

//요리사를 정의한다!!
public class Cook {
	private Pan pan;
	
	
	// Dependency Injection DI
	// 의존성 약화를 위한 객체 주입
	public void setPan(Pan pan) {
		this.pan = pan;
	}

	public void makeFood() {
		pan.boil();
	}
}

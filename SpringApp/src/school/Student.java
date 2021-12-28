package school;

public class Student {
	Bell bell;
	
	public Student() {
		bell = new Bell();
	}
	
	public void studyEng() {
		System.out.println("영어를 공부해요");
	}
	public void studyMath() {
		System.out.println("수학을 공부해요");
		
	}
	public void studySci() {
		System.out.println("과학을 공부해요");
	}
	
	public void haveLunch() {
		System.out.println("점심을 먹어요");
	}
	
}

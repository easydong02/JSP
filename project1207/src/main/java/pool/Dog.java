package pool;


//이 클래스로부터 생성되는 인스턴스의 개수를 1개로 제한
//SingleTon 싱글턴 패턴
public class Dog {
	private static Dog instance;
	
	private Dog() {;}
	
	public void run() {
		System.out.println("강아지가 달려요");
	}
	
	//인스턴스를 반환하는 메서드
	public static Dog getInstance() {
		if(instance ==null) { //생성된 적이 없을 때
		instance = new Dog();
		}
		return instance;
	}
}

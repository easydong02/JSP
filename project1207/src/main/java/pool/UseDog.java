package pool;

public class UseDog {

	public static void main(String[] args) {
		//���̻� ������ ȣ�⿡ ���� �ν��Ͻ� ������ �Ұ�..
		Dog d1 = Dog.getInstance();
		Dog d2 = Dog.getInstance();
		
		System.out.println(d1);
		System.out.println(d2);
		d1.run();
		
	}

}

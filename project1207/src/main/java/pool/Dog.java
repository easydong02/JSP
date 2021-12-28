package pool;


//�� Ŭ�����κ��� �����Ǵ� �ν��Ͻ��� ������ 1���� ����
//SingleTon �̱��� ����
public class Dog {
	private static Dog instance;
	
	private Dog() {;}
	
	public void run() {
		System.out.println("�������� �޷���");
	}
	
	//�ν��Ͻ��� ��ȯ�ϴ� �޼���
	public static Dog getInstance() {
		if(instance ==null) { //������ ���� ���� ��
		instance = new Dog();
		}
		return instance;
	}
}

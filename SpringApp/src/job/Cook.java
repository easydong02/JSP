package job;

import tool.Fripan;
import tool.Pan;

//�丮�縦 �����Ѵ�!!
public class Cook {
	private Pan pan;
	
	
	// Dependency Injection DI
	// ������ ��ȭ�� ���� ��ü ����
	public void setPan(Pan pan) {
		this.pan = pan;
	}

	public void makeFood() {
		pan.boil();
	}
}

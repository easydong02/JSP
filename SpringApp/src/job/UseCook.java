package job;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import view.MyFrame;

public class UseCook {

	public static void main(String[] args) {
		//javaEE������ ������ �����ڰ� �ڹ��ڵ� �ȿ��� �ش� Ŭ������ ���� new���� ����,
		//��ü�� �������ִ� �����������ӿ��� �̿��Ͽ� ���Թ޾� �������!
		//�����������ӿ� ��ü �� ��, ����xml�� �ؼ� �� ������ ��, ��ü���� 
		//�޸𸮿� �ø��� �������ִ� ��ü�� ������ ��(java class) �����̳ʶ� �ϸ�, �� �����̳ʸ� ǥ���� ��ü��
		//�ٷ� ApplicationContext�̴�!!
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/context.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/swing-context.xml");
		//Cook cook  = (Cook)context.getBean("cook");
		MyFrame myFrame = (MyFrame)context.getBean("myFrame");
		
		//�丮�簡 �丮�� �ϱ� ����, ��ü�� ��������
		//cook.makeFood();
	}

}

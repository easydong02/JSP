package school;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseStudent {
	public static void main(String[] args) {
		//�����ڰ� ������ ������ ���������� �о� ����� �ν��Ͻ���
		//���� �� �����ϴ� ��ü�� ApplicationContext�� �����Ѵ�
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/aop-context.xml");
		
		Student st= (Student)context.getBean("student");
		
		st.studyEng();
	}
}

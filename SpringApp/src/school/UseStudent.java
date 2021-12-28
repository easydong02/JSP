package school;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseStudent {
	public static void main(String[] args) {
		//개발자가 설정한 스프링 빈설정파일을 읽어 빈들의 인스턴스를
		//생성 및 관리하는 객체인 ApplicationContext를 생성한다
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/aop-context.xml");
		
		Student st= (Student)context.getBean("student");
		
		st.studyEng();
	}
}

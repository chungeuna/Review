package DI_04_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		//java 코드 
	//	MessageBeanImpl messagebean = new MessageBeanImpl("hong");
	//	messagebean.setGreeting("hello");
	//	messagebean.sayHello();
		//ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_04_Spring/DI_04.xml");
		MessageBean messagebean = context.getBean("m1",MessageBeanImpl.class);
		messagebean.sayHello(); 
		//제네릭 xml 컨테이너 객체 
		//DI  의존성 주입 
		//상속과 포함 >> has - a >>  클래스 안에 멤버변수로 갖고 있다 
		//생성자 주입과 setter 주입 
	}
}
/* 
요구사항 
영문버전 (hong) : hello hong! 
한글버전  (hong) : 안녕 hong!

2가지 요구사항 

두개의 클래스를 만들기 
한글 버전을 갖고있는 
messagebean_kr > 함수 > sayHello
messagebean_eng > 함수 > sayHello 

>> 인터페이스 : MessageBean 인터페이스 설계 >> kr, en  구현 


*/
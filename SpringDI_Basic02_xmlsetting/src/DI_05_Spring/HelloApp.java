package DI_05_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		/*
		 * MyBean mybean = new MyBean(); MyBean mybean2 = new MyBean("hong"); Singleton
		 * single = Singleton.getInstance(); Singleton single2 =
		 * Singleton.getInstance();
		 */
		
	//	System.out.println("mybean : " + mybean); // DI_05_Spring.MyBean@15db9742
	//	System.out.println("mybean2 : " + mybean2); // DI_05_Spring.MyBean@6d06d69c
	//	System.out.println("single : " + single); // DI_05_Spring.Singleton@7852e922
	//	System.out.println("single2 : " + single2); // DI_05_Spring.Singleton@7852e922
		//싱글톤은 주소값이 같다 
		
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_05_Spring/DI_05.xml");
		/* 스프링 컨테이너가 구성되고 xml 파일을 read 해서 parsing 한다 
		 * 객체를 생성하고 생성된 객체를 조립한다 
		 * 필요한 객체를 주입한다 
		 * >> 이제 컨테이너 안에는 객체들이 들어있다 
		 * 
		 * 그 안에서 필요한 객체를 불러내면 된다 
		 * 사용하려면 별도의 코드가 필요하다 context도 메모리의 주소다 
		 * 
		 * getBean : 컨테이너 안 함수를 갖고오는 함수
		 * 제너릭을 하면 갖고오면서 타입변환을 한다 
		 * 
		 * getBean() return Object타입의 객체 >>  필요에 따라 내가 만든 타입으로 변환해서 사용 
		 * **POINT  주의 : getBean은 호출 시에 새로운 객체를 만들지 않는다 
		 * ** 스프링 컨테이너가 가지는 객체의 타입은 디폴트로 싱글톤을 쓴다  > 굳이 싱글톤의 설계를 가져갈 필요가 없다 
		 * ** "예외"적으로 getBean 함수가 객체를 생성하게 할 수가 있다 > 옵션 부여하면 
		 * getBean할 때마다 new (but 거의 사용하지 않는다) 
		 * 
		 */
		//context 할 때 ,객체가 만들어진다  
		MyBean mybean = context.getBean("mybean",MyBean.class); 
		MyBean mybean2 = context.getBean("mybean",MyBean.class);
		MyBean mybean3 = context.getBean("mybean",MyBean.class);
		//getBean은 만들어진 주소값을 불러오는 것 >> 그러므로 주소값 같다 
		// 스프링은 객체를 싱글톤으로 만든다 >> 하나의 객체를 만들고 공유한다 
		System.out.println("mybean :" + mybean);  //DI_05_Spring.MyBean@5700d6b1 
		System.out.println("mybean2 :" + mybean2); //DI_05_Spring.MyBean@5700d6b1
		System.out.println("mybean3 :" + mybean3); //DI_05_Spring.MyBean@5700d6b1
		
		//mybean2는 주소값이 다르다 
		MyBean mybean22 = context.getBean("mybean2",MyBean.class);
		System.out.println(mybean22); //DI_05_Spring.MyBean@6fd02e5 
		
		Singleton single = context.getBean("single",Singleton.class);
		Singleton single2 = context.getBean("single",Singleton.class);
		System.out.println(single);
		//스프링은 싱글톤 설계할 필요가 없다 
		
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
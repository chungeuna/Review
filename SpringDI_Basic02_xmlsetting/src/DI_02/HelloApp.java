package DI_02;

public class HelloApp {
	public static void main(String[] args) {
		//영문
		//MessageBean_en messagebean_en = new MessageBean_en();
		//messagebean_en.sayHello("hong");
		
		//한글 
		//MessageBean_kr messagebean_kr = new MessageBean_kr();
		//messagebean_kr.sayHello("hong");
		
		//interface를 이용하면 하나의 참조 변수가 여러개의 주소를 가질 수 있다(다형성) 
		MessageBean messagebean_kr = new MessageBean_kr();
		messagebean_kr.sayHello("hong");
		
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
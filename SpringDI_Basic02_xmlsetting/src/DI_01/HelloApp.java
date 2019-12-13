package DI_01;

public class HelloApp {
	public static void main(String[] args) {
		MessageBean messagebean = new MessageBean();
		messagebean.sayHello("hong");
		
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
package Spring_DI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
	//	NewRecordView view = new NewRecordView();
	//	NewRecord record = new NewRecord();
	//	view.setRecord(record); //필요한 객체의 주소 주입 (injection) 
	//	view.input();
	//	view.print();
		
	//이 메인함수에서는 스프링 프레임워크가 제공하는 메모리 생성 (inversion of control IOC 컨테이너) 
	//**컨테이너 만들고 그 공간에 필요한 객체를 올려놓고 주입 작업  (공간 만들고 xml을 읽고 bean으로 객체만들고 컨테이너에 객체를 주입한다)
	//application 
	ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
	//컨테이너가 만들어지는 주소 xml 경로를 써야한다 
	//context는 컨테이너의 주소값을 갖는다 
	//getBean > 컨테이너 안에서 꺼내는 함수 
	RecordView view = (RecordView)context.getBean("view");
	view.input();
	view.print();
	//
	}
}

package DI_07_Spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
	    //1. java 코드로 구현하기 
	//	ProtocolHandler handler = new ProtocolHandler();
		
	//	List<MyFilter> list = new ArrayList<MyFilter>();
	//	list.add(new EncFilter());
	//	list.add(new HeaderFilter());
	//	list.add(new ZipFilter());
		
	//	handler.setFilters(list);  //setter로 리스트 주입  >> 스프링으로는 어떻게 ? 
    //		System.out.println(handler.filter_length()); //3  
		
		//2. 스프링으로 구현하기 
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_07_Spring/DI_07.xml");
		ProtocolHandler handler = context.getBean("handler",ProtocolHandler.class);
		System.out.println(handler.filter_length());
	}
}

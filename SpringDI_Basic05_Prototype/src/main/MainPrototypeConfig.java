package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Spring.Client;
import Config.JavaConfigPrototype;

public class MainPrototypeConfig {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(JavaConfigPrototype.class);
		Client client =  context.getBean("client", Client.class);
		Client client2 = context.getBean("client", Client.class);
		System.out.println("client : " + client.toString()); //Spring.Client@543e710e
		System.out.println("client2 : " + client2.toString()); //Spring.Client@57f23557
		//다른 주소값이 찍힌다 > 프로토타입이 있을 경우  getBean 호출시 새로운 객체 리턴 
		// 
	}

}

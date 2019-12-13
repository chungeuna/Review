package Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import Spring.Client;

//xml > java 파일 > prototype 설정

@Configuration
public class JavaConfigPrototype {
	
/*	
  <bean id="client" class="Spring.Client" scope="prototype">
	<property name="host" value="webserver"></property>
	</bean>
*/
	@Bean
	@Scope("prototype")
	public Client client(){
		Client client = new Client();
		client.setHost("webserver");
		return client;
	} //객체를 만들고 
	//new Client().setHost("webserver"); 
	//리턴 타입이  안 맞음 ... 메소드 리턴 ... 
	//객체 만들고 setter 함수로 주입 
	//여러개 어노테이션이 사용될 수 있다 
	
	
}
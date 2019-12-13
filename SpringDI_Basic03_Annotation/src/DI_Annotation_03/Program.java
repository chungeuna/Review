package DI_Annotation_03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		//1. java 코드 구현 
		/*
		 * MonitorViewer viewer = new MonitorViewer(); Recorder recorder = new
		 * Recorder(); viewer.setRecorder(recorder);
		 * System.out.println(viewer.getRecorder());
		 */ //주소값 출력 
		//1. xml로 만들기 
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_Annotation_03/DI_03.xml");
		MonitorViewer viewer = context.getBean("viewer",MonitorViewer.class);
		System.out.println(viewer.getRecorder());
		//aop 라이브러리 주입  > 관점지향 
	}
}

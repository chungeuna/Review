package AOP_Basic_02_JAVA;

import java.lang.reflect.Proxy;

public class Program {
	public static void main(String[] args) {
		Calc calc = new NewCalc();
		//인터페이스가 실제 구현한 객체의 주소값을 가지고 있다 
	
		//calc.ADD(100, 100); //실객체로 바로 접근 
		//proxy 객체 통해서 처리 		
		Calc cal = (Calc)Proxy.newProxyInstance(calc.getClass().getClassLoader(),
									//1.실객체의 주소값(메타정보)를 넘긴다 //로딩(메모리에 올리는것)까지 해야한다
				calc.getClass().getInterfaces(), //행위정보 //어떤 함수가 있는지 정보 > 인터페이스가 갖고 있다 // 인터페이스를 알려준다
				new LogPrintHandler(calc)); //보조관심 (보조객체) 넣어준다 >> 파라미터로 실객체 주소 넣어줌 
		
		//프록시를 통해서 처리하지만 사용자는 실제 calc 객체를 사용하는것처럼 ..
		//인터페이스정보를 갖고있기 때문에 
		int result = cal.ADD(100, 20);
		System.out.println("Main result : " + result);
	}
}

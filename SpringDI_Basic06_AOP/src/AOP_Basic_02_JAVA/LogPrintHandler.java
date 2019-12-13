package AOP_Basic_02_JAVA;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;
//보조관심 (공통관심)
//invoke : 하나의 함수가 여러개의 함수를 대리 처리 
//invoke : 주업무의 함수가 
//add,mul,sub 누군가 대리해서 처리해야한다 
public class LogPrintHandler implements InvocationHandler{

	//실 객체의 주소가 필요 > 실제 add 함수의 주소 
	private Object target; //실객체의 주소값 
	public LogPrintHandler(Object object) {
		System.out.println("LogPrintHandler : 보조관심 생성자 호출");
		this.target = object; 
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke 함수 호출 ");
		System.out.println("method 호출 함수명 : " + method);
		System.out.println("함수 메서드의 파라미터 값  : " + Arrays.toString(args));
		//보조(공통) 업무 (advice) 
		Log log = LogFactory.getLog(this.getClass());  //현재 동작하고있는 객체 
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		//주업무 (실객체의 함수 호출) 
		int result = (int)method.invoke(this.target, args);
		
		//보조(공통) 업무 (advice) 
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[TIME LOG Method : ADD ]");
		log.info("[TIME LOG Method Time : " + sw.getTotalTimeMillis() + "]");
		
		return result;
	}

}

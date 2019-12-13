package AOP_Basic_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

/* 간단한 계산기 프로그램 
 * - 주관심 (업무) : 사칙연산(ADD,MUL) -> 기능(함수) 
 * - 보조관심 (공통관심사항) : 연산에 걸린 시간을 구하라  
 * - log 출력(conosle 출력 : 시스템이 출력하는 것처럼 red 색으로 ... 시간을) 
 * 
 */
public class Calc {
	public int add(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());  //현재 동작하고있는 객체 
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		int result = x+y; //주관심 
		
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[TIME LOG Method : ADD ]");
		log.info("[TIME LOG Method Time : " + sw.getTotalTimeMillis() + "]");  //stop - start 시간 측정 
		
		return result;
	}
	public int mul(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());  //현재 동작하고있는 객체 
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		int result = x*y; //주관심 
		
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[TIME LOG Method : MUL ]");
		log.info("[TIME LOG Method Time : " + sw.getTotalTimeMillis() + "]");
		
		return result;
	}
	
	
}

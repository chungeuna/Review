package com.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/* public class HelloController implement Controller
 * 단점 : 요청 당 컨트롤러를 만들어야 한다 하나의 요청만을 처리 ...
 * 10개의 요청만을 처리 ...
 * 10개의 요청이라면 ... Controller 10개 
 * Annotation 사용하면 method 단위로 매핑을 할 수 있다 
 * 결국: 하나의 컨트롤러가 다수의 요청을 처리할 수 있다  >> 대신 method 10개 
 * 
 * 1. implements Controller: 매핑 단위가 클래스 
 * 2. @Controler  사용하면 >> 함수 단위 매핑 
 * 	  @RequestMapping() 사용해서 주소 매핑 
 *    >> HelloController >> bean 생성 
 *    
 *    
 */
@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")  //<a href="hello.do">
	public ModelAndView Hello() {
		System.out.println("hello.do start");
		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting",getGreeting());
		mv.setViewName("Hello");
		return mv;		
	}
	
	//필요하다면 일반함수는 만들어 쓰면 된다 
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String data= "";
		if(hour >= 6 && hour < 10) {
			data = "학습시간";
		} else if(hour >= 11 && hour <=15) {
			data = "배고픈 시간";
		} else if(hour >= 16 && hour < 18) {
			data = "졸린 시간";
		} else {
			data = "집";
		}
		return data;
	}
	
}

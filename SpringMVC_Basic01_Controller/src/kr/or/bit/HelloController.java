package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	public HelloController () {
		System.out.println("helloController 객체 생성 ");
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("helloController 요청 실행 : handleRequest  함수 실행 ");
		
		//업무 수행 
		//데이터 담고, view 지정 
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","hong");  //request.setAttribute() 
		mav.setViewName("hello"); // view 지정 
		return mav;
	}

}

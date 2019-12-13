package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	//요청당 필요한 함수 구현 
	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) {
		response.addCookie(new Cookie("auth","1004"));
		//servlet 방법과 동일 
		return "/cookie/CookieMake"; //뷰단 굳이 필요는 없지만 ... 학습용  > void return 없이 
	}
	
	//public String view(HttpServletRequest request) {
	//value="읽어온 쿠키 값" > 실제로 값이 없을 수도 있다 > defaultvalue 
	//1. request 값으로 얻어오기 (전통적인 방법) 
	//2. @CookieValue 어노테이션으로 값 가져오기 
	@RequestMapping("/cookie/view.do")
	public String view(@CookieValue(value="auth",defaultValue = "1000") String auth) {
		System.out.println("클라이언트에서 read한 쿠키 값  : " + auth);
		return "/cookie/CookieView"; 
	}
}

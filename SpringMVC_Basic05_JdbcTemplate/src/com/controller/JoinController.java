package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDAO;

@Controller
public class JoinController {
	//db작업 
	//DAO .... memberDAOImpl에 의존한다 
	//member field
	//인터페이스 타입  >> 객체의 생성과 조립을 위해 
	// 어떠한 부품도 조립이 되어야한다 > 표준화 > 다형성이란 측면이 구현되어야한다 > 인터페이스가 있어야한다 
	// 스프링 : 소프트웨어는 변화한다 > 변화에 대응하자 > 인터페이스 
	private MemberDAO memberdao;
	
	@Autowired  //by type 
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}
	
	@RequestMapping(value="/join.do",method= RequestMethod.GET)
	public String form() {	
		return "joinForm";
	}
	//requestParam의 장점 > default값을 설정할 수 있다 
	//회원가입, 게시판 글쓰기 : DTO 설정 : 파라미터로 DTO 받음 ... 
	//1. required= false 2. Integer age 
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String submit(@RequestParam(value="id", required=true) String id,
						 @RequestParam(value="name") String name,
						 @RequestParam(value="pwd") String pwd,
						 @RequestParam(value="email", defaultValue = "1@1.com") String email,
						 @RequestParam(value="age", defaultValue = "1") Integer age) {
		String view = null;
		boolean joinResult = memberdao.memberInsert(id, name, pwd, email, age);
		if(joinResult) {
			view = "joinSuccess";
		}else {
			view = "joinForm";
		}
		return view;		
	}
	
	
	
}

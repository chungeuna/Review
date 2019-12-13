package com.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDAO;

/*
 *  로그인 화면 : GET 요청 > loginForm
 *  로그인 처리 : POST 요청 > id, pwd > memberCheck 검증 > loginSuccess(빈페이지)
 *  
 *  조건 : 인증 성공하면 session 담기 > [기존 servlet 과 동일]
 * 
 *  public void test(HttpSession session){
 *    session.setAttribute("USERID", "hong")
 *  }
 * 
 */
@Controller
//@RequestMapping("/login.do")
public class LoginController {
   
	private MemberDAO memberdao;
	
	@Autowired  //멤버필드로도 주입 가능하지만,,,,생성자,setter로 주입해라 
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	} 
	
	
	//get 로그인 화면 
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "loginForm";
	}
	
	//post : memberCheck DAO  함수 호출 ... id, pwd 파라미터 > session.setAttribute("USERID", "hong") 세션에 담기 
	//memberCheck  > true 값이 넘어오면 로그인 성공 > false 값이 넘어오면  다시 로그인 폼으로  
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String loginSuccess(@RequestParam(value="id") String id, @RequestParam(value="pwd") String pwd, HttpSession session) {
		boolean memberChk = false;
		String view = null;
		try {
			memberChk= memberdao.memberCheck(id, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(memberChk) {
			session.setAttribute("USERID", id);
			view = "loginSuccess";
		} else {
			view = "loginForm";
		}
		return view;
	}
	public void test(HttpSession session, String id, String pwd) {
		session.setAttribute(id, pwd);
	}
}












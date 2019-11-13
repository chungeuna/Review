package kr.or.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memodao;
import kr.or.bit.dto.memo;
import kr.or.bit.service.MemoServletAction;

//localhost:8090/WebServlet_3/MemoServlet
@WebServlet("/MemoServlet")
public class MemoServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
   
    public MemoServlet() {
        super();
       
    }

 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doProcess(request, response);
 }

 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doProcess(request, response);
 }
 private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //요청의 판단은 하지 않음 통으로>> 이 servlet은 insert에 동작하는 servlet 
	 
	String requestURI = request.getRequestURI();
 	String contextPath = request.getContextPath();
 	String url_Command = requestURI.substring(contextPath.length());
  
 	
 	ActionForward forward = new ActionForward();
 	Action action = new MemoServletAction();
 	action = new MemoServletAction();
 	forward = action.execute(request, response);
 	System.out.println("F : " + forward);
 if(forward != null) {
		if(forward.isRedirect()) { //true 없어요 (url 값 변경) 
			response.sendRedirect(forward.getPath());
		} else {
			//forward > 뷰단 페이지가 데이터 처리하게 
			//주소가 바뀌지 않는다 
			//처음 주소가 갖고있는 주소가 버퍼를 쓰기 때문에 
			System.out.println("여기탐?");
			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
			dis.forward(request, response);
		}
  
 }
 }
 
}


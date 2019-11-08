package com;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* 서블릿(servlet) 
 * java 파일로  웹 서비스를 할 목적으로 만든 파일 
 * 서블릿 파일 조건 : (웹:request, response) 객체 사용 가능 
 * 
 * 1.extends HttpServlet 반드시 상속(웹 환경에서 요청과 응답을 처리할 수 있다) 
 * 2. SimpleController >> 서블릿 
 * 3. 서블릿은 이벤트 기반으로 동작 (특정 함수들이 상황에 맞추어 자동 호출) 
 * ex) 페이지가 로드되고 나면 ... 함수 호출 
 * protected void doGet
 * protected void doPost  2개의 함수가 자동 호출 
 * 시점) 어떤 사건이 발생되면 자동으로 호출될까 >> 
 * 클라이언트가 SimpleController 요청하면 
 * 요청 방식 (GET) : doGet 함수 >> 자동 호출 
 * doGET() -> <a href= "board.do?id=kglim">클릭</a>
 * 요청 방식(POST) : doPost 함수  >> 자동 호출 
 * doPOST() -> <form methodd="post" action="">
 * 
 * 3.1 클라이언트 정보를 얻는다  : request.getParameter 
 * 
 * 4. jsp > localhost:8090/WebSite/index.jsp(요청) 
 * 
 * servlet > localhost:8090/WebSite/SimpleController.java (x)
 * 
 * <url-pattern>/simple</url-pattern>
 * servlet > localhost:8090/WebSite/simple
 * 
 * 서블릿(java> -> 컴파일 -> class 파일 생성 -> 실행 -> 결과 
 * 기본적으로 서블릿은 멀티 쓰레드 환경을 제공 
 */
/** 이벤트 기반>> 페이지가 로드되고 나면 
 * Servlet implementation class SimpleController
 */
/*
서블릿(servlet)
java 파일로 웹 서비스를 할 목적으로 만든 파일 
서블릿 파일조건 : (웹 : request, response) 객체 사용 가능

1. extends HttpServlet 반드시 상속(웹 환경에서 요청, 응답) 처리 가능

2. SimpleController 서블릿

3. 서블릿은 이벤트 기반 동작 (특정 함수들이 상황에 맞추어 자동 호출) 
   ex) 페이지가 로드되고 나면 ...함수 호출
   protected void doGet
   protected void doPost 2개의 함수가 자동 호출
     시점) 어떤 사건이 발생되면 자동 호출 될까
     클라이언트가 SimpleController 요청하면 
     요청방식(GET) : 자동 호출(doGET)  : protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doGET() -> <a href="board.do?id=kglim>클릭</a>  
     
     요청방식(POST): 자동 호출(doPOST) : protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
   doPOST() -> <form method="post" action="" ...
   
   3.1 클라이언트 정보를 얻는다 : request.getParamter()
   
4. jsp > localhost:8090/WebSite/index.jsp  (요청)

   servlet > localhost:8090/WebSite/SimpleController.java (x)
   
   <url-pattern>/simple</url-pattern>
   servlet > localhost:8090/WebSite/simple 요청
   
   서블릿(java) -> 컴파일 -> class 파일 생성 -> 실행  -> 결과 리턴
   기본적으로 서블릿은 멀티 쓰레드 환경을 제공   

 >> web.xml 에서 설정
 >>페이지에서 어노테이션으로 설정
 
12시 서버 오픈 -> SimpleController (java) 파일 
-> 순이: 최초 요청 (localhost:8090/Website/simple) -> servlet 컴파일 (class 파일 실행파일) 
-> 요청 (doGet() or doPost()가 자동호출) -> 클라이언트에게 응답 

-> 철이: 요청 (localhost:8090/Website/simple) ->실행 -> doGet() or doPost() -> 응답

-> 그러면 다시 컴파일 된다면 .... 언제... (서버 리부팅 / 개발자의 코드 수정) 


모델1 vs 모델2
모델1: jsp가 클라이언트의 모든 요청 처리 
모델2: mvc: 서블릿: 클라이언트 요청 처리 
jsp: 화면에 보여주는 역할 
(프레젠테이션 레이어와 비지니스 레이어를 분리) 

5. model1 방식 (model2 기반의 mvc 패턴) 
	5.1 JSP만 가지고 개발 : Model1 방식 (DAO, DTO) + JSP 
	5.2 클라이언트의 모든 요청을 JSP가 처리
	5.3 ui + 업무(로직) : JSP 처리 (단점: 유지보수) 
	
	5.4 모델2 기반의 mvc 
	MVC (Model-View-Controller) : 모델: 순수한 자바 파일(플레인 오브젝트), DTO(Emp.java)  ,DAO(EmpDao.java : DB 연결, 실행 함숨0 
	뷰: jsp 또는 html (jsp가 많다/ 서버쪽에서 생상된 코드: 화면 출력: EL & JSTL) 
	컨트롤러: 서블릿 담당 
	1. 클라이언트의 요청 파악(로그인, 게시판 글쓰기, 게시판 상세보기 업무 파악) 
	2. 요청을 파악하고 처리까지 담당 (화면만 전달, DB 연결 insert, 객체 생성) 결정
	
6.
<form action="loginok.jsp" method="post">
>> 192.168.0.3:8090/WebSite/loginok.jsp

<form action="/simple" method="post> 
>> 192.168.0.3:8090/WebSite/simple


*/


//@WebServlet("/SimpleController")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleController() {
        super();
        System.out.println("생성자 호출");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("클라이언트 요청");
		//1. 한글처리 
		
		//2. 사용자 요청 파악 (요청값 받기) 
		String type=request.getParameter("type");
		
		//3. 요청에 따른 업무 수행 (service 실행) 
		Object resultobj = null;
		if(type == null || type.equals("greeting")) {
			resultobj="hello world";
		}else if (type.equals("date")) {
			resultobj = new Date();
		}else {
			resultobj = "invalid String type";
		}
		//4. 요청 완료에 따른 결과를 저장하기 
		//요청한 결과를 저장하는 방법 : request, session, application 객체
		
		request.setAttribute("result", resultobj); //객체 안에 만들어진다 
		
		//5. 저장한 결과를 클라이언트에게 전달하기 (view 지정, jsp) 
		//화면을 출력할 페이지를 정하고 -> 출력할 데이터를 넘겨주고  => forward (제어권) 
		
		RequestDispatcher dis = request.getRequestDispatcher("/simpleview.jsp"); //dispatcher: 출력할 페이지 정의 
		//화면단 지정하고...
		//데이터 전달 
		dis.forward(request, response);  //request 객체의 주소값을 넘긴다 
		
		//simpleview.jsp에게 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

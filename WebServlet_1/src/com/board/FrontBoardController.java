package com.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontBoardController
 */
//@WebServlet("/FrontBoardController")
public class FrontBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

    //GET, POST 두가지 요청에 대해서 모두 동작하는 함수 
    //1. 서블릿에서 제공하는 함수 : service()  함수
    //2. 별도의 함수를 생성해서 ... 개발자 마음 : doProcess()  >> 구별하고 싶으면 파라미터 하나 더 만들기 
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		//get,post 모든 요청 내가 처리 
    	System.out.println("클라이언트 요청 : " + method);
    	//1. 한글처리 
    	
    	//2. 요청받기 : request
    	
    	
    	//3. 요청 판단 : 판단 기준 >> 파라미터 : 커맨드 방식 
    	//3.1 parameter 기준 
    	//3.2 /board?cmd=login&userid=kglim&pwd=1004
    	//String. str = request.getParameter("cmd");
    	//if(str.equals("login")){ 로그인 로직 처리 }
    	
    	//board?cmd=boardlist 
    	//if(str.equals("boardlist")) { 게시판  조회 처리 }
    	
    	//tip) url 주소 판단 
    	//192.168.0.3/:8090/Website/board/boardlist 
    	//192.168.0.3/:8090/Website/board/boardwrite?title=aaa/content=hello
    	
    	//마지막 주소값 추출: 
    	//boardlist >> 화면 게시판 조회 처리
    	//boardwrite >> 게시판 글쓰기 처리 
    	
    	
    	//4. 처리 결과 저장 
    	
    	//5. 뷰 정의 
    	//view page 생성: jsp 생성 
    	//WebContent > board > boardlist.jsp
    	//WebContent > error > error.sjp 
    	//문제점 : 클라이언트가 직접  url 명시 접근 
    	// 192.168.0.3:8090/WebServlet_1/board/boardlist.jsp 
    	//실제 프로젝트는 아래처럼........ 
    	//해결: web-inf 폴더 밑으로 간다 >> 보안 폴더 >> 뷰단 페이지 생성
    	//1. WEB-INF > views > board > boardlist.jsp 
    	//2. WEB-INF > views > board > error.jsp
    	
    	
    	//6. 뷰에게 전달 
    	///////////////////
    	//1. 요청받기 (command) 
    	// 요청 주소 192.168.0.3:8090/WebServlet_1/board?cmd=list 
    	String cmd = request.getParameter("cmd");
    	
    	//2. 요청 판단 (업무에 따라서 정의) 
    	String viewpage = null;
    	//cmd ==null -> error.jsp 뷰단으로
    	//cmd == boardlist -> list.jsp 뷰
    	//cmd == boardwrite -> write.jsp 뷰 
    	
    	if(cmd == null) {
    		viewpage = "/error/error.jsp";
    	}else if(cmd.equals("boardlist")) {
    		viewpage="/board/boardlist.jsp";
    		//DB연결하고 쿼리문 select 날려서 데이터 얻고 
    		//실행한 결과를 담아야 한다 
    		//rs를 객체에 담아서 처리 
    		//dao라는 클래스를 따로 만든다 
    		//boardDao dao = new boardDao();
    		//List<board> boardlist = dao.selectBoardList();
    		//request.setAttribute("list",boardlist);
    		//forward >> view  전달 >> boardlist.jsp 
    		//<c:set var="list" value="<%= request.getAttribute("list")%>"> 
    		//<c:forEach .... > 
    	}else if(cmd.equals("boardwrite")) {
    		viewpage="/board/boardwrite.jsp";
    	}else if(cmd.equals("login")) {
    		viewpage= "/WEB-INF/login/login.jsp"; //실 개발코드 보안 폴더 
    	}else {
    		viewpage = "/error/error.jsp";
    	}
    	//결과 
    	//가정: list<Emp> list = new ArrayList<>();
    	//list.add(new Emp(2000,"김유신");
    	//request.setAttribute("emplist",list);
    	
    	
    	//view 지정 
    	RequestDispatcher dis = request.getRequestDispatcher(viewpage);
    	
    	//view forward 
    	dis.forward(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response,"GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response,"POST");
	}

}

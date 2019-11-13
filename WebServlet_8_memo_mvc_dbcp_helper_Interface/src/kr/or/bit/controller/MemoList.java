package kr.or.bit.controller;

import java.io.IOException;
import java.util.ArrayList;

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
import kr.or.bit.service.MemoListAction;

/**
 * Servlet implementation class MomoList
 */
@WebServlet("/MemoList")
public class MemoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemoList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//view단 페이지 별도 사용: memolist.jsp (이 방식)
		
			//요청 판단은 필요없다 
			//전체 데이터 조회 처리 
			
			
			//view 페이지 설정

			
		
		String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    	
    	ActionForward forward = new ActionForward();
    	Action action = new MemoListAction();
    	forward = action.execute(request, response);
    	
    	if(forward != null) {
    		if(forward.isRedirect()) { //true 없어요 (url 값 변경) 
    			response.sendRedirect(forward.getPath());
    		} else {
    			//forward > 뷰단 페이지가 데이터 처리하게 
    			//주소가 바뀌지 않는다 
    			//처음 주소가 갖고있는 주소가 버퍼를 쓰기 때문에 
    		
    			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
    	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}

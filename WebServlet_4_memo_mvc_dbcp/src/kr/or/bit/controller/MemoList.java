package kr.or.bit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.memodao;
import kr.or.bit.dto.memo;

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
		try {
			//요청 판단은 필요없다 
			//전체 데이터 조회 처리 
			memodao dao = new memodao();
			ArrayList<memo> memolist = dao.getMemolist();
			
			//요청결과를 저장해야한다 
			request.setAttribute("memolist", memolist);
			
			//view 페이지 설정
			RequestDispatcher dis = request.getRequestDispatcher("/memolist.jsp");
			dis.forward(request, response);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			
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

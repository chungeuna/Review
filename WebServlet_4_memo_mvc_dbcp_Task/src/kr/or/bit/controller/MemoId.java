package kr.or.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.memodao;

/**
 * Servlet implementation class MemoId
 */
@WebServlet("/MemoId")
public class MemoId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemoId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); //클라언트에게 전달한 페이지의 정보 구성
		PrintWriter out = response.getWriter();
		 
		String id = request.getParameter("id");
		System.out.println("id: " + id);
		memodao dao = new memodao(); 
		String ischeck = dao.isCheckById(id);
		
		
		//keypoint 
		out.print(ischeck);  //out.print >> 클라이언트에게 true,false만 응답한다 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

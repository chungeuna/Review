package kr.or.bit.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memodao;

public class MemoIdAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
		//	request.setCharacterEncoding("UTF-8");
			 response.setContentType("text/html;charset=UTF-8"); //클라언트에게 전달한 페이지의 정보 구성
			 out = response.getWriter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		String id = request.getParameter("id");
		System.out.println("id: " + id);
		memodao dao = new memodao(); 
		String ischeck = dao.isCheckById(id);
				
		//keypoint 
		out.print(ischeck); 
		
		request.setAttribute("ischeck", ischeck);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("memo.html");
	
		return forward;
	}

}

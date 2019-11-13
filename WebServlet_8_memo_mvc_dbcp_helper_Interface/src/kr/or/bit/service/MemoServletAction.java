package kr.or.bit.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memodao;

public class MemoServletAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null; 
		
		try {
		//	request.setCharacterEncoding("UTF-8");
			out = response.getWriter();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 response.setContentType("text/html;charset=UTF-8"); //클라언트에게 전달한 페이지의 정보 구성
		  
		  
		  
		  String id = request.getParameter("id");
		  String email = request.getParameter("email");
		  
		  String content = request.getParameter("memo");
		  //out.print(id + "," + email + "," + memo);
		  ActionForward forward = new ActionForward();
		  try{
			  memodao dao = new memodao(); //POINT
			  int n = dao.insertMemo(id, email, content);
			
			 
		  	  String msg="";
		  	  String url="";
		  	  
		  	  if(n > 0) {
		  		  msg ="등록성공";
		  		  url ="MemoList";	
		  	  }else { //-1 (제약, 컬럼길이 문제)
		  		  msg ="등록실패";
		  		  url ="memo.html";
		  	  }
		  	  request.setAttribute("board_msg", msg);
		  	  request.setAttribute("board_url", url);
		  	  
		  	  forward = new ActionForward();
		  	  forward.setRedirect(false); //forward 방식
		  	  forward.setPath("/WEB-INF/views/redirect.jsp");
		  }catch(Exception e){
		   out.print("<b> 오류 :" +  e.getMessage()  + "</b>");
		   
		  }
		return forward;
	}

}

<%@page import="kr.or.bit.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");
	
	/* String writer = request.getParameter("writer");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String email = request.getParameter("email");
	String homepage = request.getParameter("homepage");
	String filename = request.getParameter("filename");
	String pwd = request.getParameter("pwd"); */
	
	/*
	Board board = new Board();
	정석적인 방법*/ 
	
%>
<jsp:useBean id="board" class="kr.or.bit.dto.Board" scope="page">
	<jsp:setProperty property = "*" name="board"/> 
</jsp:useBean>
<% 
	BoardService service = BoardService.getInstance();
	int result = service.rewriteok(board);
	
	//list 이동 시 .. 현재 pagesize ,cpage 정보 
	String cpage = request.getParameter("cp");
	String pagesize = request.getParameter("ps");
			String msg = "";
			String url = "";
			if(result > 0) {
				msg = "rewrite 입력 성공";
				url="board_list.jsp";
			}else {
				msg= "rewrite 입력 실패";
				url="board_content.jsp?idx="+ board.getIdx();
			}
			request.setAttribute("board_msg", msg);
			request.setAttribute("board_url", url);
			%>
			<jsp:forward page="redirect.jsp"></jsp:forward>







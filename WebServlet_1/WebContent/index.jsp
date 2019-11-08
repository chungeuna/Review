<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sevlet Test</title>
</head>
<body>
	<h3>Servlet 요청하기</h3>
	<h3>getContextPath() : <%= request.getContextPath() %></h3>
	<a href="<%= request.getContextPath() %>/simple"> 일반 요청하기</a>
	<a href="<%= request.getContextPath() %>/simple?type=date"> 날짜 요청하기</a>
	<a href="<%= request.getContextPath() %>/simple?type=abcd"> 비정상 요청하기</a>
	
	<hr>
	<h3>FrontBoardController</h3>
	<a href="<%= request.getContextPath() %>/board?cmd=boardlist"> 게시판 목록 보기 요청하기</a>
	<a href="<%= request.getContextPath() %>/board?cmd=boardwrite"> 게시판 글쓰기 요청하기</a>
	<a href="<%= request.getContextPath() %>/board?cmd=login"> 로그인 요청하기</a>
	<a href="<%= request.getContextPath() %>/board"> 에러 (파라미터값 없이)</a>
	<a href="<%= request.getContextPath() %>/board?cmd=delete"> 삭제하기 (에러 유도)</a>
	
	<hr>
	<h3>FrontServlet</h3>
	<a href="<%= request.getContextPath() %>/Front.do?cmd=greeting"> 요청 보내기</a>
</body>
</html>

<%@page import="kr.or.bit.dto.Board"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.bit.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="Stylesheet" href="<%=request.getContextPath()%>/style/default.css" />
</head>
<body>
<c:import url="/include/header.jsp" />
<%
BoardService service = BoardService.getInstance();

//게시물 총 건수
int totalboardcount = service.totalBoardCount();

//상세보기 다시 List 넘어올 때 ... 현재 페이지와 페이지 정보를 유지하는 것 
String ps = request.getParameter("ps");  //pagesize
String cp = request.getParameter("cp"); //current page 

if(ps == null || ps.trim().equals("")){
	//default 값 설정 
	ps = "5";	
}

if(cp == null || cp.trim().equals("")){
	//default 값 설정 
	cp = "1";	
}
int pagesize = Integer.parseInt(ps);
int cpage = Integer.parseInt(cp);
int pagecount = 0;

if(totalboardcount % pagesize == 0){ //5의 배수라면 
	pagecount = totalboardcount/pagesize;
}else {
	pagecount= (totalboardcount/pagesize) +1;
}
//총 102건 : pagesize = 5, pagecount = 21개 (102/5 +1)
out.print("pagesize : <h3>" + pagesize + "</h3>");
out.print("totalboardcount : <h3>" + totalboardcount + "</h3>");
out.print("current page : <h3>" + cpage + "</h3>");
out.print("pagecount : <h3>" + pagecount + "</h3>");

//List<Board> list =service.list(1, 5);
List<Board> list =service.list(cpage, pagesize);

out.print("데이터 건수: " + list.size());
%>



<table border="1">
<tr><th>글번호</th><th>글제목</th><th>작성일</th><th>조회수</th>
<c:forEach var="list" items="<%= list %>">
<tr><td>${list.idx}</td>
	<td>${list.subject}</td>
	<td>${list.writedate}</td>
	<td>${list.readnum}</td>
</tr>
</c:forEach>
</table>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> requst 객체 (include된) 파일에선 공유할 수 있다 </h3>
	<hr>
	<%= request.getParameter("type")%>
	<%= request.getParameter("userid")%>
	<hr>
	<h3>메인 페이지에서 param 액션 태그로 전달된 값</h3>
	<% String h = request.getParameter("hobby");
		String p = request.getParameter("pwd");
		if(h.equals("basketball")){
			out.print("<i>당신의 취미는" + h + "</i> ");
		}else {
			out.print("<i>당신의 취미가 없네요</i>");
		}
		out.print("비번: " + p);
	%> 
</body>
</html>
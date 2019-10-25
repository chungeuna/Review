<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Client가 전송한 데이터 받기 
	//Ex09_login.jsp?textuserid=hong&txtpwd=1004 (주소창) 변수명=값
	String userid = request.getParameter("textuserid");
	String pwd = request.getParameter("textpwd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>당신이 입력한 데이터는 </h3>
	ID<%= userid %>  <!--  응답하다  -->
	PWD<%= pwd %>
</body>
</html>
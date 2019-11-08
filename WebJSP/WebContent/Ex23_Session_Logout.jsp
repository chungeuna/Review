<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//로그아웃 
//세션 객체를 소멸시키겠다 
session.invalidate();
//로그인(A001) ... server(A001)
// 이 키에 해당하는 세션 객체를 삭제한다 
//서버를 세션 하나 새로 만들어서 넘겨준다 
out.print("<script> location.href= 'Ex23_Session_Login.jsp';</script>"); 
//세션값이 바뀐다
//
%>
</body>
</html>
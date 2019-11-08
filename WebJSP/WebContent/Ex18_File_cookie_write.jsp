<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1.메모리 쿠키(브라우저 쿠키): 클라이언트가 강제적으로 지우지 않으면 없어지지 않는다, 브라우저를 닫기 전까지 없어지지 않는다 , 강제로 소멸타임:-1
2. 파일쿠키(소멸시간을 가지고 있다): 클라이언트가 강제로 지우지 않는 한, 정해진 시간, 
	setMaxage(60) 60초
	30일: 30*24*60*60 (일*시*분*초) -->
	<% Cookie co = new Cookie("bit","hong");
	co.setMaxAge(60);
	response.addCookie(co);
	%>
</body>
</html>
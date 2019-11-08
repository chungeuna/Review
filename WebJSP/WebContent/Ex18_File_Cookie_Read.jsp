<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>파일 쿠키 read</h3>
<% //클라이언트 브라우저가 가지고 있는 (내 도메인)을 가지고 온다 
//클라이언트 정보는 request에 담긴다 
//쿠키 타입의 객체 배열 
Cookie[] cs = request.getCookies();
if(cs != null || cs.length > 0){  //실제로 쿠키를 얻어온 것 
	for(Cookie c : cs){
		out.print(c.getName() +"<br>");
		out.print(c.getValue() +"<br>");
		out.print(c.getMaxAge() +"<br>");
	}
}
%>

</body>
</html>
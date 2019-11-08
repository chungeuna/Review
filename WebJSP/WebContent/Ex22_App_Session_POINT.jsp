<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- TODAY POINT
서버의 자원(WAS ... 메모리) 활용

application : session 
변수 [전역자원]    변수[개인에게 부여 : 접속한 브라우저마다 : 세션 아이디마다]
				(접속한 사용자에게 부여되는 고유한 변수) 
사이트 접속 : 전체 접속자 수 [10000명]
application.setAttribute("count",0); >> 카운트라는 전역변수가 만들어짐 
사이트에 접속하는 모든 세션(사용자)가 접근할 수 있다 

[session]
session.setAttribute("userid","kglim");
접속한 사용자마다 고유하게 부여되는 변수 

A라는 사용자가 웹 서버 접속 
서버 session 객체 생성 > 식별값(A001) > 클라이언트 브라우저(response) 
A001 >> session.setAttribute("userid","")

B라는 사용자가 웹 서버 접속 
서버 session 객체 생성 > 식별값(B001) > 클라이언트 브라우저(response) 
B001 >> session.setAttribute("userid","")

 -->
 
<h3>세션 정보</h3>
웹 서버가 부여한 고유값 : <%= session.getId() %>
<% String userid = request.getParameter("userid");
session.setAttribute("id", userid); //id라는 세션 변수 생성 
//접속한 클라이언트의 아이디를 담겠다 


%>
<h3>세션 변수값</h3>
<% String id = (String)session.getAttribute("id"); //오브젝트 타입이라 
out.print("당신의 아이디는 <b>" + id + "</b>");

%>
</body>
</html>
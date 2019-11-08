<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
정보(데이터)

클라이언트( 로컬 pc 웹 브라우저 )   : 서버 (웹 톰캣 or DB서버) 

정보(데이터 자료)>> 어디에 저장하는 것이 좋을까 (보관) 
고민: 보안요소(정보의 중요성), 소멸(일시적,영속적)

클라이언트(로컬 pc, 웹 브라우저)
1. 쿠키 (메모리 쿠키, 파일 쿠키) 
2. 로컬스토리지: 웹 브라우저 메모리 

server(WebSever : Tomcat)
1. 세션 객체: 서버의 메모리 > 접속한 사용자 식별, 접속시간 관리, > 서버가 꺼지면 날라간다 > 임시적인 저장공간 
2. 어플리케이션 객체: 서버 메모리 : 접속한 모든 사용자가 사용가능한 공유 객체 (공유 메모리) > 서버꺼지면 날라간다,임시적인 저장공간 
3. 서버: 파일(txt) , DB ... 
4. DB 서버 영속적 

 -->
 <% Cookie mycookie = new Cookie("cname","1000");
 //만든 쿠키를 클라이언트에게 전달해야한다 response 
 //response > 페이지의 이동, 표현식 
 //
response.addCookie(mycookie);
 %>
 서버에서 설정한 쿠키이름 <%= mycookie.getName() %>
 서버에서 설정한 값 <%= mycookie.getValue() %>
 서버 설정한 쿠키 소멸설정 (-1, 소멸시간이 없다:session)<%=mycookie.getMaxAge() %>
</body>
</html>
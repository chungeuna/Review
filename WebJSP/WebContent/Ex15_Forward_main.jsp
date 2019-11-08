<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
/* 요청에 대한 흐름제어 
include 
forward 

공통점: 리퀘스트 객체 공유
차이점: include: 제어권을 가지고 있다 
forward: 주체가 없다 제어권을 넘겨준다 

point****요청 주소는 동일한데 다른 페이지의 내용을 서비스한다 **********
왜? 처음 요청했던 주소 >> 그 주소의 버퍼를 그대로 사용 
login.jsp a.jsp 
포워드가 됐다면 제어권을 a.jsp한테 넘겨준다 
그릇은 넘겨주지 않음  >> 담는 그릇은 login.jsp꺼 
그릇에 담기는 내용은 a.jsp꺼, b.jsp, c.jsp가 될수도 있다 
*/
    
    
 String code = request.getParameter("code");
 String viewURI = null;
 if(code.equals("A")){
	 viewURI = "/forward/a.jsp";
 }else if (code.equals("B")){
	 viewURI = "/forward/b.jsp";
 }else if (code.equals("C")){
	 viewURI = "/forward/c.jsp";
 }
	 //요청이 들어오면 주소는 같은데 보여지는 내용은 다르다 
	 
	 //include >> 디자인할 때 쓴다
	 //forward된 페이지내용을 내가 가진 버퍼에 넣는다 
	 //어쩔 때는 a,b,c 도
	 //forward는 로직제어할 때 사용 
	 //그 상품이 있다면 어떤 화면을 보내고 ,...
	 
    %>
    <jsp:forward page="<%=viewURI %>"></jsp:forward>
    <!-- 아래코드 실행여부는  >> 실행되지 않는다 버퍼를 비워버리기 때문에-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
나는 forward 페이지 입니다 
</body>
</html>
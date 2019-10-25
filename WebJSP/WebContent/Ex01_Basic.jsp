<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  //스크립트 릿(java code 작성 영역)
    Date day = new Date();
	/* JSP 페이지 : ui는 html + css + javascript 코드로 만든다 
	      서버 코드 (jdbc) >> 자바 코드 
		>> ui(html +css+js) + java 코드 
	자바코드 <% 퍼센트>안에서만 규현 
	디자인 + 서버 로직 코드 결합 
	>> 목적 : 서블릿으로 자바코드 만들고 jsp로 ui만들기~~~~~~~~
	좋은 방식은 아님 
	>> 서블릿 >> 자바로 웹을 구현하는 페이지 
	ui >>  jsp 
	
	> 정해진 방법론 > mvc 모델 뷰 콘트롤러 
	> 모델>> 자바가 컨트롤러 >> 서블릿  뷰  >> jsp 
	
	잘하는 것만 해 >> model2 기반의 mvc 패턴
	
	>> jsp와 html의 차이점 
	>> 아파치 톰캣 서버가 >>> was (웹 어플리케이션 서버/서비스)
	>> 웹을 서비스하려고 그러지!!!! 웹 서버를 만든 이유 >> 내가 만든 자원을 공유하려고 >> 다른 사람 접속 허용해야지
	1.html로만 구성한다  >> 그러면 
	2. vs. jsp로 구성한다 
	컴파일 된 코드 확인하기 
	
	192.168.03/WebJSP/Ex01_/basic.jsp 요청 보내면 
	C:\SmartWeb\Web\WebJSP\JSPLab\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\WebJSP\org\apache\jsp
	
	jsp 구성 요소
	1. 선언부 (JSP  페이지 기본 설정 세팅) 
		ex) page 지시자 >> 사용 언어, 인코딩, import  자원 ....
	2. 스크립트 요소
	2.1 스크립트 릿 <% 안  자바 코드를 구현 > 
	2.2 표현식(출력방법):  response 응답하다 (출력대상 : client 웹 브라우저)  <% = 
	= 화면에 출력하겠다..... 
	2.3 선언부 (공통적인 자원(scope page) : 공통 함수) <%!
	

	*/
%> 
  <%!   //java 코드 (공통함수)
  public int add(int i,int j){
	  return i + j;
  }
  %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 String str ="hong";

%>

<%= str %><br>
<%= day %>
<%	int result = add(100,200);

%>
<hr> 
당신이 호출한 add 함수 결과는 : <%= result %>
</body>
</html>
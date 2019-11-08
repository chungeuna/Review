<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    /* WAS: [여러개의 어플리케이션]을 서비스할 수 있다 
      WAS안에 webJSP 웹 프로젝트(어플리케이션)을 가지고 있다 
      
      http://localhost:8090/WebJSP/Ex10_Application.jsp
   	  http://localhost:8090/WebJSP2/default.jsp
   	  > WebJSP,WebJSP2 >> 어플리케이션 이름, 가상 디렉토리, 프로젝트이름 
          실경로: c:/SmartWeb/WebJSP/JSPLab/ .... 
   	  가상의 경로
   	 어플리케이션이 가지는 디폴트 경로 >> 디폴트 서비스 경로 > 실서비스 경로: webContent (****컨텍스트 루트****)
   	 
   	 http://localhost:8090/WebJSP 
   	 WebContent가 서비스하는 경로
   	 
   	 우리가 만든 소스 파일은 (html,htm,jsp,js,css ...)
   	WebContent 안에 있어야한다 
   	WebContent 안에 있는 모든 페이지(JSP)가 공유할 수 있는 자원은 없을까?
   			
   	 저는 어떤 자원을 a.jsp에도 사용하고싶고 b.jsp에도 사용하고싶다(마치 static처럼...)
   	 >> 방법 :
   		 
   		 웹어플리케이션은 하나의 설정파일을 갖는다 (웹 전체에 대한 설정 정보를 가질 수 있다)
   		 >>********* web.xml 웹 어플리케이션의 전체적인 설정 정보를 관리한다 
   		 >> 가장 먼저 실행되는 자원이다 
   		 >>WebContent > WEB-INF > web.xml
   		 
   		 WEB-INF : 보안 폴더  >> 클라이언트가 접속할 수 없는 폴더 >> 주소접근(404)
   		 
   		WEB-INF>>views 폴더 >> member 폴더 >> login.jsp 생성 >> 우회적인 접근은 가능하다 (나중에) forward 
   		
   		application 객체 처리 (web.xml 자원 ...)
   		 
    */
    int sum = 0; //범수의 유효범위는? >> 페이지 생성되면 같이 만들어졌다가 페이지끝나면 소멸됨 
 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String param = application.getInitParameter("email");
out.print("<h3>" + param + "</h3>");

String param2 = application.getInitParameter("filePath");
out.print("<h3>" + param2 + "</h3>");
//어플리케이션 >> 어플리케이션 자원 전체가 처리할 수 있는 기능을 가지고있다
//init > web.xml 디폴트로 잡는다 
//모든 jsp에서 쓸 수 있다 
%>
</body>
</html>
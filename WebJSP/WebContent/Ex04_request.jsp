<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <% // 1. 한글처리
  	request.setCharacterEncoding("UTF-8");
   String id = request.getParameter("id");
   
   //jdk가 아닌 아파치 톰캣이 가지고 있는 내장 객체 
   //jsp파일에서 >> 디폴트로 톰캣이 가지고 있는 내장객체를 선언없이 사용가능하다
   //내장 객체의 대표적인 것 >> ***request **** 요청 객체 
   //요청 페이지당 한개의 request라는 객체가 생성된다 
   //request: 클라이언트가 가지는 정보를 서버로 보낼 수 있다 /request 객체에 숨겨서
   //리퀘스트 >> 클라이언트 정보가 담겨져있다 
   //버전 정보, value... 
   //리퀘스트 내장 객체는 클라이언트에서 서버로 요청할 때 
   //클라이언트에서 서버로 요청할 때 생성되는 HttpServletRequest라는 타입을 갖는 객체가 자동 생성이되고
   //그 주소를 참조하는 것이 request라는 객체 
   
   //http://localhost:8090/WebJSP/Ex04_request.jsp
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
id: <%= id %>
<hr>
접속한 클라이언트 아이피:  <%= request.getRemoteAddr() %> <br>
<!--서버에 접속한 클라이언트 아이피  -->
서버(요청한 방식) : <%=request.getMethod() %><br> <!--   --> 
포트 : <%= request.getServerPort() %> <br>
context root(홈 디렉토리, 가상 디렉토리, 웹 경로): <%= request.getContextPath() %> <br>
URI : <%= request.getRequestURI() %><br>  <!-- /WebJSP/Ex04_request.jsp  가상디렉토리 주소부터
요청한 디렉토리 주소까지 뽑아낸다  -->
<!-- 
http://localhost:8090/WebJSP/Ex04_request.jsp >> 웹에선 본 경로 (가상 경로) > contextPath >> 홈디렉토리 

http://localhost:8090/WebJSP/ 가지는 서비스 경로 (default)
webcontent 폴더를 의미한다 
webJSP/WebContent/Ex04 ~~이라고 써야한다 
>>webcontent 디폴트 경로 
webJSP/imgs/1.jpg 
>>웹 컨텐츠 밑을 기준으로 보면 된다 



 -->
</body>
</html>
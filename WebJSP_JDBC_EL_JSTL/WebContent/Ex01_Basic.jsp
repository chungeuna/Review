<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% //login.html  -> submit -> Ex01_Basic.jsp (요청받는 페이지)
 String id = request.getParameter("userid");
 //include 또는 forward 된 페이지에서만 사용하겠다  
request.setAttribute("name", "korea");
session.setAttribute("user", "bit");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- EL 언어 >> 표현식 : jsp 페이지에서 사용하는 스크립트 언어 
EL : 화면 출력을 담당 
이유: 스파게티 코드 (%와 html 혼재되는 코드) : 유지보수, 코드 해석 어렵다 
문제를 개선하기 위해서 script기반의 EL& JSTL 생성 (JSP 페이지에서만 사용가능)
EL: JSP 페이지에서 화면 출력 목적인데 , 스크립트릿 (%)없이 서버쪽 자원을 화면에 출력할 수 있다 
EL이 가지는 기본 객체가 있다 >> 
paramValues : 요청 파라미터의 <파라미터 이름,값배열> 매핑을 저장하는 Map 객체로 표현  
param		: 요청 파라미터를  <파라미터 이름,값> 매핑을 저장하는 Map 객체
requestScope: request 기본 객체에 저장된 속성의 <속성,값> 매핑을 저장한 Map 객체 
sessionScope: session 기본 객체에 저장된 속성의 <속성,값> 매핑을 저장한 Map 객체 
applicationScope: application 기본 객체에 저장된 속성의 <속성,값> 매핑을 저장한 Map 객체 
 -->
스크립트릿:  <b><%=id %></b>
스크립트릿: <%=request.getParameter("name") %>
 <hr>
EL request value : ${requestScope.name} <br>  
EL request value: (생략 가능: requestScope) ${name} <br>
되도록 request 써주는게 좋다 session값인지 request값인지 헷갈린다 <br>

세션 객체 <br>
스크립트릿: <%= session.getAttribute("user") %><br>

EL request value : ${user} <br>  
<hr>
기존 방식  : <%= id %> <br>
<%= request.getParameter("userid") %><br>

EL request parameter : ${param.userid} 
<h3>기본문법</h3>
<b>EL 표현식 <b> <br>
스크립트 릿 <%= 200+400 %> <br> 
EL: ${200+300} <br>

EL:${1+"1"} >> 문자형 숫자에 대해 자동 형변환한다 <br>
EL : ${1 == 1} >> 논린연산도 제공 <br>
EL: ${!true }<br>
EL: ${empty x } >> x라는 값이 비어있니 <br>
<!-- EL: ${null +1 } >> null값을 0으로 변환시켰다가 변환한다  <br> -->

</body>
</html>
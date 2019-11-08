<%@page import="java.util.HashMap"%>
<%@page import="kr.or.bit.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Emp e = new Emp();
e.setEmpno(200);
e.setEname("bituser");

HashMap<String,String> hp = new HashMap<>();
hp.put("data", "1004");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
기존 방식 : <%= e %> <br>
기존 방식 : <%= e.getEmpno() %> <br>
기존방식: <%= e.getEname() %> <br>

<h3>EL(출력)</h3>
자바 객체 출력하기(객체에 대한 직접적인 접근을 허락하지 않는다): ${e} <br>
자바 객체 가지는 속성값 출력하기 : ${e.getEmpno()}  <br>

1.JSTL (Core) : 변수 생성, 제어문 <br>
<c:set var = "m" value="<%=e %>"/> 
JSTL을 사용해서 변수 m을 생성()을 생성 (e 객체의 주소값) : ${m} <br>
<hr>
EL 출력: JSTL 변수값을 출력 : ${m} <br>
EL 출력: JSTL 변수(가능: 잘 안쓴다 ): ${ m.getEmpno() } <br>
EL 출력: JSTL 변수(자동으로 getter함수 호출/ getter,setter)(member field 명): ${ m.empno } <br>
EL 출력: JSTL 변수(자동으로 getter함수 호출/ getter,setter)(member field 명): ${ m.ename } <br>

EL과 JSTL : EL을 통해서 자바 객체에 대한 직접 접근을 불가능하다 <br>
>> 그래서 JSTL의 변수를 사용함 c:set 구문 사용 <br>
request나 session 객체에 담긴 변수는 접근 가능 <br>
JSTL의 변수의 value값으로 EL 표현식을 사용할 수 있다 <br>
<c:set var= "username" value="${m.empno}"/>
변수값 출력 : ${ username }<br>
<hr>
<h3>JSTL 변수 만들고 scope 정의하기</h3>
<c:set var="job" value="농구선수" scope="request"/>
당신의 직업은 ${job} <br>
만약 당신이 [include],[forward]한 페이지가 있다면 그 페이지에서 job을 사용할 수 있다  <br>
<c:set var="job2" value="야구선수" scope="request"/>
값 출력 : ${job2}<br>
<c:remove var="job2"/>
값 삭제 :  ${job2} >> 에러나지 않는다 출력이 안될 뿐 <br>
<c:set var ="vhp" value="<%=hp %>"/>
해쉬맵 객체 : ${vhp}  >> toString 오버라이드 되어있어서 찍힌다 <br>
해쉬맵 키값 : ${vhp.data} >> 밸류값 리턴<br>
<!--  hp.put("color","red) 

값을 넣기 >> 하지만 거의 쓰지 않는다 >> 출력하는 것이 목적이기때문에 
 -->
 <c:set target="${vhp}" property="color" value="red"/>
 
 hp 객체 : ${vhp} <br>
</body>
</html>
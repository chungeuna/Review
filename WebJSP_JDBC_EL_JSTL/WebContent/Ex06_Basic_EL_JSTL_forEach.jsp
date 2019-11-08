<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.bit.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h3>JSTL for문</h3>
	<!--JAVA  
		for(int i = 0; i<10; i++){} 
		 for(String s : list) {}
		 
	 -->
	 <c:forEach var="i" begin="1" end="10">
	 	<c:set var="sum" value="${sum +i }"></c:set> 
	 </c:forEach>
	 sum 누적값:	${sum}<br>
	 
	 <h3>구구단 5단 출력하기 </h3>
	 <ul>
	 <c:forEach var="i" begin="1" end="9">
	 	<li>5 *${i}=${5*i}</li>
	 </c:forEach>
	 </ul>
	 <h3>EL & JSTL 사용해서 2~9단까지 출력하세요</h3>
	 <table border="1">
	 <c:forEach var="i" begin="2" end="9">
	 	<c:forEach var="j" begin="0" end="9">
	 		<c:choose>
	 			<c:when test="${j == 0 }">
	 				<tr bgcolor="yellow"><th>${i}단</th></tr>
	 			</c:when>
	 			<c:otherwise>
	 			<tr><td>${i} * ${j} = ${i*j}</td></tr>
	 			</c:otherwise>
	 		</c:choose>		
	 	</c:forEach>
	 </c:forEach>
	 </table>
	 
	 <h3>JSTL forEach 객체 출력하기</h3>
	 <% int[] arr = new int[]{10,20,30,40};
	 	for(int i : arr){
	 		out.print("출력값:" + i + "<br>");
	 	}
	 %>
	 <h3>*****[EL JAVA 객체에 직접 접근 불가], JSTL 변수를 사용 데이터에 담은 후에 EL *****</h3>
	 arr 배열[객체] 접근 불가: ${arr}  >> 안나온다 <br>
	 <c:set var="intarr" value="<%= arr%>"/>
	 c:set 변수에 접근: ${intarr}  >> 주소값 출력된다<br> 
	 <hr>
	 <h3>JAVA에서의 개선된 for문 (items)</h3>
	 <c:forEach var="i" items="${intarr}">
	 	개선된 for문 배열값: ${i}
	 	<!--  for(String s : list) {}   == items  >> intarr-->
	 </c:forEach>
	 
	 
	 <h3>단순하게 ... 한번에 넣자! 많이 쓰는 방법</h3>
	 <c:forEach var="i" items="<%= arr %>">
	 	배열값2:${i} <br>
	 </c:forEach>
	 <h3> 재미삼아서</h3>
	 <c:forEach var="i" items="<%= new int[]{1,2,3,4,5} %>">
	 	배열값3: ${i } <br>
	 </c:forEach>
	 
	 <h3>forEach 활용하기2</h3>
	 	<c:forEach var ="i" items="${intarr }" varStatus="status"> 
	 		index : ${status.index } &nbsp; &nbsp;
	 		count : ${status.count } &nbsp; &nbsp;
	 		value : ${i} <br>
	 		
	 	</c:forEach>
	 	<h3>TODAY POINT (JSTL forEach 활용)</h3>
	 	<% List<Emp> emplist = new ArrayList<>();
	 	   emplist.add(new Emp(1000,"A")); //게시판을 갖고와서 배열에 놓는 거랑 똑같은 거
	 	   emplist.add(new Emp(2000,"B"));
	 	   emplist.add(new Emp(3000,"C"));
	 	   //아래코드는 EL & JSTL 
	 	   for(Emp e : emplist){
	 		   out.print(e.getEmpno() + "/" + e.getEname());
	 	   }
	 	%>
	 	<hr>
	 	<c:set var="list" value="<%= emplist %>"/>
	 	<table border="1">
	 		<tr><td>사번</td><td>이름</td></tr>
	 		<c:forEach var="emp" items="${list}">
	 			<tr><td> ${emp.empno} </td><td> ${emp.ename}</td></tr>
	 		</c:forEach>
	 	</table>
<!-- EL 출력: JSTL 변수(자동으로 getter함수 호출/ getter,setter)(member field 명): ${ m.empno } <br> --> 	

	 	<table border="1">
	 		<tr><td>사번</td><td>이름</td></tr>
	 		<c:forEach var="emp" items="<%= emplist %>">
	 			<tr><td> ${emp.empno} </td><td> ${emp.ename}</td></tr>
	 		</c:forEach>
	 	</table>
	 	
	 	<h3> JSTL 사용 Map 다루기</h3>
	 	<% Map<String,Object> hm = new HashMap<>();
	 		hm.put("name","hong");
	 		hm.put("pwd","1004");
	 		hm.put("date",new Date());	
	 	%>
	 	<h3>Java Map EL & JSTL 출력하기</h3>
	 	<c:set var="hm" value="<%=hm %>"/>
	 	<c:forEach var="obj" items="${hm}">
	 		${obj.key } -> ${obj.value } <br>
	 	</c:forEach>
	 	(key)name: ${hm.name} <br>
	 	
	 	<h3> JSTL 구분자 처리 </h3>
	 	<c:forTokens var ="token" items="A.B.C.D" delims=".">
	 		${token}<br>
	 	</c:forTokens> 
	 	
	 	<h3> JSTL 복합 구분자 처리 </h3>
	 	<c:forTokens var ="token" items="A.B/C-D" delims="./-">
	 		${token}<br>
	 	</c:forTokens> 	 	
	 	
	 	<c:set var="nowNum" value="10"/>
	 	<c:forEach var="i" begin="0" end="${nowNum }">
	 		
	 	</c:forEach>
</body>
</html>
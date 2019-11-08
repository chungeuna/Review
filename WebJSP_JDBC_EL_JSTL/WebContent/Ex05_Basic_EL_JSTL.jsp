<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<% /*<c:set : 변수생성, 값을 저장, 자바 객체 변수 value=<% 객체
<c:remove : 변수 삭제 
<c: if : 조건문 (test="조건절")
<c: choose : 여러가지 조건에 따라서 처리 가능 (if 보다 활용도 높다)>
<c:forEach: 반복문 (for문)>
<c:forTokens : 토큰값 (split과 for문 결합)
<c:out : 표현식과 같다 JSTL 출력구문 >> 이것보다 EL이 더 선호된다 사용빈도 높다
<c:catch : 예외처리 블록 	
*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>EL로 파라미터 받기 </h3>
${param.id} - ${param.pwd} <br>
<h3>EL 파라미터 값을 변수에 저장하기</h3>
<c:set var="userid" value="${param.id }"/>
<c:set var="userpwd" value="${param.pwd }"/>

<h3>JSTL 변수값 출력하기</h3>
id : ${userid } <br>
pwd: ${userpwd } <br>

<hr>
	<c:if test="${!empty userpwd}">
		<h3>not empty userpwd</h3>
		<c:if test="${userpwd == '1004'}">
			<h3>welcome admin page</h3>
		</c:if>
	</c:if>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core Lib ETC</title>
</head>
<body>
	<h3>out 출력(EL)</h3>
	<c:out value="<p>태그는 문단 태그입니다</p>"/> >> c:out은 문자로 출력한다  <br>
	&lt;p&gt;태그는 문단 태그입니다&lt;/p&gt;
	<hr>
	<!-- JSTL의 예외처리 -->
	<c:catch var="msg">
		name : <%= request.getParameter("name") %>
		<% if(request.getParameter("name").equals("hong")){
		out.print("당신의 이름은 : " + request.getParameter("name"));
		}
			
			%>
	</c:catch>
	<c:if test= "${msg != null }"> <!--  예외 발생했다면 -->
		 <h3>예외발생</h3>
		 오류메시지 : ${msg} <br>
	</c:if>
</body>
</html>
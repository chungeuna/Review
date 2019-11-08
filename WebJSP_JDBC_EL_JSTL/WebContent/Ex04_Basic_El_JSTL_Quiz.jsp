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
<% String id = request.getParameter("ID");
if(id.equals("hong")){
	
}
%> 
<%= id %> <img alt="이미지" src="/images/1.png" style="width:100px;height:100px;"> 


<% 

%>
<hr>
<h3>EL과 JSTL 사용하기 </h3>
${param.ID} <br>
<c:if test="${param.ID == 'hong'}">  <!-- 표현식 안에다가 비교조건도 넣어야한다 -->
	${param.ID} <img alt="이미지" src="/images/1.png" style="width:100px;height:100px;"> 
</c:if>
<h3>JSTL if문</h3>
	<c:if test="${param.age > 20}" var= "result"> <!--  result : 결과값이 들어간다  -->
		param.value : ${param.age }
	</c:if>
	if 구문에서 만들었던 var 변수값은 : ${result}<br>

</body>
</html>
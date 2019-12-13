<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@  taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="member">
		<form:errors element="div" />
		<label for="email">이메일</label>:
<input type="text" name="email" id="email" value="${member.email}">
		<form:errors path="email" /><br>

		<label for="password">암호</label>:
<input type="password" name="password" id="password">
		<form:errors path="password" /><br>

		<input type="submit" value="로그인">
	</form:form>

</body>
</html>
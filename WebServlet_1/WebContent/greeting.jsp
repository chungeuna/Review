<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>FrontServletController에 의해서 forward된 페이지 </h3>
기존: <%= request.getParameter("msg") %> <br>
EL &JSTL : ${requestScope.msg }

</body>
</html>
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
<c:set var="memolist" value="${requestScope.memolist}"/>
<table border="1">

<c:forEach var="memo" items="${memolist}">
<tr>
 <td>${memo.id } </td>
 <td>${memo.email } </td>
 <td>${memo.content } </td>
 </tr>
</c:forEach>

</table>
<a href="memo.html"> 글쓰기 </a>
</body>
</html>
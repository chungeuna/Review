<%@page import="sun.security.jca.GetInstance"%>
<%@page import="java.util.Calendar"%>
<%@ page import="kr.or.bit.Emp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Emp e = new Emp();
e.setEmpno(1000);
e.setEname("홍길동");

Calendar cal = Calendar.getInstance();
int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH) +1;
int date = cal.get(Calendar.DATE);


//표현식 사용해서 클라이언트 웹브라우저로 보낸다    
%>
사번 : <%= e.getEmpno() %> <br>
이름: <%= e.getEname() %><br>
전체: <%= e.toString() %><br>
<hr>
현재날짜 <%= year %> 년 <%= month %> 월 <%= date %> 일
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
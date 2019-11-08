<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="javafx.scene.chart.PieChart.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
session : 브라우저(접속한 사용자)마다 서버에서 부여하는 고유한 객체 

session 값: 웹서버가 접속한 클라이언트 (브라우저에게 부여하는 고유한 아이디값) 식별값 

A라는 사용자가 웹서버에 접속 > session객체 생성> 고유 아이디 값 만들고 > id값을 클라이언트에게 전달 (response) 
자동으로 이루어진다 

아이디값 >>
동기화 작업 (로그인,로그아웃,정보)
처음 접속한 시간 
마지막 접속한 시간 

 -->
 <% Date time = new Date();
 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
 %>
 <h3>세션정보 </h3>
 session 객체의 식별값:  <%= session.getId() %>
 <hr>
 <% time.setTime(session.getCreationTime());
 
 %>
 [session 생성된 시간] : <%= formatter.format(time) %>
 <hr>
 <%
 time.setTime(session.getLastAccessedTime());
 %>
  [session 마지막 접속시간] : <%= formatter.format(time) %>
  
</body>
</html>
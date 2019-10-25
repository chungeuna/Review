<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); 
    /*    userId , userPass , userPassCheck , userEmail , userPhone
    , userSsn1 , userSsn2 , userZipCode , userPhone
    
    */
    String id = request.getParameter("userId");
    String name = request.getParameter("userName");
    String pwd = request.getParameter("userPass");
    String gender =request.getParameter("gender");
    String email =request.getParameter("userEmail");
    String ssn1 =request.getParameter("userSsn1");
    String ssn2 =request.getParameter("userSsn2");
    String zipcode =request.getParameter("userZipCode");
    String addr1 =request.getParameter("userAddr1");
    String addr2 =request.getParameter("userAddr2");
    String phone =request.getParameter("userPhone");
   String[] hobbys = request.getParameterValues("hobby");
    String year = request.getParameter("year");
    String month = request.getParameter("month");
    String day = request.getParameter("day");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : <%= id %> <br>
이름 : <%= name %> <br>
비밀번호 : <%= pwd %> <br>
성별 : <%= gender %><br>
이메일 : <%= email %><br>
주민번호: <%=ssn1 %> - <%=ssn2%><br>
우편번호: <%= zipcode %><br>
주소1: <%= addr1 %><br>
주소2: <%= addr2 %><br>
핸드폰 번호: <%= phone %><br>
<%  
 	String data = "";
if(request.getParameterValues("hobby")!=null){
 	for(String str : hobbys){
		 data += str;
 %> 
 hobby: <%= str %><br>
 <%
 	}}else{%>
 취미:<%="" %>
 <% 	}%>
 
<br>
생년월일 : <%= year %>년 <%= month %>월  <%= day %> 일
</body>
</html>
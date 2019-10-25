<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% //자바코드가 들어가는 영역 
       //목적지주소 // 회원가입 시 입력한 데이터를 받아서 결과를 확인 
       //<input type="text" name="userid"
    String userid =  request.getParameter("userid");
    String username = request.getParameter("username");
    
    //jdbc
    //db 연결 insert into ... ?? 실행 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
 <h3>당신이 입력한 데이터 </h3>
 ID : <%= userid %> <br>
 NAME : <%= username %> <br>
</body>
</html>
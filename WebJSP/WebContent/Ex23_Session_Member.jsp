<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String memberid = (String)session.getAttribute("memberid"); //여기서도 session 사용할 수 있다 //사용자가 로그인한 아이디를 어느 페이지에서나 이용할수 잇다
    boolean loginstate = (memberid == null)? false:true; 
    
    //memberid.equals("admin")
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전용 페이지</title>
</head>
<body>
 <% 
 	if(loginstate ==true){
 		out.print(memberid + "님 로그인 상태입니다<br>");
 		out.print("당신은 이 페이지를 볼 수 있습니다<br>");
 		out.print("<a href='Ex23_Session_Logout.jsp'>로그아웃</a>"); 
 	}else {
 		out.print("<script> alert('넌 누구냐');</script>");
 		out.print("<script> location.href= 'Ex23_Session_Login.jsp';</script>"); 
 	}

 %>
</body>
</html>
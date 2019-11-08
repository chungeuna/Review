<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8");
    //한글처리 
    
    //데이터 받기 
    String uid = request.getParameter("uid");
    String pwd = request.getParameter("pwd");
    
    
    //확인하기
  //  out.print(uid+"/" + pwd);
    
    //로직 업무 처리
    //디비 연결해서 >>회원테이블에서 아이디가 있는지 체크>> pwd 체크>> 
    //id와 pwd가 같으면 회원으로 본다 (가정)
    boolean success = false;
    if(uid.equals(pwd)){
    	//로그인 성공으로 본다
    	//session 변수에 id값을 담아 넣을 것 
    	//**********session변수의 scope >> 모든페이지 >> 어디서든 
    	session.setAttribute("memberid", uid);
    	success = true;
    }
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(success == true){
	out.print("<b>로그인 성공 </b><br>");
	String user = (String)session.getAttribute("memberid");
	out.print(user + "님 로그인 되었습니다<br>");
	out.print("<a href='Ex23_Session_Member.jsp'>회원접속</a>");
}else { //로그인 실패 
	%>
	<script type="text/javascript">
		alert('다시 로그인해주세요');
		window.history.go(-1); //location.href = 'Ex23'  
		//바로 전 페이지로 이동 >> 로그인 페이지로 이동 
	</script>
	<% 
}


%>
</body>
</html>
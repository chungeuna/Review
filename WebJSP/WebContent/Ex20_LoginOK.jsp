<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- id, pwd, checkbox여부를 받아서 처리  
1. id와 pwd가 같다면 로그인 성공 if(id.equals(pwd)... 
chk값이 체크되어있다면 쿠키를 생성해서 사용자의 아이디값을 쿠키에 담으세요 유효타임 24시간 
> 쿠키 쓰기 완료 
2. id와 pwd 같다면 로그인 성공 
chk값이 체크되어있지 않다면 기존에 생성했던 쿠키를 삭제 > maxage(0)
3. id와 pwd가 같지 않다면 response.sendRedirect (다시 로그인해라) 
사용자가 강제로 서버로부터 로그인 페이지를 또 받도록 하게 한다 

-->
<% request.setCharacterEncoding("UTF-8"); 
String id = request.getParameter("uid");
String pwd = request.getParameter("pwd");
String chk=null;
chk = request.getParameter("chk");

//out.print(id+"/" + pwd + "/" + chk);
if(id.equals(pwd)){ // 로그인 성공
	if(chk != null){
		if(chk.equals("on")){  //쿠키 생성
			Cookie co = new Cookie("UID",id);
			co.setMaxAge(24*60*60);
			response.addCookie(co);
		}
	}else { //쿠키 삭제 
		Cookie delco = new Cookie("UID",id);
		delco.setMaxAge(0); //소멸
		response.addCookie(delco);
	}
	//*************
	out.print("<script>location.href='Ex19_Login.jsp'</script>"); //두개의 결과는 같은 것이다 
	//1.스크립트로 표현하기  2. response.sendRedirect 이용하기 
}else { //로그인 실패 
	response.sendRedirect("Ex19_Login.jsp"); //서버에게 이 페이지를 주세요
	
}
%>

</body>
</html>
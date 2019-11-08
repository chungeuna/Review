<%@page import="kr.or.bit.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- was가 제공하는 객체 
1. request (요청: 클라이언트 정보)
2. response(응답: 특정 페이지로 이동, 정보 출력, 쿠키를 쓰거나...) 
3. application(전역객체, web.xml 파일 자원처리, 전역 변수) 
4. session(접속사용자마다 부여되는 고유한 객체,변수) 
5. out(print) 

session 객체 
[session 변수 생성]
scope : (현재 웹 프로젝트: WebContent)모든 페이지에서 사용가능하다 
a.jsp (session.setAttribu...) -> b.jsp(session.getAtt...) 
Life-cycle:  sessionid와 같다 / 서버 리부팅 / session.invalidate 

application 객체 
[application 변수: 전역]
모든 세션이 공유할 수 있다 
scope: 모든 사용자가 모든 페이지에서 제어 가능하다  (굳이 비교하자면 static과 비슷) 
Life-cycle: 서버 리부팅 

request 객체 
[request 변수]: request.setAttribute("type","A");
*****scope: 요청 페이지 당 하나/ 요청 페이지(login.jsp >> request 객체 ... page scope)
*****예외적으로 include, forward는 request객체를 공유한다  


 -->
 <% Emp emp = new Emp();
 emp.setEmpno(2000);
 emp.setEname("홍길동");
 
 session.setAttribute("empobj", emp); //타입 오브젝트니깐 emp도 들어간다
 
Emp e = (Emp) session.getAttribute("empobj");
out.print(e.getEmpno() + "<br>");
out.print(e.getEname() + "<br>");
 
request.setAttribute("who", "king"); //ex24 여기서만 사용할 수 있다 

String who = (String)request.getAttribute("who");
out.print("requset:" + who);
 %>

</body>
</html>
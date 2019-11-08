<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Response</title>
</head>
<body>
<!-- Client >> 서버에 요청한다 (리퀘스트)
서버 >> 클라이언트(리스폰스) 

톰캣(javax) : 안에 리스폰스,리퀘스트 객체가 들어있다
리스폰스: 출력,  >> 표현식 퍼센트 =
페이지 이동처리 >> sendReidrect 
자바스크립트 페이지 이동> location.href ="Ex01_Basic.jsp" >> 페이지를 서버에게 재요청하는것과 같다
*** 페이지 서버 재요청 주소창 엔터 ,f5 ****
자바코드 >> response객체가 갖고있는 sendRedirect 
response.sendRedirect("Ex01_Basic.jsp")=== location.href ="Ex01_Basic.jsp"
자바코드라 해석못하기때문에 was가 자바스크립트 코드로 바꿔서 화면에 내보낸다 
 -->
 1. 일반적인 사용(=출력) <%= 100+200 +300%>
 2. sendRedirect :특정페이지 요청을 강제 response 객체 함수 사용 클라이언트가 서버에 페이지를 재요청하게 하는 것 
 <%// response.sendRedirect("Ex01_Basic.jsp") ; //페이지에 대한 재요청
 %> 
 <script >
 location.href ="Ex01_Basic.jsp"; 
 //
 </script>
</body>
</html>
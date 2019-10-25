<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8");
    
    //1. request 객체 사용 클라이언트가 입력한 값을 갖고 오는 것 
    //input > text,password,radio,textarea,select 
    //넘어오는 값이 단일값이냐 ,,,, 다중값이냐,,,,
    //기본적으로 단일값 //input > checkbox, select (multiple)
    String userid = request.getParameter("userid");
    String userpwd = request.getParameter("pwd");
    
    String[] hobbys = request.getParameterValues("hobby");
    //input타입은 체크박스를 만들 때 네임이 hobby라고 해서 여러개 만든다 
    //<input >
    //hobby=a&hobby=b&hobby=c ..... >> 배열로 받는다 >> request객체 통해서 getParameterValues("hobby");
    
    for(String str : hobbys){
    	
    }
    request.getParameterNames();  //Enumeration<String> 열거 
    
    Enumeration <String> e = request.getParameterNames(); 
    String name = "";
    while(e.hasMoreElements()){
		name += "/" + e.nextElement();
	}
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
userid:<%= userid %> <br>
userpwd:<%=userpwd %><br>
<%
	for(String str : hobbys){
	%>
		<%= str %><br>
		<%
	}
%>
</body>
</html>
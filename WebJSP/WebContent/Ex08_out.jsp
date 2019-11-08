<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체(WAS 가지고 있는) :out </title>
</head>
<body>
	<% 	
	boolean b = true;
	if(10 > 5){
		%>
		if(true):<font color="red"><%=b %></font> 
		<% 	
		// 퍼센트 = 퍼센트 안에 못 쓴다 >> out 객체 
	} else {
		b = false; 
		%>
		if(false):<font color="blue"><%=b %></font> 
	<%
	} 
	%>
	<h3>out 객체(서버코드는 편하지만 ui 작업은 힘들다) </h3>
	<%
	//디자인 코드를 다 문자열로 묶기 때문에 오타 여부를 판단 힘든 
	boolean b2 = true;
	if(10>5){
		out.print("If(true):<font color='red'>" + b2 + "</font>");
	}else {
		out.print("If(true):<font color='blue'>" + b2 + "</font>");
	}
	
	%>
</body>
</html>
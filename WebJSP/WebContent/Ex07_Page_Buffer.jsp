<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page buffer="8kb" autoFlush="true" 
    %>
    <!-- -페이지에 어떤 설정도 하지않으면 디폴트가 8kb에 autoflsuh = true 
    페이지에 더 이상 실행할 자원이 없으면 자동으로  flush된다 
    
    -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
for(int i = 0 ; i <10;i++){
	out.print("<b>" + i + "</b><br>");
	//out.print 
	//8키로바이트가 안되도 실행된다 >> 자동 flush 
}

%>
</body>
</html>
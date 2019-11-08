<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tomcat Connection Pool</title>
</head>
<body>
<% 
Connection conn = null;
Context context = new InitialContext(); //현재 프로젝트에서 이름기반으로 검색을 할 것이다  
DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");  //java:comp/env/ + name //전체 자바 환경에서 이것을 찾겠다 

//pool 안에서 connection 가지고 오기 
conn = ds.getConnection();

out.print("db 연결여부 : " + conn.isClosed() + "<br>");

//POINT
//Pool에 커넥션 반환하기 
conn.close(); //반환하기 

out.print("db 연결여부 : " + conn.isClosed() + "<br>");

%>
</body>
</html>
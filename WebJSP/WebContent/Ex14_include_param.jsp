<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); 
    String type = request.getParameter("type");
    String userid = request.getParameter("userid");
  //  String type2 = request.getParameter("type2");
  //  out.print(type+"/" + userid +"/" + type2);
    //http://localhost:8090/WebJSP/Ex14_include_param.jsp?userid=hong&type=A&type2=B
    		
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>*******include(request 객체 공유)*******</h3>
	Main Page
	type: <%= type %> <br>
	userid: <%= userid %> <br>
	<hr>
	<jsp:include page="Ex14_subparam.jsp">
	</jsp:include>
	<hr>
	
</body>
</html>
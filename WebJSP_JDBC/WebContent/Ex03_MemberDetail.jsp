<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")){
	//강제로 페이지 이동 
	out.print("<script>location.href='Login.jsp'</script>");
	
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: solid 2px black;
	border-collapse: collapse;
}

tr {
	border: solid 1px blue;
	background-color: white;
	color: black;
}

td {
	border: solid 1px red;
}
</style>
</head>
<body>
	<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2">
				<jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px">
				<jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<!--  테이블 형식으로 출력 회원리스트 출력  -->
				<!--  목록은 테이블 형식  -->
				<% Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String id = request.getParameter("id");
				
				try {
					conn = Singleton_Helper.getConnection("oracle");
					String sql="select id, pwd,name,age,gender,email from koreamember where id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);  
					rs = pstmt.executeQuery(); 
					
					//rs : 내가 가져온 데이터 
				//3.select id,pwd,name,age,gender,email from koreamember where id=?
					
				%>
				
				<table style="width:400px;height:100px;margin-left:auto;margin-right: auto;">
				
				<% while(rs.next()){    //데이터를 한줄씩 읽어온다  %>
					<tr>	
						<th>아이디</th>
						<th>패스워드</th>
						<th>이름</th>
						<th>나이</th>
						<th>성별</th>
						<th>이메일</th>				
					</tr>
					<tr>	
						<td><%= rs.getString("id")%></td>
						<td><%= rs.getString("pwd")%></td>
						<td><%= rs.getString("name")%></td>
						<td><%= rs.getInt("age")%></td>
						<td><%= rs.getString("gender")%></td>
						<td><%= rs.getString("email")%></td>						
					</tr>
				</table>
				<% 
				}%>
				<%
			}catch(Exception e){
				
			}finally{
				Singleton_Helper.close(rs);
				Singleton_Helper.close(pstmt);
			}
			 %>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>
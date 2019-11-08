<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <% /* 1.권한검사
 	2. id값 받기
 	3. DB > delete from koreamember where id =?
 	4. 이동처리 : 삭제 완료시 목록 페이지로 이동 		
 
 */
 request.setCharacterEncoding("UTF-8");
 if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")){
 	//강제로 페이지 이동 
 	out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>"); 	
 }
 
 	Connection conn = null;
	PreparedStatement pstmt = null;
	String id = request.getParameter("id");
	
	try {
		conn = Singleton_Helper.getConnection("oracle");
		String sql="delete from koreamember where id =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		int row = pstmt.executeUpdate();
		if(row> 0) {
			out.print("<script>location.href='Ex03_Memberlist.jsp'</script>");
		} else {
			
		}
		
	}catch(Exception e){
		
	}finally{
		Singleton_Helper.close(pstmt);
	}
	
 %>
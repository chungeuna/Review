<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <% /* 회원가입 처리 페이지 (디자인 필요없다 )
    1. 한글처리 
    2. 데이터 받기(request)
    3. 데이터 확인하기
    4. 로직처리하기 (비지니스 로직)
    	회원가입 -> 데이터 받아서 -> DB연결하고  -> Insert -> 클라이언트에게 결과 전달 
   	Insert 성공 > 회원가입 성공 > 페이지 이동 > 로그인 화면 > 로그인 
   	이동 : (자바)response.sendRedirect(""), (자스)location.href  =
    >> 클라이언트가 서버에게 페이지 재요청하는 것 >> 서버에게 
   	
   	insert 실패 > 회원가입 페이지 이동 
   	>> <script> alert() </script>
   	
   	DB: 
   	id, pwd, name, age,gender, email, ip 
   	ip ... request 객체를 통해서 request.getRemoteAddr() 
   	
   	*/
    request.setCharacterEncoding("UTF-8");
   	String id = request.getParameter("id");
   	String pwd = request.getParameter("pwd");
   	String name = request.getParameter("mname");
   	int age = Integer.parseInt(request.getParameter("age"));   //int로 바꿔도 된다 
   	String gender = request.getParameter("gender");
   	String email = request.getParameter("email");
   	
   	out.print(id+"/" + pwd+"/"+name+"/"+age+"/"+gender+"/" +email);
   	out.print(request.getRemoteAddr());
   	

	Class.forName("oracle.jdbc.OracleDriver");
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
		
		String sql = "insert into KOREAMEMBER (id,pwd,name,age,gender,email,ip) values(?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, name);
		pstmt.setInt(4, age);
		pstmt.setString(5, gender);
		pstmt.setString(6, email);
		pstmt.setString(7, request.getRemoteAddr());
		
		int result = pstmt.executeUpdate();
		if(result != 0 ){
			out.print("<script>");
				out.print("location.href='Ex02_JDBC_Login.jsp'");
			out.print("</script>");
		} else {  //실행될 확률은 거의 없다 
			out.print("<script>");
			out.print("alert('가입실패');");
		out.print("</script>");
		}
		
	}catch(Exception e){
		// pstmt.executeUpdate(); 실행 시 pk 위반으로 예외 발생 
		out.print("<script>");
		out.print("alert('가입실패');");
		out.print("location.href='Ex02_JDBC_Login.jsp'");
		out.print("</script>");
	}finally{
		if(pstmt != null ){ try{} catch(Exception e){}}
		if(conn != null ){ try{} catch(Exception e){}}
	}

	
	
    %>
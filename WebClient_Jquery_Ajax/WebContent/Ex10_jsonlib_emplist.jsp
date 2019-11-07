<%@page import="net.sf.json.JSONArray"%>
<%@page import="kr.or.bit.Emp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>    
<%
	Class.forName("oracle.jdbc.OracleDriver");
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","bituser","1004");
	//out.print(conn.isClosed());
	
	stmt = conn.createStatement();
	String sql= "select empno ,ename , sal , job from emp";
	
	rs = stmt.executeQuery(sql);
	
	//여러건 데이터 (객체로 담아 놓고 싶어요 : collection)
	//객체 배열에 담을려면  DTO클래스(class Emp)
	List<Emp> list = new ArrayList<>();
	
	//while(rs.next()){rs.getInt("empno")}
	//if(rs.next()){}else{}
	//if(rs.next()){do{}while(rs.next())}

	//코드 처리
	while(rs.next()){ //14개 emp객체가 만들어짐 
		Emp emp = new Emp();
		emp.setEmpno(rs.getInt(1));
		emp.setEname(rs.getString(2));
		emp.setSal(rs.getInt(3));
		emp.setJob(rs.getString(4));
		list.add(emp); 
	}
	
	
	//변환 작업(JSON 객체)

	/*  
	[
	 {empno:7788,},
	 {}
	 
	 
	 ]
	*/
	JSONArray jsonlist = JSONArray.fromObject(list); //제이슨으로 바꾸기 
//[{"empno":7369,"ename":"SMITH","job":"CLERK","sal":800},
 //{"empno":7499,"ename":"ALLEN","job":"SALESMAN","sal":1600} ,,,,,,,,
 //기본적으로 데이터는 객체여야한다 
 //
%>
<%= jsonlist %>












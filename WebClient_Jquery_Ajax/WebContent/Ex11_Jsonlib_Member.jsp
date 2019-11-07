<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="kr.or.bit.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Member member = new Member();
//json 형식의 객체 생성: memeber
//String jsondata = "{" + "username" +":" + member.getUsername() ..... 
//위에처럼 무식하게 하지마라 .... >> 편하게 >>
JSONObject obj = JSONObject.fromObject(member); //fromObjec(객체) >> 객체로 자동변환
//한건만 만드는 것 JSONObject  

//여러건을 제이슨으로 만드는것 JSONArray


%>
<%= obj %>
<hr>
<% 
List<Member> memberlist = new ArrayList<>();
memberlist.add(new Member("hong","1004","서울시 강남구","0"));
memberlist.add(new Member("kim","1004","서울시 양천구","1"));
memberlist.add(new Member("park","111","서울시 서초구","0"));
//객체 배열 
JSONArray arrayobj = JSONArray.fromObject(memberlist);

%>
<%= arrayobj %>

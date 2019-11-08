<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>Ex14_include_param.jsp : request 객체를 공유할 수 있다 </h3>
<fieldset>
<legend>include</legend>
request : <%= request.getParameter("type") %><br>
request : <%= request.getParameter("userid") %><br>
<!-- 페이지당 리퀘스트 객체 하나 만든다 
>> include 코드 가져가면 만들어진 리퀘스트 객체를 이 페이지에서도 공유한다  -->
</fieldset>
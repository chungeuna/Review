<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

    
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index
		<!--  타이틀 영역  -->
		
		</title>
		
		<!--  css 설정 가져오기  -->
		<!-- <link href="join.css" type="text/css" rel="stylesheet" /> -->
		<link href="<tiles:getAsString name='css'/>" type="text/css" rel="stylesheet" />
	</head>
	<body>
<!--  header 영억  -->
<tiles:insertAttribute  name="header"/>
<!--  visual 영역  -->
		<div id="main">
			<div class="top-wrapper clear">
		<tiles:insertAttribute name="content"/>
						<!-- aside nav 영역 -->
				<tiles:insertAttribute  name="aside"/>
						<!--  footer 영역 -->
			</div>
		</div>
	<tiles:insertAttribute  name="footer"/>
	</body>
</html>
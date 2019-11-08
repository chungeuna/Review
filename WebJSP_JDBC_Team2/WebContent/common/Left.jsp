<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
/*
	boolean isLogin=false;
	boolean isAdmin=false;
	if(session.getAttribute("userid")!=null ){
		isLogin=true;
		if(session.getAttribute("userid").equals("admin"))
			isAdmin = true ;
	} */
%>
<c:set var="userid" value="${sessionScope.userid}"/>
<c:choose>
	<c:when test="${userid != null}">
		<c:set var="isLogin" value="true"/> 
			<c:choose>
				<c:when test="${userid == 'admin'}">
					<c:set var="isAdmin" value="true"/> 
				</c:when>
				<c:otherwise>
					<c:set var="isAdmin" value="false"/> 
				</c:otherwise>
			</c:choose>	
	</c:when>
	<c:otherwise>
		<c:set var="isLogin" value="false"/> 
	</c:otherwise>
</c:choose>


<!DOCTYPE html>
<html>
<body>
    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="MainPage.jsp">
                <i class="fas fa-home"></i>
                <span>Main</span>
            </a>
        </li>      
        <c:choose>
        <c:when test="${isLogin == 'true'}">
        <li class="nav-item">
            <a class="nav-link" data-toggle="modal" data-target="#logoutModal">
                <i class="fas fa-sign-out-alt"></i>
                <span>Logout</span>
             </a>
        </li>
        </c:when>
       <c:otherwise>
         <li class="nav-item">
            <a class="nav-link" href="LoginPage.jsp">
                <i class="fas fa-sign-in-alt"></i>
                <span>Login</span></a>
        </li>
         <li class="nav-item">
            <a class="nav-link" href="RegisterPage.jsp">
                <i class="fas fa-user-friends"></i>
                <span>Register</span></a>
        </li>
        </c:otherwise>
        </c:choose>
        <c:choose>
        <c:when test="${isAdmin == 'true'}">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-user-shield"></i>
                <span>Admin</span>
            </a>
            <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                <!-- <h6 class="dropdown-header">Login Screens:</h6> -->
                <a class="dropdown-item" href="Admin_MemberList.jsp">Member</a>
            </div>
        </li>
       	</c:when>
       	</c:choose>
    </ul>
    
    <!-- Logout Modal-->
	<c:import url="LogoutModal.jsp"></c:import>
</body>
</html>
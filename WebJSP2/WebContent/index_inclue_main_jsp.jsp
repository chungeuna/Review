<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Self-Introduction</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="css/agency.min.css" rel="stylesheet">
  <style>
    @import url(//fonts.googleapis.com/earlyaccess/hanna.css);

    .kor {
      font-family: 'Hanna', sans-serif;
    }
    table{
      border-collapse: separate;
      border-spacing: 1px;
      text-align: center;
      line-height: 1.5;
      width: 100%;
      overflow: auto;
    }
    th{
      width: 50%;
      
      font-weight: bold;
      vertical-align: top;
      color: #fff;
      background: #212529 ;
    }
    td{
      width: 50%;
      
      vertical-align: top;
      border-bottom: 1px solid #ccc;
      background: #eee;
    }
  </style>

</head>

<body id="page-top">
	<jsp:include page="nav.jsp"></jsp:include>
	<jsp:include page="header.jsp"></jsp:include>
  <!-- Navigation -->
  <!--  
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="#page-top">Wonbo's page</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav text-uppercase ml-auto">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#services">It's me</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#portfolio">Like</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#about">History</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#team">Social</a>
          </li>
          
        </ul>
      </div>
    </div>
  </nav>
-->
  <!-- Header -->
  <!--  
  <header class="masthead">
    <div class="container">
      <div class="intro-text">
        <div class="intro-lead-in">Bit 2Group Wonbo</div>
        <div class="intro-heading text-uppercase">가늘고 길게 가자</div>
        <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#services">Click Here</a>
      </div>
    </div>
  </header>
-->
  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Contact form JavaScript -->
  <script src="js/jqBootstrapValidation.js"></script>
  <script src="js/contact_me.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/agency.min.js"></script>

  <script>
    if(localStorage.getItem("wonmessage")!==null){
      var messages = localStorage.getItem("wonmessage").split(",");
      var senders = localStorage.getItem("wonsender").split(",");
      
      var newtable = document.createElement("table");
      var trhead = document.createElement("tr");
      var th1 = document.createElement("th");
      var th2 = document.createElement("th");
      th1.innerHTML="보낸이";
      th2.innerHTML="메세지";
      trhead.appendChild(th1);
      trhead.appendChild(th2);
      newtable.appendChild(trhead);
      var badge = document.createElement("span");
      badge.setAttribute("class","badge");
      badge.innerHTML = "new";
  
      for(var index in messages){
        var who = senders[index];
        var what = messages[index];
        var newtr = document.createElement("tr");
        var td1 = document.createElement("td");
        td1.innerHTML=who;
        var td2 = document.createElement("td");
        td2.innerHTML=what;
        td1.appendChild(badge);
        
        newtr.appendChild(td1);
        newtr.appendChild(td2);
        newtable.appendChild(newtr);
      }
      document.getElementById("contact").appendChild(newtable);
    }
    </script>

</body>

</html>
    
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE HTML>
<!--
	Hielo by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Login</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="subpage">

		<!-- Header -->
			<header id="header">
<!--				<div class="logo"><a href="index.html">Hielo <span>by TEMPLATED</span></a></div>-->
				<a href="#menu">Menu</a>
			</header>

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">
					<li><a href="index.html">Home</a></li>
					<li><a href="login.jsp">Login</a></li>
					<li><a href="register1.jsp">Register</a></li>
				</ul>
			</nav>

		<!-- One -->
			<section id="One" class="wrapper style3">
				<div class="inner">
					<header class="align-center">
						<p>Eleifend vitae urna</p>
						<h2>Generic Page Template</h2>
					</header>
				</div>
			</section>

		<!-- Two -->
            <div id="main" class="container">
                <div class="row 300%">
                    <div class="6u 12u$(medium)">
                        <h2>Login</h2>
                            <form method="post" id="Post">
                                <div class="row uniform">
                                    <div>
                                        <input type="text" name="email" id="email" value="" placeholder="Email">
                                    </div>
                                    
                                    <div>
                                        <input type="text" name="password" id="password" value="" placeholder="Password">
                                    </div>
                                    
                                    <div>
                                        <input type="text" id="insrand" name="insrand"  maxlength="4" placeholder="請輸入驗證碼">
                                    </div>
                                    
                                    <div>
                                    	<label for="insrand" id="rand"></label>
                                    </div>
                                    
                                </div><br>
                                <ul class="actions fit small">
                                    <li>
                                        <a href="#" onclick="mail();" class="button alt fit small" style="width: 110px;position: absolute;left: 790px;top:525px;text-align: center">忘記密碼</a>
                                    </li>
                                </ul>
                                <ul class="actions fit small">
                                    <li>
                                        <a href="#" onclick="creatrand();" class="button alt fit small" style="width: 150px;position: absolute;left: 1028px;top:525px;text-align: center">重新產生驗證碼</a>
                                    </li>
                                </ul>
                                <input type="button" onclick="post();" name="button" value="登入" style="position: absolute;left: 1250px;top: 525px">
                                <input type="reset" value="清除" style="position: absolute;left: 1350px;top: 525px">
                            </form>
                    </div>
                </div>
            </div>
		<!-- Footer -->
			<footer id="footer">
				<div class="container">
					<ul class="icons">
						<li><a href="https://twitter.com/?lang=zh-tw" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="https://www.facebook.com/" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="https://www.instagram.com/" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
					</ul>
				</div>
				<div class="copyright">
					&copy; Untitled. All rights reserved.
				</div>
			</footer>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			<script language="javascript">

var rand=document.getElementById("rand"); 
var insrand=document.getElementById("insrand");

creatrand();

function creatrand(){
    var newrand="";
    for(var i=0;i<4;i++){
    	newrand+=(Math.floor(Math.random()*9+1)).toString();
    }   
    rand.innerHTML=newrand;
}

function post() {
   var randval=rand.innerHTML;
   var insrandval=insrand.value;
   if(randval==insrandval) {
  		Post.action = "LoginServlet";
  		Post.submit();
	}else{
  		alert("驗證碼輸入錯誤!");
	}
}

function mail() {
	Post.action = "MailServlet";
	Post.submit();
}

</script>
			

	</body>
</html>
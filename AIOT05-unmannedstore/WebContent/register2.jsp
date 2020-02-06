<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<!--
	Hielo by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Register</title>
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
					<li><a href="index.html">首頁</a></li>
					<li><a href="login.jsp">登入</a></li>
					<li><a href="register1.jsp">註冊</a></li>
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
                <div class="row 300%" style="left: 500px">
                    <div class="6u 12u$(medium)">
                        <h2 style="position: absolute;left: 650px">Register</h2>
                        <h3 style="position: absolute;left: 670px;top: 470px">已經將驗證碼寄於${sessionScope.email}</h3>
                        <h3>測試用驗證碼提示: ${sessionScope.VerificationCode}<br></h3>
                            <form id="Post" method="post">
                                <div >
                                    <div>
                                        <input type="text" id="VerificationCode" name="VerificationCode" value="" placeholder="請輸入驗證碼" style="width: 250px; position: absolute;left: 800px;top: 522px">
                                    </div>
                                    <span id="codeMsg" style="position:absolute;left:825px;top:578px;font-size:14px;color:red"></span>
                                    <span id="imgMsg" style="position:absolute;left:800px;top:580px"></span>
                                    
                                </div><br>

                                <input type="button" onclick="post();"  value="下一步" style="position: absolute;left: 1060px;top: 522px">
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
				function post() {
				   var VerificationCodeval=VerificationCode.value;
				   if(VerificationCodeval=="${sessionScope.VerificationCode}") {
				  		Post.action = "register3.jsp";
				  		Post.submit();
					}else{
						$("#imgMsg").html("<img src='images/icon1.png' style='width:20px;height:20px'>")
				  		$("#codeMsg").html("驗證碼輸入錯誤!");
					}
				}
			</script>

	</body>
</html>
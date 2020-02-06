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
		<title>Shopping</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
		
		<style>
			table th{
				vertical-align: middle;
				text-align:center;
			}
			td{
				vertical-align: middle;
				text-align:center;
			}
		</style>
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
			
			
			<h3><img style="width: 40px; height: 40px;" alt="" src="images/icon5.png" align="center">已購買數量 ${sessionScope.cartsize}</h3>
			
			<a href="CartServlet"><img style="width: 60px; height: 60px;position:absolute;left:1400px;" alt="" src="images/icon3.png" align="left" ></a><br>	        
				                
			
			<div class="table-wrapper">
			    <div align="center" id="main" class="container">
			        <table class="alt">
			            <caption><h2>關東煮</h2></caption>
			            <tr>
			                <th>商品圖片</th>
			                <th>商品名稱</th>
			                <th>商品價格</th>
			                <th>商品數量</th>
			                <th>商品資訊</th>
			                <th></th>
			            </tr>
			            <c:forEach var="good" items="${goods}">
			                <tr>
			                    <td ><img style='width: 104px; height: 142px;' src='<c:out value="${good.img}" />' /></a></td>
			                    <td ><c:out value="${good.name}" /></td>
			                    <td ><c:out value="${good.price}" /></td>
			                    <td ><c:out value="${good.quantity}" /></td>
			                    <td ><c:out value="${good.information}" /></td>
			                    <td>
			                    	
			                    	<a href='buyServlet?good=${good.id}'><input type="image" src="images/icon2.png" style="width:40px;height:40px"></a>   
			                    	                	
			                    </td>
			                </tr>
			            </c:forEach>
			        </table><br>
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
	</body>
</html>
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
                <div class="row 300%" style="left: 500px">
                    <div class="6u 12u$(medium)">
                        <h2 style="position: absolute;left: 550px;top: 350px">Register</h2>
                        <h3 style="position: absolute;left: 570px;top: 400px">基本資料</h3>
                            <form id="Post" method="post">
                                <div >
                                    <div>
                                        <h4 style="position: absolute;left: 750px;top: 370px">姓名:</h4>
                                        <input type="text" name="name" id="name" value="" placeholder="姓名" style="width: 250px; position: absolute;left: 800px;top: 360px">
                                        <span id="nameMsg"></span>
                                        
                                        <h4 style="position: absolute;left: 740px;top: 450px">Email:</h4>
                                        <input type="text" name="email" id="email" value="${sessionScope.email}" readonly="readonly" style="width: 250px; position: absolute;left: 800px;top: 440px">
                                        
                                        <h4 style="position: absolute;left: 697px;top: 530px">請輸入密碼:</h4>
                                        <input type="text" name="password" id="password" value="" placeholder="請輸入密碼" style="width: 250px; position: absolute;left: 800px;top: 520px">
                                        <span id="checkpwd2" style="position:absolute;left:800px;top:575px;color:darkgray;font-size:14px">(至少6個字且必須包含英文、數字)</span>
                                        <span id="checkpwd"></span>

                                        
                                        <h4 style="position: absolute;left: 660px;top: 610px">請再次輸入密碼:</h4>
                                        <input type="text" name="chkpass" id="chkpass" value="" placeholder="請再次輸入密碼" style="width: 250px; position: absolute;left: 800px;top: 600px">
                                        
                                        <h4 style="position: absolute;left: 1145px;top: 383px">出生年月日:</h4>
                                        <input type="date" name="date" id="date" value="" placeholder="出生年月日" style="width: 250px; position: absolute;left: 1250px;top: 380px">
                                        
                                        <h4 style="position: absolute;left: 1165px;top: 450px">行動電話:</h4>
                                        <input type="text" name="mobile" id="mobile" value="" placeholder="請輸入行動電話" style="width: 250px; position: absolute;left: 1250px;top: 440px"/>
                                        <span id="mobileMsg"></span>
                                        
                                        <h4 style="position: absolute;left: 1125px;top: 530px">好友推薦代碼:</h4>
                                        <input type="text" name="friendcode" id="friendcode" value="" placeholder="請輸入好友推薦代碼" style="width: 250px; position: absolute;left: 1250px;top: 520px">
                                        
                                        <h4 style="position: absolute;left: 1145px;top: 600px">上傳大頭照:</h4>
                                        <input type="file" name="memberimg" id="memberimg" value="" style="width: 250px; position: absolute;left: 1250px;top: 600px">
                                    </div>
                                    
                                </div><br>

                                <input type="button" name="button" value="下一步" style="position: absolute;left: 950px;top: 670px" onclick="chk();">
                                <input type="reset" value="清除" style="position: absolute;left: 1070px;top: 670px">
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
				
				var chk1=false;
				var chk2=false;
				var chk3=false;
			
				document.getElementById("mobile").addEventListener("blur",checkSubmitMobil);
				function checkSubmitMobil() {
					
				    if ($("#mobile").val() == "") {
				               $("#mobileMsg").html("<img src='images/icon1.png' style='position:absolute;width:20px;height:20px;left:1250px;top:493px'></img><span style='position: absolute;left: 1275px;top: 492px; color:red; font-size:14px'>手機號碼不能為空</span>");          
				    $("#mobile").focus();
				  }
				    else{
						$("#mobileMsg").html("");
						chk1=true;
				    }
				    
				    if (!$("#mobile").val().match(/^[09]{2}[0-9]{8}$/)) {
				         $("#mobileMsg").html("<img src='images/icon1.png' style='position:absolute;width:20px;height:20px;left:1250px;top:493px'><span style='position: absolute;left: 1275px;top: 492px; color:red; font-size:14px'>手機號碼格式不正確,請重新輸入</span>");
				        $("#mobile").focus();
				        }
				    else{
				    	$("#mobileMsg").html("");
				    	chk1=true;
				    }

				 }
				
				document.getElementById("name").addEventListener("blur",checkName);
				function checkName(){
					
					if($("#name").val()==""){
						$("#nameMsg").html("<img src='images/icon1.png' style='position:absolute;width:20px;height:20px;left:800px;top:413px'><span style='position: absolute;left: 825px;top: 412px; color:red; font-size:14px'>尚未輸入姓名</span>")
						$("#name").focus();
					}
					else{
						$("#nameMsg").html("");
						chk2=true;
					}
				}
				
				document.getElementById("password").addEventListener("blur",checkpwd);
				function checkpwd(){
					
	                let thePwdVal=document.getElementById("password").value;
	                let thePwdLen=document.getElementById("password").value.length;
	                let flag1=false,flag2=false;
	                let x;

	                if(thePwdVal==""){
	                	$("#checkpwd2").html("");	                    
	                	$("#checkpwd").html("<img src='images/icon1.png' style='position:absolute;width:20px;height:20px;left:800px;top:575px'><span style='position:absolute;left:825px;top:573px;color:red;font-size:14px'>密碼未輸入</span>")
	                	$("#password").focus();
	                }else if(thePwdLen>=6){

	                    for (i=0;i<=thePwdLen;i++){
	                        let ch=thePwdVal.charAt(i).toUpperCase()
	                        if(ch>="A" && ch<="Z"){
	                            flag1=true;
	                        }
	                        else if (ch>="0" && ch<="9"){
	                            flag2=true;
	                        } 
	                        if (flag1 && flag2){
	                            break;
	                        }
	                    }
	                    if (flag1 && flag2){
	                    	$("#checkpwd2").html("");
	                    	$("#checkpwd").html("");
	                    	chk3=true;
	                    }else{ 
	                    	$("#checkpwd2").html("");
		                    $("#checkpwd").html("<img src='images/icon1.png' style='position:absolute;width:20px;height:20px;left:800px;top:575px'><span style='position:absolute;left:825px;top:573px;color:red;font-size:14px'>密碼不符合規則</span>");
		                    $("#password").focus();
	                    }
	                }
	                else{
	                	$("#checkpwd2").html("");
	                    $("#checkpwd").html("<img src='images/icon1.png' style='position:absolute;width:20px;height:20px;left:800px;top:575px'><span style='position:absolute;left:825px;top:573px;color:red;font-size:14px'>密碼不可少於6個字</span>")
	                    $("#password").focus();
	                } 	                
	            }
				
				function chk(){
					console.log(chk1);
					console.log(chk2);
					console.log(chk3);
					if(chk1&&chk2&&chk3){
						Post.action="insertServlet"; 
						Post.submit();
					}else{
						alert("失敗");
					}
					

				}
			</script>
	</body>
</html>
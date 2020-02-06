<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>歡迎! ${sessionScope.loginaccount}</h3>
<a href="">顧客帳號管理</a><br>
<a href="">顧客購買紀錄</a><br>
<a href="shoppingServlet">購物商城預覽</a><br>
<a href="">平台商品管理</a><br>
<a href="tempServlet">店內環境監控</a><br>
<a href="LogoutServlet">帳號登出</a><br>
</body>
</html>
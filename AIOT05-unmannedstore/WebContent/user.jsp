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
<a href="editAccountServlet">帳號管理</a><br>
<a href="">點數儲值</a><br>
<a href="">購買紀錄</a><br>
<a href="shoppingServlet">購物商城</a><br>
<a href="LogoutServlet">帳號登出</a><br>
</body>
</html>
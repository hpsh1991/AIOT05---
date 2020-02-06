<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>無人商店</title>
<style type="text/css">
	table,td,tr,th{
		border-collapse: collapse;
		border: 2px solid black;
		color:black;
		font-size: 25px;
		padding:15px;
	}
</style>
</head>
<body>
<table style="text-align: left; width: 254px; height: 94px;" border="0" cellpadding="2" cellspacing="2">
	<tbody>
		<h3>${sessionScope.message}</h3>            
    	<tr>                
	        <td style="vertical-align: top; width: 115px;">
	        	<img style="width: 99px; height: 82px;" alt="" src="images/shoppingCart.png" align="left">
	        </td>                
	        <td style="vertical-align: middle; text-align: center; width: 1245px;">
	        	<a href="CartServlet">已購買 ${sessionScope.cartsize}</a><br>	        	                
	        </td>            
        </tr>        
	</tbody>    
</table>
    <div align="center">
        <table >
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
                    <td><img style='width: 104px; height: 142px;' src='<c:out value="${good.img}" />' /></a></td>
                    <td><c:out value="${good.name}" /></td>
                    <td><c:out value="${good.price}" /></td>
                    <td><c:out value="${good.quantity}" /></td>
                    <td><c:out value="${good.information}" /></td>
                    <td>
                    	<a href='buyServlet?good=${good.id}'>加入購物車</a>                   	
                    </td>
                </tr>
            </c:forEach>
        </table><br>
</body>
</html>
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
            <caption><h2>購物車</h2></caption>
            <tr>
                <th>商品圖片</th>
                <th>商品名稱</th>
                <th>商品單價</th>
                <th>商品數量</th>
                <th>商品小計</th>
                <th></th>
            </tr>
            <c:forEach var="cart" items="${newlistcart}">
                <tr>
                    <td><img style='width: 104px; height: 142px;' src='<c:out value="${cart.img}" />' /></a></td>
                    <td><c:out value="${cart.name}" /></td>
                    <td><c:out value="${cart.price}" /></td>
                    <td><c:out value="${cart.quantity}" /></td>
                    <td><c:out value="${cart.total}" /></td>
                    <td>
                    	<a href=''>刪除商品</a>                   	
                    </td>
                </tr>
            </c:forEach>
            <tr>
            	<td>商品總金額</td>
            	<td><c:out value="${totalprice}" /></td>
         	</tr>
        </table><br><br><br>
        <input type="button" onclick=""  value="結帳" >
</body>
</html>
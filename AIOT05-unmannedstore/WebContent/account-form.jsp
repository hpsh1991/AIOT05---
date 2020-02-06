<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User Management Application</title>

</head>
<body>
	<div>
		<div>
			<img style='width: 40px; height: 40px;' src='<c:out value="${account.memberimg}" />' /></a><br>
			<p><c:out value='${account.name}' /></p>
			<p>帳戶餘額</p><br>
			<p>NT$ ${account.memberpoints}</p><br>
		</div>
		<div>
			<a href="">更改密碼</a><br>
		    <c:if test="${account.memberrank == 2}">
		    	<a href="SMSServlet?phone=${account.phone}">驗證手機</a><br>
			</c:if>
			<a href="">點數儲值</a><br>
		</div>
		
	</div>      
    <div>
        <table>
            <caption>
            	<h2>帳號資訊</h2>
            </caption>           
            <tr>
                <th>姓名</th>
                <td>
                	<input type="text" name="name" size="40" readonly="readonly"
                			value="<c:out value='${account.name}' />"
                		/>
                </td>
            </tr>       
            <tr>
                <th>電子信箱</th>
                <td>
                	<input type="text" name="email" size="40" readonly="readonly"
                			value="<c:out value='${account.email}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>手機號碼</th>
                <td>
                	<input type="text" name="email" size="40" readonly="readonly"
                			value="<c:out value='${account.phone}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>出生年月日</th>
                <td>
                	<input type="text"  size="40" readonly="readonly"
                			value="<c:out value='${account.birthday}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>會員代碼</th>
                <td>
                	<input type="text" size="40" readonly="readonly"
                			value="<c:out value='${account.membercode}' />"
                	/>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>

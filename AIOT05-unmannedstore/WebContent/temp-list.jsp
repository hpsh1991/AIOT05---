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
<div align="center">
        <table>
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>紀錄時間</th>
                <th>室內溫度</th>
                <th>室內溼度</th>
                <th>冷藏櫃(飲品01)</th>
                <th>冷藏櫃(飲品02)</th>
                <th>冷藏櫃(飲品03)</th>
                <th>冷藏櫃(飲品04)</th>
                <th>煙霧偵測</th>
            </tr>
            <c:forEach var="temp" items="${listTemperatures}">
                <tr>
                    <td><c:out value="" /></td>
                    <td><c:out value="${temp.indoor_temp}℃" /></td>
                    <td><c:out value="${temp.humidity}%" /></td>
                    <td><c:out value="${temp.drink01_temp}℃" /></td>
                    <td><c:out value="${temp.drink02_temp}℃" /></td>
                    <td><c:out value="${temp.drink03_temp}℃" /></td>
                    <td><c:out value="${temp.drink04_temp}℃" /></td>
                    <td><c:out value="${temp.MQ_2}" /></td>
                    <td>                 	
                    </td>
                </tr>
            </c:forEach>
        </table><br>
</body>
</html>
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
<h3>測試用驗證碼提示: ${sessionScope.phoneCode}</h3><br>
<h3>已經將驗證碼寄於${sessionScope.phone}</h3><br>
<form id="Post" method="post">
	<input type="text" id="phoneCode" name="phoneCode"  placeholder="請輸入驗證碼" ><br>
	<input type="button" onclick="post();"  value="下一步"><br>
</form>
<script language="javascript">
	function post(){
		var phoneCodeVal=phoneCode.value;
		if(phoneCodeVal=="${sessionScope.phoneCode}"){
	  		Post.action = "updateRankServlet";
	  		Post.submit();
		}else{
			alert("驗證碼輸入錯誤!");
		}
	}
</script>
                                
</body>
</html>
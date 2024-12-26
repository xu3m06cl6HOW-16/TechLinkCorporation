<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>密碼重設</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>

	<h1>歡迎使用登入系統</h1>
	<form method="post" action="<%=request.getContextPath()%>/users/reset">
		<input type="text" name="userAccount" placeholder="請輸入用戶帳號"> <br>
		<input type="text" name="email" placeholder="請輸入用戶信箱"> <br>
		<input type="submit" id="reset" value="發送新密碼至我的信箱">
	</form>
	
	<script type="text/javascript">
	 window.onload = function(){
		 $('#reset').click(function() {
		      alert("已發送至郵件!");
		    });
	 }
	
	</script>

</body>
</html>
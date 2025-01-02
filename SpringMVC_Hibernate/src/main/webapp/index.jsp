<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員登入系統</title>

<style type="text/css">
th,td{
	border: solid 1px black
}
</style>

</head>
<body>

	<div class="container">
		<h1>歡迎使用登入系統</h1>
		<form method="post" action="<%=request.getContextPath()%>/users/login">
			<input type="text" name="email" placeholder="請輸入用戶信箱"> <br> <input type="text"
				name="passWord" placeholder="請輸入用戶密碼"> <br> <input type="submit" value="登入">
		</form>
		
		<form method="post" action="<%=request.getContextPath()%>/regist">
			<input type="submit" value="註冊">
		</form>
		<form method="post" action="<%=request.getContextPath()%>/reset">
			<input type="submit" value="忘記密碼">
		</form>
		
	</div>
	
	<c:if test = "${ user!=null }">
		<div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">姓名</th>
						<th scope="col">帳號</th>
						<th scope="col">信箱</th>
						<th scope="col">註冊日期</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">${ user.userId }</th>
						<td>${ user.userName }</td>
						<td>${ user.userAccount }</td>
						<td>${ user.userEmail }</td>
						<td>${ user.userCreateDate }</td>
					</tr>
				</tbody>
			</table>
		</div>
	</c:if>
	

</body>
</html>